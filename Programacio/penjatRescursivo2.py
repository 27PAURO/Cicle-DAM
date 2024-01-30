def jugar(vidas, palabra_secreta, letras_acertadas):
    if vidas == 0:
        return "Has perdido"
    elif len(letras_acertadas) == len(palabra_secreta):
        return "Has ganado"
    else:
        letra = input("Introduce la letra: ")
        print("Palabra: ")
        if letra in palabra_secreta:
            letras_acertadas.append(letra)
            palabra_oculta = " ".join([letra_secreta if letra_secreta in letras_acertadas else "_" for letra_secreta in palabra_secreta])
            print(palabra_oculta)
        else:
            vidas -= 1
        return jugar(vidas, palabra_secreta, letras_acertadas)

vidas = 6
palabra_secreta = "python"
letras_acertadas = []

resultado = jugar(vidas, palabra_secreta, letras_acertadas)
print(resultado)
