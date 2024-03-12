tirada_dado = int(input("numero del dado (1-6): "))

if tirada_dado < 1 or tirada_dado > 6:
    print("ERROR: número incorrecto.")
else:   
    caras_opuestas = {1: "seis", 2: "cinco", 3: "cuatro", 4: "tres", 5: "dos", 6: "uno"}

    cara_opuesta = caras_opuestas[tirada_dado]
    print(f"La cara opuesta del dado es {cara_opuesta}.")
