#!/bin/bash
clear
read -p "Introduzca un valor de nota: " nota1
while [ $nota1 -lt 0 ] || [ $nota1 -gt 10 ]; do
read -p "Valor incorrecto, por favor introduzca un valor de nota correcto: " nota1
done
if [ $nota1 -lt 5 ]; then
    echo "La nota introducida es $nota1 es un suspenso"
elif [ $nota1 -ge 5 ] && [ $nota1 -lt 7 ]; then
    echo "La nota introducida es $nota1 es un aprobado"
elif [ $nota1 -ge 7 ] && [ $nota1 -lt 9 ]; then
    echo "La nota introducida es $nota1 es un notable"
else
    echo "La nota introducida es $nota1 es un sobresaliente"
fi
