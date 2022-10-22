# Ejercicio 1: Implementa un programa Python que PREGUNTE al usuario por dos números enteros (x, y) 
# y muestre por pantalla la suma, resta, multiplicación, división y resto de ambos, con el siguiente 
# formato:
#                      x + y = …
#                      x – y = …
#                      x * y = …
#                      x / y = …
#                      x % y = …

a =int(input("Introduce el primer número entero: "))
b =int(input("Introduce el segundo número entero: "))

print(f" {a} + {b} = {a+b}" )
print(f" {a} - {b} = {a-b}" )
print(f" {a} * {b} = {a*b}" )
print(f" {a} / {b} = {a/b}" )
print(f" {a} % {b} = {a%b}" )