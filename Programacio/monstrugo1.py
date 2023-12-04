nombres_monstrugos = ["Pyrofire", "Flame", "Hydroia", "Swimmer", "Beast"]

tipos_monstrugos = {
    "Pyrofire": {
        "nombre": "fuego",
        "vitalidad": 10,
        "fuerza": 10,
        "resistencia": 6,
    },
    "Flame": {
        "nombre": "fuego",
        "vitalidad": 10,
        "fuerza": 10,
        "resistencia": 6,
    },
    "Hydroia": {
        "nombre": "agua",
        "vitalidad": 10,
        "fuerza": 6,
        "resistencia": 10,
    },
    "Swimmer": {
        "nombre": "agua",
        "vitalidad": 10,
        "fuerza": 6,
        "resistencia": 10,
    },
    "Beast": {
        "nombre": "tierra",
        "vitalidad": 10,
        "fuerza": 8,
        "resistencia": 8,
    }
}

monstrugos = {}
for nombre in nombres_monstrugos:
    tipo_monstrugo = tipos_monstrugos[nombre] 
    monstrugos[nombre] = {
        "nombre": nombre,
        "vitalidad": tipo_monstrugo["vitalidad"],
        "fuerza": tipo_monstrugo["fuerza"],
        "resistencia": tipo_monstrugo["resistencia"],
        "tipo": tipo_monstrugo["nombre"]
    }

while True:
    print("\nPOKEMON GO")
    print("***************************")
    print("1) Mostrar Pokemons")
    print("2) Fer combat")
    print("3) Reiniciar punts")
    print("4) Sortir")

    opcion = input("Quina opció vols realitzar? ")

    if opcion == "1":
        print("\nLista de Pokemons:")
        for i, monstrugo in enumerate(monstrugos.values(), 1):
            print(f"{i}) {monstrugo['nombre']} : {monstrugo['tipo']}")

    elif opcion == "2":
        opcion1 = int(input("Primer monstrugo (1-5): ")) - 1
        monstrugo1 = monstrugos[nombres_monstrugos[opcion1]]

        opcion1 = int(input("Segundo monstrugo (1-5): ")) - 1
        monstrugo2 = monstrugos[nombres_monstrugos[opcion1]]


        while monstrugo1['vitalidad'] > 0 and monstrugo2['vitalidad'] > 0 and \
            monstrugo1['fuerza'] > 0 and monstrugo2['fuerza'] > 0 and \
            monstrugo1['resistencia'] > 0 and monstrugo2['resistencia'] > 0:
            print("*")
            print(f"{monstrugo1['nombre']} ataca. {monstrugo2['nombre']} queda amb "
                f"{monstrugo2['vitalidad']} punts de vitalitat, {monstrugo2['fuerza']} punts de força, "
                f"{monstrugo2['resistencia']} punts de resistencia")

            if monstrugo1['tipo'] == "fuego":
                monstrugo2['vitalidad'] -= 3
                monstrugo2['resistencia'] -= 2
            elif monstrugo1['tipo'] == "agua":
                monstrugo2['vitalidad'] -= 2
                monstrugo2['fuerza'] -= 3
            elif monstrugo1['tipo'] == "tierra":
                monstrugo2['vitalidad'] -= 2
                monstrugo2['resistencia'] -= 2
                monstrugo2['fuerza'] -= 1

            if monstrugo2['vitalidad'] <= 0 or monstrugo2['fuerza'] <= 0 or monstrugo2['resistencia'] <= 0:
                break  

            print(f"{monstrugo2['nombre']} ataca. {monstrugo1['nombre']} queda amb "
                f"{monstrugo1['vitalidad']} punts de vitalitat, {monstrugo1['fuerza']} punts de força, "
                f"{monstrugo1['resistencia']} punts de resistencia")

            if monstrugo2['tipo'] == "fuego":
                monstrugo1['vitalidad'] -= 2
                monstrugo1['resistencia'] -= 3
            elif monstrugo2['tipo'] == "agua":
                monstrugo1['vitalidad'] -= 3
                monstrugo1['fuerza'] -= 2
            elif monstrugo2['tipo'] == "tierra":
                monstrugo1['vitalidad'] -= 1
                monstrugo1['resistencia'] -= 2
                monstrugo1['fuerza'] -= 2


        if monstrugo1['vitalidad'] <= 0 or monstrugo1['fuerza'] <= 0 or monstrugo1['resistencia'] <= 0:
            print(f"\nGana {monstrugo2['nombre']}")
        else:
            print(f"\nGana {monstrugo1['nombre']}")

    #preguntar que valores ponerles a los puntos
    elif opcion == "3":
        print("Puntos reiniciados")

    elif opcion == "4":
        print("Fin del juego!")
        break

    else:
        print("Error. Selecciona entre 1-4")