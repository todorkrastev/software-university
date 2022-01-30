import math
year = input()
p = int(input())  # празници в годината
h = int(input())  # брой уикенди на село

weekends_Sofia = (48 - h) * 3/4
play_in_holidays = p * 2/3
total_play = weekends_Sofia + play_in_holidays + h

total_visokosna = total_play * 1.15

if year == "normal":
    print(math.floor(total_play))
else:
    print(math.floor(total_visokosna))


