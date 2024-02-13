""" Realitza una funció anomenada afegirUnic(llista, elem) que rebi per paràmetres una llista i un element. 
La funció ha d'afegir l'ítem al final de la llista amb la condició de no repetir cap element.
A més, si aquest element ja es troba a la llista s'ha d'invocar un error de tipus ValueError que has de capturar i 
mostrar aquest missatge al seu lloc:
Error: Impossible afegir elements duplicats => [element].
Quan tinguis la funció intenta afegir els següents valors a la llista 10, -2, "Hola" i després mostra'n el contingut 
tenint en compte que inicialment el vector val [1, 5, -2] """

def afegirUnic(llista, element):
    if element in llista:
        raise ValueError("Impossible afegir elements duplicats => " + str(element))
    else:
        llista.append(element)
    return llista

try:
    llista = [1, 5, -2]
    afegirUnic(llista, 10)
    afegirUnic(llista, -2)
    afegirUnic(llista, "Hola")
    print(llista)
except ValueError as err:
    print(err)
finally:
    print("Programa finalitzat")


