def quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        # S'escull el primer element com a pivot
        pivot = arr[0]

        # Es creen dues llistes, una pels elements menors o iguals al pivot i una altra pels majors
        lesser = []
        greater = []

        for i in range(1, len(arr)):
            if arr[i]["horas"] <= pivot["horas"]:
                lesser.append(arr[i])
            else:
                greater.append(arr[i])

        # S'aplica recursivament Quicksort a les subllistes menor i major
        return quicksort(lesser) + [pivot] + quicksort(greater)
    
bombers = [
    {
        "id": 1,
        "nombre": "Paco Mangueras",
        "horas": 6,
    },
    {
        "id": 2,
        "nombre": "Alex Tintor",
        "horas": 3,
    },
    {
        "id": 3,
        "nombre": "Elsa Patilla",
        "horas": 15,
    },
    {
        "id": 4,
        "nombre": "Jordi Bord",
        "horas": 2
    }
]

contador = 4
def crearBomber():
    global contador
    nom = input("\nNou bomber (no s'accepta noms sosos): ")
    hores = int(input("Noves hores del bomber: "))
    id_nuevo = contador + 1
    bombers.append({"id": id_nuevo, "nombre": nom, "horas": hores})
    print(f"{nom} afegit a la llista amb {hores} hores.")
    contador += 1 #si no hiciera eso, el contador no incrementaria cada vez que se crea un bombero

def modificar_hores():
    id_bomber = int(input("\nIntrodueix la id del bomber a modificar: "))
    for bomber in bombers:
        if bomber["id"] == id_bomber:
            noves_hores = int(input("Introdueix les noves hores: "))
            bomber["horas"] = noves_hores
            print(f"Hores de {bomber['nombre']} modificades a {noves_hores}.")
            return
    print("Error. ID no encontrada.")

def llistarBombers():
    bombers_ordenats = quicksort(bombers)
    print("\nLlista de Bombers (ordenats per hores):")
    for bomber in bombers_ordenats:
        print(f"Nom: {bomber['nombre']}, Hores: {bomber['horas']}")

while True:
    print("\nMenú:")
    print("1. Introduir nou bomber amb hores")
    print("2. Modificar hores del bomber donada la id")
    print("3. Llistar bombers (ordenats)")
    print("4. Sortir\n")

    opcio = input("Selecciona una opcion (1-4):")
    if opcio == "1":
        crearBomber()
    elif opcio == "2":
        modificar_hores()
    elif opcio == "3":
        llistarBombers()
    elif opcio == "4":
        print("fin del programa.")
        break
    else:
        print("Error")