#! /bin/bash

# Aquest programa realitza els tests d'un programa en Java
if [ ${#@} -ne 1 ];
then
    echo "Ús: $0 Programa"
    echo "$0 redireccionarà tots els fitxers anomenats entrada*.txt contra el Programa d'entrada i compararà la seva sortida amb el corresponent sortida_esperada*.txt"
    exit 1
fi
programa=${1%%.*}
if [ ! -f "$programa.class" ];
then
    echo "Comprova si has compilat $programa.java"
    exit 1
fi

if [ "$programa.java" -nt "$programa.class" ];
then
    echo "Comprova si has recompilat $programa.java després de modificar-lo"
    exit 1
fi

numproves=`ls entrada*.txt 2> /dev/null | wc -l`

if [ "$numproves" -eq 0 ];
then
    echo "No es troba cap fitxer per fer proves"
    exit 1
fi

for fitxer_entrada in entrada*.txt;
do
    echo "Comprovant test $fitxer_entrada"
    fitxer_sortida=sortida_esperada${fitxer_entrada##entrada}
    if [ ! -f $fitxer_sortida ];
    then
        echo "Error: no es troba el fitxer $fitxer_sortida"
        exit 1
    fi
    java $programa < $fitxer_entrada | diff - $fitxer_sortida
    if [[ "$?" != "0" ]];
    then
        echo "S'ha trobat un error amb la prova $fitxer_entrada"
        exit 1
    fi
done
echo "Proves superades"
