# Haz un programa que, dadas la ruta de un fichero y una palabra, devuelva una lista con las lineas que contienen a
#  dicha palabra. El programa debe leer el nombre de un fichero y tantas palabras como el usuario desee (utiliza un 
# bucle que pregunte al usuario si desea seguir introduciendo palabras). Para cada palabra, el programa mostrara las 
# lıneas que contienen dicha palabra en el fichero).
import pathlib

filename = input("Ingresa el nombre del archivo que desea abrir: ")
direction = pathlib.Path(str(pathlib.Path().absolute())+"/Rubrica2_PSP_Pablo_Villarte/Directorio/"+filename)

nextWord = True
seeked = ""

while nextWord:
    if (seeked == ""):
        seeked = input("Ingresa busqueda: ")
    output = []
    with open(direction, "r") as file:
        line_index = 0
        for line in file:
            line_index += 1
            line = line.rstrip()
            splited = line.split(" ")
            if seeked in splited:
                output.append("Línea " + str(line_index) + ": " + line)
    print("La palabra " + seeked + " se encuentra en las siguientes lineas: ")            
    for line in output:
        print(line)
    seeked = input("¿Desea seguir buscando palabras?, de ser asi introduzcala, sino, pulse enter sin nada: ")
    if (seeked == ""):
        nextWord=False

