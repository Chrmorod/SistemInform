#!/bin/bash
clear
for i in `seq 1 254`; do
    data=`ping -c 1 192.168.1.$i | grep "^1" | awk '{print $4}'`
    if [ $data = 1 ]; then
	echo "la dirección IP 192.168.1.$i existe"
    else
	echo "la dirección IP 192.168.1.$i no existe"
    fi
done

	
	
