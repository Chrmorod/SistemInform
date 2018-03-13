#!/bin/bash
clear
read -p "Introduzca un valor que no sea menor que 0: " num1
while [ $num1 -lt 0 ]; do
read -p "Valor no permitido, introduzca otro valor: " num1
done
res=`expr $num1 % 2`
if [ $res -eq 0 ]; then
    echo "El numero $num1 es un numero par"
else
    echo "El numero $num1 es un numero impar"
fi





