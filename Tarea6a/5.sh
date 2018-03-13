#!/bin/bash
clear
sum=0
cont=0
read -p "Introduzca un valor para añadir a la suma: " num1
while [ $num1 -ne 0 ]; do
    sum=`expr $sum + $num1`
    cont=`expr $cont + 1`
    read -p "Introduzca un valor para añadir a la suma: " num1
done
echo "El valor de la suma es $sum"
med=`expr $sum / $cont`
echo "El valor de la suma es $med"
