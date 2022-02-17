number1 = int(input())
number2 = int(input())

for each in range(number1, number2 + 1):
    string = str(each)

    even = 0
    odd = 0

    for index, digit in enumerate(string):
        if index % 2 == 0:
            even += int(digit)
        else:
            odd += int(digit)

    if even == odd:
        print(each, end=" ")