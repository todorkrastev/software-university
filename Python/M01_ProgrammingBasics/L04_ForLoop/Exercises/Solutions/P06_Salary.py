tabs = int(input())
salary = int(input())

for each in range(tabs):
    website = input()
    if website == "Facebook":
        salary -= 150
    if website == "Instagram":
        salary -= 100
    if website == "Reddit":
        salary -= 50
    else:
        continue

if salary <= 0:
    print('You have lost your salary.')
else:
    print(salary)