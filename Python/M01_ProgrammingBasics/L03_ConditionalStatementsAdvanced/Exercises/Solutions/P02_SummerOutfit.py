weather = int(input())
time = input()

Outfit = 0
Shoes = 0

if time == "Morning":
    if 10 <= weather <= 18:
        Outfit = "Sweatshirt"
        Shoes = "Sneakers"
    elif 18 < weather <= 24:
        Outfit = "Shirt"
        Shoes = "Moccasins"
    else:
        Outfit = "T-Shirt"
        Shoes = "Sandals"

if time == "Afternoon":
    if 10 <= weather <= 18:
        Outfit = "Shirt"
        Shoes = "Moccasins"
    elif 18 < weather <= 24:
        Outfit = "T-Shirt"
        Shoes = "Sandals"
    else:
        Outfit = "Swim Suit"
        Shoes = "Barefoot"

if time == "Evening":
    Outfit = "Shirt"
    Shoes = "Moccasins"

print(f'It\'s {weather} degrees, get your {Outfit} and {Shoes}.')
