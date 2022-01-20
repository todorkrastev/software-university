budget = float(input())
staff_number = int(input())
price_per_staff = float(input())

decor = budget * 0.1
price_all_staff = staff_number * price_per_staff

if staff_number > 150:
    price_all_staff = price_all_staff * 0.9

cost = price_all_staff + decor

if budget >= cost:
    remaining = budget - cost
    print('Action!')
    print(f'Wingard starts filming with {remaining:.2f} leva left.')
else:
    remaining = cost - budget
    print('Not enough money!')
    print(f'Wingard needs {remaining:.2f} leva more.')