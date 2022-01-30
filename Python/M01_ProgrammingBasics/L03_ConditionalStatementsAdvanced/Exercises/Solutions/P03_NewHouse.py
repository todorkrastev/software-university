flowers = input()
qty = int(input())
budget = int(input())

price = 0

Roses = 5
Dahlias = 3.8
Tulips = 2.8
Narcissus = 3
Gladiolus = 2.5

if flowers == "Roses":
    if qty > 80:
        price = Roses * qty * 0.9
    else:
        price = Roses * qty
elif flowers == "Dahlias":
    if qty > 90:
        price = Dahlias * qty * 0.85
    else:
        price = Dahlias * qty
elif flowers == "Tulips":
    if qty > 80:
        price = Tulips * qty * 0.85
    else:
        price = Tulips * qty
elif flowers == "Narcissus":
    if qty < 120:
        price = Narcissus * qty * 1.15
    else:
        price = Narcissus * qty
elif flowers == "Gladiolus":
    if qty < 80:
        price = Gladiolus * qty * 1.2
    else:
        price = Gladiolus * qty

if price > budget:
    print(f'Not enough money, you need {price - budget:.2f} leva more.')
else:
    print(f'Hey, you have a great garden with {qty} {flowers} and {budget - price:.2f} leva left.')