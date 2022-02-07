n = int(input())

group1 = 0
group2 = 0
group3 = 0

for index in range(0, n):
    number = int(input())

    if number % 2 == 0:
        group1 += 1
    if number % 3 == 0:
        group2 += 1
    if number % 4 == 0:
        group3 += 1

p1 = (group1 / n) * 100
p2 = (group2 / n) * 100
p3 = (group3 / n) * 100

print(f"{p1:.2f}%")
print(f"{p2:.2f}%")
print(f"{p3:.2f}%")