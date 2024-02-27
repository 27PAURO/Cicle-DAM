import json
import re
import os

cWD = os.getcwd()
filename = cWD + '\\M3 Programació\\UF3\gestio_fitxers\\agenda.json'
agenda = []
regex = '^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$'

# Es como si fuera una plantilla y luego en añadirContacte hago una copia de ella y se va rellenando con los inputs
contacte = {
    "index": 1,
    "nom": "",
    "mail": "",
    "telefon": "",
    "newsletter": False,
    "poblacio": ""
}

regex = '^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$'

def checkmail(mail):
    if re.search(regex, mail):
        return mail
    else:
        raise ValueError("El mail no es valido")

def checktel(telefon):
    if len(telefon) == 9:
        return telefon
    else:
        raise ValueError("El telefon no es valido")

def checkname(nom):
    if nom.isalpha():
        return nom
    else:
        raise ValueError("El nom no es valido")

def afegirContacte():
    nou_contacte = contacte.copy()
    while True:
        try:
            nou_contacte["nom"] = checkname(input("Nom: "))
            break
        except ValueError as err:
            print(err)
    while True:
        try:
            nou_contacte["telefon"] = checktel(input("Telefon: "))
            break
        except ValueError as err:
            print(err)
    while True:
        try:
            nou_contacte["mail"] = checkmail(input("Mail: "))
            break
        except ValueError as err:
            print(err)
    while True:
        try:
            nou_contacte["poblacio"] = input("Poblacio: ")
            break
        except ValueError as err:
            print(err)
    while True:
        try:
            nou_contacte["newsletter"] = input("Vols rebre notificacions? (Si/No): ").lower()
            if nou_contacte["newsletter"] == "si":
                break
            elif nou_contacte["newsletter"] == "no":
                break
            else:
                raise ValueError('Tienes que escribir si o no')
        except ValueError as err:
            print(err)

    nou_contacte["index"] = len(agenda) + 1
    agenda.append(nou_contacte)
    print(f"Contacte afegit amb ID {nou_contacte['index']}")


def mostrarContactes():
    print("-" * 90)
    try:
        contactes=[["ID", "NOM", "MAIL", "TELEFON", "POBLACIO", "NEWSLETTER"]]
        for contacte in agenda:
            contactes.append([contacte["index"], contacte["nom"], contacte["mail"], contacte["telefon"], contacte["poblacio"], contacte["newsletter"]])  
    except KeyError:
        print("Contacte no trobat")

    if len(agenda) == 0:
        raise FileNotFoundError
    else:
        mostrarColocats(contactes)

def mostrarColocats(contactes): #esta funcion calcula la anchura de cada columna con el len() de cada elemento y te imprime los elementos con sus espacios por columna
    anchuras = [max(len(str(fila[i])) for fila in contactes) for i in range(len(contactes[0]))]

    for fila in contactes:
        for i in range(len(fila)):
            elemento = str(fila[i]).ljust(anchuras[i])
            print(elemento, end=" ")
        print()

def get_name(contacte):
    return contacte.get('nom')

def get_poblacio(contacte):
    return contacte.get('poblacio')

def mostrarAgendaPerNom():
    # sort by name (Ascending order)
    agenda.sort(key=get_name)
    mostrarContactes()

def mostrarOrdenatPerPoblacio():
    agenda.sort(key=get_poblacio)
    mostrarContactes()

def mostrarAgendaFiltrarPoblacio():
    buscarPoblacio = input("Introduce la poblacin a buscar: ").lower()
    contactos_poblacion = [contacte for contacte in agenda if contacte["poblacio"].lower() == buscarPoblacio] #busca si coincide el input con contacte["poblacio"]

    cabecera = ["ID", "NOM", "MAIL", "TELEFON", "POBLACIO", "NEWSLETTER"] 
    contactos_coincididos = [[contacte["index"], contacte["nom"], contacte["mail"], contacte["telefon"], contacte["poblacio"], contacte["newsletter"]] for contacte in contactos_poblacion] #hago un array con los contactos que coinciden
    
    if contactos_coincididos: 
        mostrarColocats([cabecera] + contactos_coincididos) #hago un array con cabecera y filas con la funcion
    else:
        print("No hay contactos en esa poblacion.")



def cercarContacte():
    buscar = input("Introduce el nom para buscar:  ")
    encontrado = False
    for contacte in agenda:
        if contacte["nom"].lower() == buscar.lower():
            mostrarContactes()
            encontrado = True
            break
    if not encontrado:
        print("Contacte no ecnontrado")

def modificarContacte():
    mostrarContactes()
    modificar = int(input("Introduce ID para modificar: "))
    for contacte in agenda:
        if contacte["index"] == modificar:
            contacte["nom"] = input(f"Nom ({contacte['nom']}): ") or contacte["nom"]
            contacte["telefon"] = input(f"Telefon ({contacte['telefon']}): ") or contacte["telefon"]
            contacte["mail"] = input(f"Mail ({contacte['mail']}): ") or contacte["mail"]
            contacte["poblacio"] = input(f"Poblaci ({contacte['poblacio']}): ") or contacte["poblacio"]
            newsletter = input(f"Quieres recibir notifiacions ({'Si' if contacte['newsletter'] else 'No'}): ").lower()
            contacte["newsletter"] = newsletter == "si"
            print("Contacto actualizado")
            return
    print("El ID de contacte no existe")


def borrarContacte():
    mostrarContactes()
    borrar = int(input("Introduce ID para eliminar: "))
    for contacte in agenda:
        if contacte["index"] == borrar:
            agenda.remove(contacte)
            print("Contacte eliminado.")
            return
    print("El ID de contacte no existe")


def importar():
    global agenda
    try:
        with open(filename, "r") as f:
            agenda = json.load(f)
        print("Agenda importada de agenda.json.")
    except FileNotFoundError:
        print("El fichero agenda.json no se ha encontrado.")


def exportar():
    with open(filename, "w") as f:
        json.dump(agenda, f)
    print("Agenda exportada a agenda.json.")


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

    opcion = input("\nSelecciona una opcion (1-8): ")

    if opcion == "1":
        afegirContacte()
    elif opcion == "2":
        print("\nSUBMENU DE MOSTRAR L'AGENDA TELEFONICA:")
        print("a. Mostrar agenda")
        print("b. Mostrar contactes ordenats per nom")
        print("c. Mostrar contactes ordenats per població")
        print("d. Mostrar contactes filtrats per població")
        opcion2 = input("Selecciona una opcion (a-d): ")
        if opcion2 == "a":
            try :
                mostrarContactes()
            except FileNotFoundError:
                print("Agenda sin contactos, porfavor añada o importa contactos")
        elif opcion2 == "b":
            try :
                mostrarAgendaPerNom()
            except FileNotFoundError:
                print("Agenda sin contactos, porfavor añada o importa contactos")
        elif opcion2 == "c":
            try :
                mostrarOrdenatPerPoblacio()
            except FileNotFoundError:
                print("Agenda sin contactos, porfavor añada o importa contactos") 
        elif opcion2 == "d":
            mostrarAgendaFiltrarPoblacio()
        else:
            print("Error. Escribe de a-d")
            
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
        print("Error. Escribe del 1-8")