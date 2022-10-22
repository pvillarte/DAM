#Ejercicio 13: Implementa la clase “Matriz” con los atributos int rows, int columns e int[rows][columns] 
# matrix, que contenga los siguientes métodos: 
#                - getNumberRows(): devuelve el número de filas de la matriz.
#                - getNumberColumns(): devuelve el número de columnas de la matriz.
#                - setElement(int x, int j, int element): cambia el valor de la matriz en [x][j] 
# por el valor de [element].
#                - addMatrix(int[][] matrix): suma todos los elementos de la matriz actual a 
# los elementos de [matrix], y el resultado se almacena en la matriz inicial. Si [matrix] no 
# tiene el mismo número de filas y columnas que la matriz inicial, la operación no se puede 
# realizar (notificalo).
#                - multMatrix(int[][] matrix]: multiplica todos los elementos de la matriz 
# actual a los elementos de [matrix], y el resultado se almacena en la matriz inicial. Si 
# [matrix] no tiene el mismo número de filas y columnas que la matriz inicial, la operación
#  no se puede realizar (notificalo).

class Matriz:
    def __init__(self, num_rows, num_cols):
        self.rows = num_rows
        self.cols = num_cols
        self.matrix = []
        for i in range(num_rows):
            self.matrix.append([])
        for m in self.matrix:
            for j in range(num_cols):
                m.append(0)
    def getNumberRows(self):
        return self.rows
    def getNumberCols(self):
        return self.cols
    def setElement(self, x, j, valor):
        self.matrix[x][j]=valor
    def addMatrix(self, m2):
        iguales = True
        if(len(m2)==len(self.matrix)):
            for f in range(len(self.matrix)):
                if(len(self.matrix[f])!=len(m2[f])):
                    iguales = False
                    print("Las matrices no tienen el mismo tamaño")
        else:
            iguales = False
            print("Las matrices no tienen el mismo tamaño")
        if (iguales):
            for f in range(len(self.matrix)):
                for c in range(len(self.matrix[f])):
                    self.matrix[f][c] += m2[f][c]
    def multMatrix(self, m2):
        iguales = True
        if(len(m2)==len(self.matrix)):
            for f in range(len(self.matrix)):
                if(len(self.matrix[f])!=len(m2[f])):
                    iguales = False
                    print("Las matrices no tienen el mismo tamaño")
        else:
            iguales = False
            print("Las matrices no tienen el mismo tamaño")
        if (iguales):
            for f in range(len(self.matrix)):
                for c in range(len(self.matrix[f])):
                    self.matrix[f][c] *= m2[f][c]

        