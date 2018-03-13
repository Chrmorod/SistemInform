#!/bin/bash
clear
linea=1
maxlin=`cat numeros.txt | wc -l`
while [ $linea -le $maxlin ]; do
	num=`cat numeros.txt | head -${linea} | tail -1`
	if [ `expr $num % 2` -eq 0 ]; then
	echo "$num" >> par.txt
	else
	echo "$num" >> impar.txt
	fi
	linea=`expr $linea + 1`
done
echo "-------Numeros Pares-------"
cat par.txt
echo "-------Numeros Impares-----"
cat impar.txt
