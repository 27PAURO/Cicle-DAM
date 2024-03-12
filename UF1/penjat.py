import random

palabras = ["MESSI", "MARADONA", "PEDRI", "GAVI", "INIESTA", "XAVI", "PUYOL", "BUSQUETS", "PIQUE", "NEYMAR"]
rondas_max = 3
ronda_actual = 0
dificultad = int(input("Escribe una dificultad (1 (10 vidas), 2 (6 vidas) o 3(3 vidas)): "))
if dificultad == 1:
    vidas = 10
elif dificultad == 2:
    vidas = 6
elif dificultad == 3:
    vidas = 3
else:
    print("Error. Escribe una dificultad.")
    vidas = 10

#para que funcione las rondas, establezco el valor de las rondas_max i ronda_actual y despues con un while voy mirando si es menor o mayor la ronda actual con la ronda maxima, por cada while sumo una ronda
while ronda_actual < rondas_max:
    palabra_secreta = random.choice(palabras)
    ronda_actual += 1
    letras_incorrectas = []
    letras_correctas = []

    print("¡Bienvenido al penjat de nombres de jugadores del Barça!")
    
    while True:
        # convertir la palabra para adivinar en _
        palabra_oculta = ""
        for letra in palabra_secreta:
            if letra in letras_correctas:
                palabra_oculta += letra + " "
            else:
                palabra_oculta += "_ "

        print("\nPalabra: " + palabra_oculta)
        print("Letras incorrectas: " + ", ".join(letras_incorrectas))
        print("Vidas restantes: " + str(vidas))

        # mirar si se ha adivinado la palabra oculta
        if palabra_oculta.replace(" ", "") == palabra_secreta:
            print(f"Palabra correcta \nFin de la ronda {ronda_actual}")
            break

        letra = input("Introduce una letra: ").upper()

        # mirar si la letra escrita esta en la palabra secreta escogida de la lista 
        if letra in palabra_secreta:
            print("¡Letra correcta!")
            letras_correctas.append(letra)
        else:
            print("¡Letra incorrecta!")
            letras_incorrectas.append(letra)
            vidas -= 1

            if vidas == 9 or vidas == 10:
                print("|")
            if vidas == 8:
                print("|")
                print("|")
                print("|")
            if vidas == 7:
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 6:
                print("-----")
                print("|")
                print("|")
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 5:
                print("-----")
                print("|   o")
                print("|")
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 4:
                print("-----")
                print("|   o")
                print("|   |")
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 3:
                print("-----")
                print("|   o")
                print("|  /|")
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 2:
                print("-----")
                print("|   o")
                print("|  /|\\")
                print("|")
                print("|")
                print("|")
                print("|")
            if vidas == 1:
                print("-----")
                print("|   o")
                print("|  /|\\")
                print("|  /")
                print("|")
                print("|")
                print("|")
            if vidas == 0:
                print("-----")
                print("|   o")
                print("|  /|\\")
                print("|  / \\")
                print("|")
                print("|")
                print("|")
                print("Has perdido, la palabra para adivinar era:", palabra_secreta)
                
                break
    break

print("Fin del juego")