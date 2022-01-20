number = float(input())
number_type = input()
result_type = input()

if number_type == 'mm':
    good_number = number
    if result_type == 'mm':
        final_number = good_number
    elif result_type == "cm":
        final_number = good_number * 0.1
    else:
        final_number = good_number * 0.001
    print(f'{final_number:.3f}')

if number_type == 'cm':
    good_number = number
    if result_type == 'mm':
        final_number = good_number * 10
    elif result_type == "cm":
        final_number = good_number
    else:
        final_number = good_number * 0.01
    print(f'{final_number:.3f}')

if number_type == 'm':
    good_number = number
    if result_type == 'mm':
        final_number = good_number * 1000
    elif result_type == "cm":
        final_number = good_number * 100
    else:
        final_number = good_number
    print(f'{final_number:.3f}')