hours = int(input())
minutes = int(input())
new_hours = 0

minutes_new = minutes + 15

if minutes_new >= 60:
    minutes_new = minutes_new % 60
    new_hours = hours + 1
else:
    new_hours = hours

if minutes_new <= 9:
    minutes_new = '0' + str(minutes_new)

if new_hours == 24:
    new_hours = 0

print(f'{new_hours}:{minutes_new}')
