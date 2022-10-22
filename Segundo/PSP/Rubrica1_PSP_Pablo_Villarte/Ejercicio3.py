# Ejercicio 3:  ¡IMPLEMENTA TU PRIMER JUEGO! Realiza un programa Python que adivine el número. El programa
#  generará un número aleatorio entre 0 y 20 y luego irá pidiendo números al usuario indicando “mayor” o 
# “menor” según sea mayor o menor con respecto al número generado aleatoriamente. El proceso termina cuando
#  el usuario acierta, y deberá mostrar un mensaje de felicitaciones junto al número de intentos que ha 
# necesitado el usuario.

import random
print("Adivina el numero entre 1 y 20")

numero_adivinar = random.randint(0,20)

intento = int(input("Creo que es el número: "))
numero_intentos = 1

while (numero_adivinar!=intento):
    if (numero_adivinar>intento):
        print(f"Te equivocaste, vuelve a intentarlo con un numero mayor que {intento}: ")
    else:    
        print(f"Te equivocaste, vuelve a intentarlo con un numero menor que {intento}: ")
    intento = int(input("Probare de nuevo, pero con el numero: "))
    numero_intentos+=1

print(f"Felicidades, el número {intento} es correcto. Has necesitado {numero_intentos} intentos")

