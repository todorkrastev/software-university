name = input()
day = input()
qty = float(input())

price = 0

if day == 'Monday' \
        or day == 'Tuesday' \
        or day == 'Wednesday' \
        or day == 'Thursday' \
        or day == 'Friday':
    if name == 'banana':
        price = 2.50
    elif name == 'apple':
        price = 1.20
    elif name == 'orange':
        price = 0.85
    elif name == 'grapefruit':
        price = 1.45
    elif name == 'kiwi':
        price = 2.70
    elif name == 'pineapple':
        price = 5.50
    elif name == 'grapes':
        price = 3.85
    else:
        print('error')
elif day == 'Saturday' or day == 'Sunday':
    if name == 'banana':
        price = 2.70
    elif name == 'apple':
        price = 1.25
    elif name == 'orange':
        price = 0.90
    elif name == 'grapefruit':
        price = 1.60
    elif name == 'kiwi':
        price = 3.00
    elif name == 'pineapple':
        price = 5.60
    elif name == 'grapes':
        price = 4.20
    else:
        print('error')
else:
    print('error')

if name == 'banana' or name == 'apple' or name == 'orange' or name == 'grapefruit' \
        or name == 'kiwi' or name == 'pineapple' or name == 'grapes':
    if day == 'Monday' or day == 'Tuesday' or day == 'Wednesday' or day == 'Thursday' \
            or day == 'Friday' or day == 'Saturday' or day == 'Sunday':
        total_price = qty * price
        print(f'{total_price:.2f}')
else:
    print('')

