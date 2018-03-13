#!/bin/bash
clear
dir=$1
if [ -d "$dir" ]; then
cd $dir
linea=1
list=`ls | grep ".txt$" | wc -l`
while [ $linea -le $list ]; do
    borfil=`ls | grep ".txt$" | head -${linea} | tail -1 `
    rm $borfil
    linea=`expr $linea + 1`
done
echo "Se han borrado `expr $linea - 1` ficheros de extension .txt"
else
echo "EL directorio no existe"
fi
