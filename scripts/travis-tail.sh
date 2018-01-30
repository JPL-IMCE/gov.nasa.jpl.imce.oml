#!/usr/bin/env bash

# Similar to travis_wait except that it also tails the output of the command to show progress.
# See: https://docs.travis-ci.com/user/common-build-problems/#Build-times-out-because-no-output-was-received
# See: https://github.com/travis-ci/travis-build/blob/master/lib/travis/build/templates/header.sh

travis_tail() {
  local timeout=$1
  shift

  local cmd="$@"
  local log_file=travis_wait_$$.log
  echo "# Log of $cmd" > $log_file

  $cmd >>$log_file 2>&1 &
  local cmd_pid=$!

  tail -f $log_file &

  travis_jigger $timeout $! $cmd &
  local jigger_pid=$!
  local result

  { wait $cmd_pid 2>/dev/null; result=$?; ps -p$jigger_pid 2>&1>/dev/null && kill $jigger_pid; } || exit 1
  exit $result
}

travis_jigger() {
  local timeout=$1 # in minutes
  shift

  local count=0

  local cmd_pid=$1
  shift

  while [ $count -lt $timeout ]; do
    count=$(($count + 1))
    echo -e "...\n\033[0m# [LOG] Still running ($count of $timeout): $@\n..."
    sleep 60
  done

  echo -e "\n\033[31;1mTimeout reached. Terminating $@\033[0m\n"
  kill -9 $cmd_pid
  exit -1
}
