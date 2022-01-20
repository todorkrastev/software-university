time_first = int(input())
time_second = int(input())
time_third = int(input())

time_total = time_first + time_second + time_third

time_minute = 0
time_seconds = 0

if time_total / 60 >= 0:
    time_minute = time_total // 60
    time_second = time_total % 60

if time_second < 10:
    time_second = "0" + str(time_second)

print(str(time_minute) + ":" + str(time_second))