#!/bin/bash
clear
read -p "Por favor, introduzca un día numerico del mes: " dia
while [ $dia -le 0 ] || [ $dia -gt 30 ]; do
    read -p "Valor incorrecto, introduzca de nuevo un dia numerico del mes" dia
done
for i in `seq 1 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Lunes de este mes."
	 fi
done
for i in `seq 2 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Martes de este mes."
	 fi
done
for i in `seq 3 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Miercoles es de este mes."
	 fi
done
for i in `seq 4 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Jueves es de este mes."
	 fi
done
for i in `seq 5 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Viernes es de este mes."
	 fi
done
for i in `seq 6 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Sabado es de este mes."
	 fi
done
for i in `seq 7 7 30`; do
	 if [ $dia -eq $i ]; then
	     echo "El $dia es Domingo es de este mes."
	 fi
done
