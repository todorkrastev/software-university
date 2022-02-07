year = 1
name = input()
skasan = 0
total = 0

while year <= 12:
    grade = float(input())
    if grade < 4:
        if skasan > 0:
            break
        skasan += 1
        continue
    total += grade
    year += 1
if year > 12:
    print(f"{name} graduated. Average grade: {total / 12:.2f}")
else:
    print(f"{name} has been excluded at {year} grade")