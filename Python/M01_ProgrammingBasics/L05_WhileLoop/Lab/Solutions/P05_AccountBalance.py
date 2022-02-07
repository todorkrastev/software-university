total = 0
line = input()

while line != "NoMoreMoney":
    current = float(line)

    if current < 0:
        print("Invalid operation!")
        break
    total += current
    print(f"Increase: {current:.2f}")

    line = input()

print(f"Total: {total:.2f}")
