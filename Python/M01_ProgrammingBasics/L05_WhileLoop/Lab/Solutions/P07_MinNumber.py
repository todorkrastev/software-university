min_number = int(input())

line = input()
while line != "Stop":
    current = int(line)
    if current < min_number:
        min_number = current

    line = input()
print(min_number)
