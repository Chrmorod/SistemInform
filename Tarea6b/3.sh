#!/bin/bash
clear
linea=1
precip=`cat precipitaciones.txt | wc -l`
while [ $linea -le $precip ]; do
    preplin=`cat precipitaciones.txt | head -${linea} | tail -1 | awk '{print $2}'`
    dialin=`cat precipitaciones.txt | head -${linea} | tail -1 | awk '{print $1}'`
    if [ $preplin -eq 0 ]; then
	for i in `seq 1 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Lunes dia $dialin no llovió."
	 fi
	done
	for i in `seq 2 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Martes dia $dialin no llovió."
	 fi
	done
	for i in `seq 3 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Miercoles dia $dialin no llovió."
	 fi
	done
	for i in `seq 4 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Jueves dia $dialin no llovió."
	 fi
	done
	for i in `seq 5 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Viernes dia $dialin no llovió."
	 fi
	done
	for i in `seq 6 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "El Sabado dia $dialin no llovió."
	 fi
	done
	for i in `seq 7 7 30`; do
	 if [ $dialin -eq $i ]; then
	     echo "EL Domingo dia $dialin no llovió."
	 fi
	done
    fi
linea=`expr $linea + 1`
done
	
