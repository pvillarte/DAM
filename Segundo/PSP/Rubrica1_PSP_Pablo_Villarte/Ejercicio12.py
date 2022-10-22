#Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener
#  decimales). El titular será obligatorio y la cantidad es opcional. Crea sus métodos get, set y
#  toString. Tendrá dos métodos especiales:
#   - ingresar(double cantidad): se ingresa una cantidad a la cuenta si la cantidad introducida es negativa,
#   no se hará nada.
#   - retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a 
#   la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.

class Cuenta:
    def __init__(self,cant,tit):
        self.titular = tit
        self.cantidad = cant

    def ingresar(self, dinero):
        if (dinero>0):
            self.cantidad += dinero
    
    def retirar(self, dinero):
        if (dinero>0):
            self.cantidad-=dinero
        if (self.cantidad<0):
            self.cantidad=0

miCuenta = Cuenta(12, "Pablo")

print(f"La cuenta de {miCuenta.titular} tiene {miCuenta.cantidad} leuros")
miCuenta.ingresar(10)
print(f"La cuenta de {miCuenta.titular} tiene {miCuenta.cantidad} leuros")
miCuenta.retirar(5)
print(f"La cuenta de {miCuenta.titular} tiene {miCuenta.cantidad} leuros")
miCuenta.retirar(50)
print(f"La cuenta de {miCuenta.titular} tiene {miCuenta.cantidad} leuros")