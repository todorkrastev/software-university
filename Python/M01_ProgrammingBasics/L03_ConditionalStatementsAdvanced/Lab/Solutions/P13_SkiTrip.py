days = int(input())
room = input()
grade = input()

nights = days - 1
price = 0

if room == 'room for one person':
    price = nights * 18
elif room == 'apartment':
    if nights < 10:
        price = (nights * 25) * 0.7
    elif 10 <= nights < 15:
        price = (nights * 25) * 0.65
    else:
        price = (nights * 25) * 0.5

elif room == "president apartment":
    if nights < 10:
        price = (nights * 35) * 0.9
    elif 10 <= nights < 15:
        price = (nights * 35) * 0.85
    else:
        price = (nights * 35) * 0.8

if grade == 'positive':
    price = price * 1.25
elif grade == "negative":
    price = price * 0.9

print(f'{price:.2f}')

