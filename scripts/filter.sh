#!/bin/bash

awk '
BEGIN {flag=0}
/\[ERROR\].*/{print}
/(Down|Up)loading:.*/{flag+=1;next}
/Downloaded:.*/{flag-=1;next}
/Uploaded:.*/{flag-=1;if(flag>0)print}
/\[INFO\]\ Fetching\ [^ ]*\ from\ [^ ]*\ \(.*\ at\ [^ ]*\)/{next}
/\[INFO\]\ Fetching\ .*/{next}
{if(flag==0) print; else next;}'
