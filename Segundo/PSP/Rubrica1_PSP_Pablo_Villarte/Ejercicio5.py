#Ejercicio 5:  Implementa un programa Python que solicite al usuario una cadena de caracteres (String) 
# y muestre por pantalla el número de veces que aparece la sub-cadena “aaa” dentro de dicho String.

cadena = input (f"Cuántos veces aparece aaa en la cadena : ")
repeticiones = cadena.count("aaa")
print(f"Tiene {repeticiones}")