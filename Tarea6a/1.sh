#!/bin/bash
clear
read -p "Introduce un valor: " valor1
read -p "Introduce un segundo valor: " valor2
if [ $valor1 -gt $valor2 ]; then
    echo "$valor1 es mayor que $valor2"
elif [ $valor1 -lt $valor2 ]; then
    echo "$valor1 es menor que $valor2"
else
    echo "$valor1 es igual que $valor2"
fi
