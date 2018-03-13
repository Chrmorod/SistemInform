#!/bin/bash
clear
linea=1; countLinux=0; countWindows=0; countproLi=0; countproWi=0;
list=`cat listado.txt | wc -l`
while [ $linea -le $list ]; do
    si=`cat listado.txt | head -${linea} | tail -1 | awk '{print $2}'`
    proces=`cat listado.txt | head -${linea} | tail -1 | awk '{print $3}'`
    if [ "$si" = "Linux" ]; then
	countLinux=`expr $countLinux + 1`
	countproLi=`expr $countproLi + $proces`
    else
	countWindows=`expr $countWindows + 1`
	countproWi=`expr $countproWi + $proces`
    fi
linea=`expr $linea + 1`
done
echo "Linux --> users: $countLinux proc: $countproLi"
echo "Windows --> users: $countWindows proc: $countproWi"
