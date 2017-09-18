#!/bin/bash

awk '
BEGIN {flag=0}
/Progress\ \([1-9][0-9]*\):/{next}
/\[INFO\]\ Fetching\ /{next}
/\[INFO\]\ Resolving\ /{next}
/\[apply\]\ (\*|\{|\})/{next}
/\[apply\]\ > (Host|Authorization|User-Agent|Accept|Content-Length|Expect):/{next}
/\[apply\]\ < (Server|Date|Content-Type|Transfer-Enc.*|Connection):/{next}
/(Down|Up)loading:/{flag+=1;next}
/Downloaded:/{flag-=1;next}
/Uploaded:/{flag-=1;if(flag>0)print}
/\[INFO\]\ Reactor\ Build\ Order:/{flag=0;print;next}
{if(flag==0) print; else next;}'
