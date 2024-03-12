""" Localitza l'error al següent bloc de codi. Crea una excepció per evitar que el programa es bloquegi i a més explica 
en un missatge a l'usuari la causa i/o solució:
resultat= 10/0 """
try:
    num1 = int(input("Numero 1: "))
    num2 = int(input("Numero 2 (divisor): "))
    resultat = num1 / num2
except ZeroDivisionError:
    print("no se puede dividir entre cero")
else:
    print(f"resultat: {resultat}")
finally:
    print("Programa finalitzat")