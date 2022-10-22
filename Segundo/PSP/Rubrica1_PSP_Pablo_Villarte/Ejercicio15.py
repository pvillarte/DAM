#Ejercicio 15: Crea un fichero de texto con el nombre y contenido que tú desees. Por ejemplo, Ejercicio15.txt.
#  Realiza un programa en Python que lea el fichero <<Ejercicio15.txt>> y muestre su contenido por pantalla 
# sin espacios. Por ejemplo, si el fichero contiene el siguiente texto “Hola que haces”, deberá mostrar 
# “Holaquehaces”.
def escribir():
    with open("Ejercicio15.txt","w") as file:
        file.write("Lista: ")
        for i in range(0, 100, 2):
            file.write(f"{i} ")
def leer():
    f = open("Ejercicio15.txt","r")
    lines = f.read()
    lines = lines.replace(" ", "")
    print(lines)
    
def mostrar_menu(opciones):
    print('Seleccione una opción:')
    for clave in sorted(opciones):
        print(f' {clave}) {opciones[clave][0]}')

def leer_opcion(opciones):
    while (a := input('Opción: ')) not in opciones:
        print('Opción incorrecta, vuelva a intentarlo.')
    return a

def ejecutar_opcion(opcion, opciones):
    opciones[opcion][1]()

def generar_menu(opciones, opcion_salida):
    opcion = None
    while opcion != opcion_salida:
        mostrar_menu(opciones)
        opcion = leer_opcion(opciones)
        ejecutar_opcion(opcion, opciones)
        print()

def menu_principal():
    opciones = {
        '1': ('Escribir', accion1),
        '2': ('Leer', accion2),
        '3': ('Salir', salir)
    }
    generar_menu(opciones, '3')


def accion1():
    escribir()


def accion2():
    leer()

def salir():
    print('Saliendo')

if __name__ == '__main__':
    menu_principal()
