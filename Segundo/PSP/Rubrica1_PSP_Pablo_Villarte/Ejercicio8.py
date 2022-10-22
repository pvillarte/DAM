#Ejercicio 8:  Implementa un programa Python con un método llamado sum(int [] tabla) que muestre por 
# pantalla el resultado de sumar todos los elementos de la tabla pasada como parámetro.

tabla = [[1,2,3],[2,3,4],[2,2,2]]

suma =0

for l in tabla:
    suma += sum(l)

print(f"{suma}") 