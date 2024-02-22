import json
import re
import os
cWD = os.getcwd()
filename = cWD + '\\M3 Programació\\UF3\gestio_fitxers\\agenda.json'
agenda = []
regex = '^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$'

#Es como si fuera una plantilla y luego en añadirContacte hago una copia de ella y se va rellenando con los inputs
contacte = {
    "index": 1,
    "nom": "",
    "mail": "",
    "telefon": "",
    "newsletter": False
}

def checkmail(email):
    regex = '^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$'
    return bool(re.search(regex, email))

def checktel(telefon):
    return len(telefon) == 9

def afegirContacte():
    nou_contacte = contacte.copy()
    nou_contacte["nom"] = input("Nom: ")
    while True:
        nou_contacte["telefon"] = input("Telefon: ")
        if checktel(nou_contacte["telefon"]):
            print("telefon vàlid")
            break
        else:
            print("Telefon invalid")
    while True:
        nou_contacte["mail"] = input("Mail: ")
        if checkmail(nou_contacte["mail"]):
            print("Mail valid")
            break
        else:
            print("Mail invalid")
            
    nou_contacte["newsletter"] = input("Vols rebre notificacions? (Si/No): ").lower()
    nou_contacte["index"] = len(agenda) + 1
    agenda.append(nou_contacte)
    print(f"Contacte afegit amb ID {nou_contacte['index']}")

def mostrarContacte(contacte):
    contactes=[["ID", "NOM", "MAIL", "TELEFON", "NEWSLETTER"]]
    if contacte["newsletter"] == True:
        newsletter = "Si"
    else:
        newsletter = "No"

    contactes.append([contacte["index"], contacte["nom"], contacte["mail"], contacte["telefon"], newsletter])

    anchuras = [max(len(str(fila[i])) for fila in contactes) for i in range(len(contactes[0]))]

    for fila in contactes:
        for i in range(len(fila)):
            elemento = str(fila[i]).ljust(anchuras[i])
            print(elemento, end=" ")
        print()

def mostrarAgenda():
    print("-" * 90)
    for contacte in agenda:
        mostrarContacte(contacte)
    print("-" * 90)

def cercarContacte():
    buscar= input("Introduce el nom para a buscar:  ")
    encontrado = False
    for contacte in agenda:
        if contacte["nom"].lower() == buscar.lower():
            mostrarContacte(contacte)
            encontrado = True
    if not encontrado:
        print("Contacte no trobat.")

def modificarContacte():
    mostrarAgenda()
    modificar = int(input("Introduce ID para modificar: "))
    for contacte in agenda:
        if contacte["index"] == modificar:
            contacte["nom"] = input(f"Nom ({contacte['nom']}): ") or contacte["nom"]
            contacte["telefon"] = input(f"Telèfon ({contacte['telefon']}): ") or contacte["telefon"]
            contacte["mail"] = input(f"Mail ({contacte['mail']}): ") or contacte["mail"]
            newsletter = input(f"Vols rebre notificacions? ({'Si' if contacte['newsletter'] else 'No'}): ").lower()
            contacte["newsletter"] = newsletter == "si"
            print("Contacto actualizado")
            return
    print("El ID de contacte no existe")

def borrarContacte():
    mostrarAgenda()
    borrar = int(input("Introduce ID para eliminar: "))
    for contacte in agenda:
        if contacte["index"] == borrar:
            agenda.remove(contacte)
            print("Contacte eliminado.")
            return
    print("EL Id de contacte no existe")

def importar():
    global agenda
    try:
        with open(filename, "r") as f:
            agenda = json.load(f)
        print("Agenda importada de agenda.json.")
    except FileNotFoundError:
        print("El fichero agenda.json no se ha encontradono.")

def exportar():
    with open(filename, "w") as f:
        json.dump(agenda, f)
    print("Agenda exportada agenda.json.")


while True:
    print("\nMENU D'AGENDA TELEFONICA:")
    print("1. Afegir contacte")
    print("2. Mostrar contactes")
    print("3. Cercar contacte")
    print("4. Modificar contacte")
    print("5. Esborrar contacte")
    print("6. Importa desde fitxer")
    print("7. Exporta a fitxer")
    print("8. Sortir")

    opcion = input("\nSelecciona una n (1-8): ")

    if opcion == "1":
        afegirContacte()
    elif opcion == "2":
        mostrarAgenda()
    elif opcion == "3":
        cercarContacte()
    elif opcion == "4":
        modificarContacte()
    elif opcion == "5":
        borrarContacte()
    elif opcion == "6":
        importar()
    elif opcion == "7":
        exportar()
    elif opcion == "8":
        print("Adéu!")
        break
    else:
        print("Error. Escriu del 1 al 8.")
