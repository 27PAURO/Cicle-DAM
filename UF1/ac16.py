
duracion_llamada = int(input("Duración de la llamada en minutos: "))
dia_semana = input("Día de la semana (L, M, X, J, V, S o D): ")
turno = input("Introduce el turno, Mañana o Tarde): ")

#
if duracion_llamada <= 5:
    costo_llamada = 1.00
elif duracion_llamada <= 8:
    costo_llamada = 1.00 + (duracion_llamada - 5) * 0.80 #suma el precio base de la llamada (duracion de la llamada -5 segundos) y los segundos que resten se multiplica por el coste del minuto
elif duracion_llamada <= 10:
    costo_llamada = 1.00 + 3 * 0.80 + (duracion_llamada - 8) * 0.70
else:
    costo_llamada = 1.00 + 3 * 0.80 + 2 * 0.70 + (duracion_llamada - 10) * 0.50


impuesto = 0
if dia_semana == "D":
    impuesto = costo_llamada * 0.03
elif turno == "Mañana":
    impuesto = costo_llamada * 0.15
elif turno == "Tarde":
    impuesto = costo_llamada * 0.10

costo_total = costo_llamada + impuesto


print(f"El costo de la llamada es de {costo_llamada} euros.")
print(f"El impuesto es de {impuesto} euros.")
print(f"El costo total de la llamada es de {costo_total} euros.")
