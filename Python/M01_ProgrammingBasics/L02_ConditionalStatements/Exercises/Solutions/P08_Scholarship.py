import math
income = float(input())
average_rates = float(input())
minimum_wage = float(input())

social_money = minimum_wage * 0.35
success_money = average_rates * 25

if success_money >= social_money:
    bigger = success_money
    text = "a scholarship for excellent results"
else:
    bigger = social_money
    text = "a Social scholarship"

if income < minimum_wage and average_rates > 4.5:
    if average_rates < 5.50:   # Само социална стипендия
        print(f'You get a Social scholarship {math.floor(social_money)} BGN')
    else:                      # Социална или за успех
        print(f'You get {text} {math.floor(bigger)} BGN')
elif average_rates >= 5.5:     # Само за успех
    print(f'You get a scholarship for excellent results {math.floor(success_money)} BGN')
else:
    print('You cannot get a scholarship!')
