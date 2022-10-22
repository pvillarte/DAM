# Ejercicio 2:  Escribe un programa Python que pregunte al usuario por 10 números enteros 
# y muestre por pantalla el número total de veces que el usuario ha introducido el 0, el 
# número total de enteros mayores que 0 introducidos y el número total de enteros menores 
# que 0 introducidos.

lista_numeros = []
numero_ceros = 0
numero_positivos = 0
numero_negativos = 0
print("Introduce 10 numeros enteros:")
for i in range(10):
    entrada = int(input("Numero: "))
    lista_numeros.append(entrada)

for num in lista_numeros:
    if (num>0):
        numero_positivos+=1
    elif(num<0):
        numero_negativos+=1
    else:
        numero_ceros+=1

print (f"Número de ceros: {numero_ceros}")
print (f"Número de negativos: {numero_negativos}")
print (f"Número de positivos: {numero_positivos}")



