type = input()
rows = int(input())
columns = int(input())

price = 0

Premiere = 12
Normal = 7.50
Discount = 5

if type == "Premiere":
    price = rows * columns * Premiere
elif type == 'Normal':
    price = rows * columns * Normal
elif type == 'Discount':
    price = rows * columns * Discount


print(f'{price:.2f}' ' leva')