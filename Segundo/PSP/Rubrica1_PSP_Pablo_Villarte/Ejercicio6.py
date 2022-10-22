#Ejercicio 6:  Implementa un programa Python que solicite al usuario una cadena de caracteres (String) y 
# muestre por pantalla dicha cadena, pero con el primer y último carácter cambiados de posición.

cadena = input("introduce un texto:")

cadena2 = cadena[-1]+cadena[1:-1]+cadena[0]
print(cadena2)