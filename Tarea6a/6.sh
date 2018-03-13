#!/bin/bash
clear
cant=0
resol=0
read -p "Introduzca la cantidad de litros de agua consumidos: " lit
while [ $lit -le 0 ]; do
    read -p "Cantidad incorrecta, introduzca de nuevo la cantidad de litros de agua consumidos: " lit
done
if [ $lit -le 50 ]; then
    resol=$(echo "$resol+20.00"|bc)
    echo "20.00 €---- cuota primeros 50 litros"
    echo "____________\n"
    echo "$resol €-----Total a pagar"
elif [ $lit -le 200 ]; then
    res=`expr $lit - 50`
    cal=$(echo "$res*0.20"|bc)
    echo "20.00 €---- cuota primeros 50 litros"
    echo "$cal €---- cuota 0.20/l hasta 200 litros"
    resol=$(echo "$cal+20"|bc)
    echo "____________\n"
    echo "$resol €-----Total a pagar"
else
    res=`expr $lit - 50`
    if [ $res -le 200 ]; then
	cal=$(echo "scale=2; $res*0.20"|bc)
	echo "20.00 €---- cuota primeros 50 litros"
	echo "$cal €---- cuota 0.20/l hasta 200 litros"
	resol=$(echo "$cal+20"|bc)
	echo "____________\n"
	echo "$resol €-----Total a pagar"
    else
	echo "20.00 €---- cuota primeros 50 litros"
	res=`expr $res - 200`
	cal=$(echo "200*0.20"|bc)
	echo "$cal €---- cuota 0.20/l hasta 200 litros"
	cal2=$(echo "$res*0.10"|bc)
	echo "$cal2 €---- cuota 0.10/l por encima de 200 litros (restantes)"
	resol2=$(echo "$cal + $cal2"|bc)
	resol=$(echo "$resol2+20"|bc)
	echo "____________\n"
	echo "$resol €-----Total a pagar"
    fi
fi
    
