""" Localitza l'error al següent bloc de codi. Crea una excepció per evitar que el programa es bloquegi i a més explica 
en un missatge a l'usuari la causa i/o solució:
llista = [1, 2, 3, 4, 5]
llista[10] """


try:
    numero = int(input("Introduce el numero de la cadena"))
    llista = [1, 2, 3, 4, 5]
    llista[numero]
except IndexError:
    print(f"la posicio no existeix")
else:
    print("la posicio existeix")
finally:
    print("Programa finalitzat")