# Ejercicio 9:  Implementa un programa Python con un método llamado indexContains(String[] tabla, String
#  cadena) que devuelva el índice de la tabla cuyo valor es igual al valor de “cadena”. En caso de no
#  haber ningún valor igual, devuelve -1


tabla=[["mag","rgr"],["frgfe","vtg"],["grg","frf","fdf"]]
cadena = "vtg"

def indexContains(tab, cad):
    for fila in tab:
        if (cad in fila):
            return tab.index(fila)
    return -1

print(indexContains(tabla, cadena))