#!/bin/bash
clear
read -p "Introduce un valor mayor que 0: " val1
while [ $val1 -le 0 ]; do
    read -p "Valor incorrecto, por favor introduzca otro valor: " val1
done
for i in `seq 0 $val1`; do
    echo "$i"
done
