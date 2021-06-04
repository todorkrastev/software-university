number = float(input())

if number == 0:
    print("zero")
elif 0 < number:
    if number < 1:
        print("small positive")
    elif 1000000 < number:
        print("large positive")
    elif 1 <= number <= 1000000:
        print("positive")
else:
    if abs(number) < 1:
        print("small negative")
    elif 1000000 < abs(number):
        print("large negative")
    elif 1 <= abs(number) <= 1000000:
        print("negative")
