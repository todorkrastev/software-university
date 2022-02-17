command = input()

prime_number = 0
non_prime_number = 0

while command != "stop":
    number = int(command)
    delitel = 0
    if number < 0:
        print("Number is negative.")
    else:
        for x in range(2, number + 1):
            if number % x == 0:
                delitel += 1
    if delitel == 1:
        prime_number += number
    elif delitel > 1:
        non_prime_number += number

    command = input()

print(f"Sum of all prime numbers is: {prime_number}")
print(f"Sum of all non prime numbers is: {non_prime_number}")