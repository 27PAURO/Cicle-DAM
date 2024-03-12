""" Localitza l'error al següent bloc de codi. Crea una excepció per evitar que el programa es bloquegi i a més explica 
en un missatge a l'usuari la causa i/o solució:
resultat = 15 + "20" """
try:
    numero = input("Introduce el numero de la cadena")
    resultat = 15 + numero
except TypeError:
    print(f"la cadena no es un numero, la cadena es un tipus string i no un un tipus numeric")
else:
    print("la cadena es un numero")
finally:
    print("Programa finalitzat")