budget = int(input())
season = input()
people = int(input())

rent = 0

if season == "Spring":
    if people <= 6:
        rent = 3000 * 0.9
    elif 7 <= people <= 11:
        rent = 3000 * 0.85
    elif people >= 12:
        rent = 3000 * 0.75
elif season == "Summer" or season == "Autumn":
    if people <= 6:
        rent = 4200 * 0.9
    elif 7 <= people <= 11:
        rent = 4200 * 0.85
    elif people >= 12:
        rent = 4200 * 0.75
elif season == "Winter":
    if people <= 6:
        rent = 2600 * 0.9
    elif 7 <= people <= 11:
        rent = 2600 * 0.85
    elif people >= 12:
        rent = 2600 * 0.75

if season == "Spring" or season == "Summer" or season == "Winter":
    if people % 2 == 0:
        rent = rent * 0.95

if budget >= rent:
    print(f'Yes! You have {budget - rent:.2f} leva left.')
else:
    print(f'Not enough money! You need {rent - budget:.2f} leva.')

