#! /bin/bash

# Aquest programa realitza els tests d'un programa en Python
if [ ${#@} -ne 1 ];
then
    echo "Ús: $0 programa.py"
    echo "$0 redireccionarà tots els fitxers anomenats entrada*.txt contra programa.py i compararà la seva sortida amb el corresponent sortida_esperada*.txt"
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
    python3 $1 < $fitxer_entrada | diff - $fitxer_sortida
    if [[ "$?" != "0" ]];
    then
        echo "S'ha trobat un error amb la prova $fitxer_entrada"
        exit 1
    fi
done
