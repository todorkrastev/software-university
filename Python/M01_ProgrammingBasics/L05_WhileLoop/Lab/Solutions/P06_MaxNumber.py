max_number = int(input())

line = input()
while line != "Stop":
    current = int(line)
    if current > max_number:
        max_number = current

    line = input()
print(max_number)
