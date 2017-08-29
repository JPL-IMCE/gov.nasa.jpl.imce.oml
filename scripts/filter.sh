#!/bin/bash

awk '
BEGIN {flag=0}
/\[INFO\]\ Fetching\ /{next}
/\[INFO\]\ Resolving\ /{next}
/\[apply\]\ (\*|\{|\})/{next}
/\[apply\]\ > (Host|Authorization|User-Agent|Accept|Content-Length|Expect):/{next}
/\[apply\]\ < (Server|Date|Content-Type|Transfer-Enc.*|Connection):/{next}
/(Down|Up)loading:/{flag+=1;next}
/Downloaded:/{flag-=1;next}
/Uploaded:/{flag-=1;if(flag>0)print}
{if(flag==0) print; else next;}'
