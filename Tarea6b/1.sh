#!/bin/bash
clear
dir=$1
maxlin=`cat nombres.txt | wc -l`
linea=1
while [ $linea -lt $maxlin ]; do
   user=`cat nombres.txt | head -${linea} | tail -1`
   mkdir $user
   cd $user
   for i in `seq 1 $dir`; do
       mkdir personal$i
   done
   cd ../
   linea=`expr $linea + 1`
done
