city = input()
sales = float(input())

commissions = 0

if city == 'Sofia':
    if 0 <= sales <= 500:
        commissions = 0.05
    elif 500 < sales <= 1000:
        commissions = 0.07
    elif 1000 < sales <= 10000:
        commissions = 0.08
    elif sales > 10000:
        commissions = 0.12
    else:
        print('error')
elif city == 'Varna':
    if 0 <= sales <= 500:
        commissions = 0.045
    elif 500 < sales <= 1000:
        commissions = 0.075
    elif 1000 < sales <= 10000:
        commissions = 0.10
    elif sales > 10000:
        commissions = 0.13
    else:
        print('error')
elif city == 'Plovdiv':
    if 0 <= sales <= 500:
        commissions = 0.055
    elif 500 < sales <= 1000:
        commissions = 0.08
    elif 1000 < sales <= 10000:
        commissions = 0.12
    elif sales > 10000:
        commissions = 0.145
    else:
        print('error')
else:
    print('error')

if city == 'Sofia' or city == 'Varna' or city == 'Plovdiv':
    if sales > 0:
        money = commissions * sales
        print(f'{money:.2f}')
