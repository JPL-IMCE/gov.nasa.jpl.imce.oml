#!/bin/bash

awk '
BEGIN {flag=1}
/\[INFO\]\ Reactor\ Build\ Order:/{flag=0;print;next}
/(Down|Up)loading:/{flag+=1;next}
/Downloaded:/{flag-=1;next}
/Uploaded:/{flag-=1;if(flag>0)print}
/Progress.*/{next}
{if(flag==0) print; else next;}'
