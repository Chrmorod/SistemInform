#!/bin/bash
clear
linea=1
prom=0
precip=`cat precipitaciones.txt | wc -l`
while [ $linea -le $precip ]; do
    preplin=`cat precipitaciones.txt | head -${linea} | tail -1 | awk '{print $2}'`
    prom=`expr $prom + $preplin`
    linea=`expr $linea + 1`
done
media=$(echo "scale=2; $prom / $precip"|bc)
echo "La media de las $precip precipitaciones es $media"
