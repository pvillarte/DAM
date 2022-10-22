#Ejercicio 10:  Implementa un método Python llamado mayorYmenor, el cual recibe como parámetro una tabla
#  de Strings y muestra por pantalla el String con mayor longitud y el String con menor longitud.

tabla=[["mag","rgr"],["frgbbtfe","vtg"],["grg","rf","fdf"]]

def mayorYmenor(tab):
    largo=tab[0][0]
    corto=tab[0][0]
    for f in tab:
        for c in f:
            if len(c)>len(largo):
                largo=c
            if len(c)< len(corto):
                corto=c
    print(f"El mas largo es {largo}")
    print(f"El mas corto es {corto}")

mayorYmenor(tabla)