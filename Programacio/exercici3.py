""" Localitza l'error al següent bloc de codi. Crea una excepció per evitar que el programa es bloquegi i a més explica 
en un missatge a l'usuari la causa i/o solució:
colors = { 'vermell':'red', 'verd':'green', 'negre':'black ' } 
colors['blanc'] """
try:
    color = str(input("Introduce un color:"))
    colors = { 'vermell':'red', 'verd':'green', 'negre':'black ' } 
    colors[color]
except KeyError:
    print(f"el color no existeix")
else:
    print(f"el color es {color} i {colors[color]} ")
finally:
    print("Programa finalitzat")

