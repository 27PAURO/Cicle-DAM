numero = int(input("número del 1 al 7: "))

if numero == 1:
    dia = "Lunes"
elif numero == 2:
    dia = "Martes"
elif numero == 3:
    dia = "Miércoles"
elif numero == 4:
    dia = "Jueves"
elif numero == 5:
    dia = "Viernes"
elif numero == 6:
    dia = "Sábado"
elif numero == 7:
    dia = "Domingo"
else:
    dia = "Error: El número debe estar en el rango del 1 al 7"

print(f"El numeroo {numero} es el dia {dia}.")
