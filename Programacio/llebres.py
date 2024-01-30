def Fibonacci(num):
    if num == 0:
        return 2
    elif num == 1:
        return 4
    else:
        return Fibonacci(num - 2) + Fibonacci(num - 1)


mes2=int(input("Entra el valor del mes: "))
for i in range(0, mes2):
  print(f"Mes {i+1}: {Fibonacci(i)}")


