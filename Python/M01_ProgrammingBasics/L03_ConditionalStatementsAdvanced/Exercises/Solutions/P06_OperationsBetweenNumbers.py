N1 = int(input())
N2 = int(input())
operator = input()

if operator == "+" and (N1 + N2) % 2 == 0:
    print(f'{N1} + {N2} = {N1 + N2} - even')
elif operator == "+" and (N1 + N2) % 2 != 0:
    print(f'{N1} + {N2} = {N1 + N2} - odd')
elif operator == "-" and (N1 - N2) % 2 == 0:
    print(f'{N1} - {N2} = {N1 - N2} - even')
elif operator == "-" and (N1 - N2) % 2 != 0:
    print(f'{N1} - {N2} = {N1 - N2} - odd')
elif operator == "*" and (N1 * N2) % 2 == 0:
    print(f'{N1} * {N2} = {N1 * N2} - even')
elif operator == "*" and (N1 * N2) % 2 != 0:
    print(f'{N1} * {N2} = {N1 * N2} - odd')
elif (operator == "/" or operator == "%") and N2 == 0:
    print(f'Cannot divide {N1} by zero')
elif operator == "/":
    print(f'{N1} / {N2} = {N1 / N2:.2f}')
elif operator == "%":
    print(f'{N1} % {N2} = {N1 % N2}')