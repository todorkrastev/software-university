hour_exam = int(input())
min_exam = int(input())
hour_arrival = int(input())
min_arrival = int(input())

status = 0

exam_time = (hour_exam * 60) + min_exam
arrival_time = (hour_arrival * 60) + min_arrival

difference = arrival_time - exam_time

if difference > 0:
    status = "Late"
elif difference < -30:
    status = "Early"
elif -30 <= difference <= 0:
    status = "On time"

print(status)

if difference > 0:
    hour_late = difference // 60
    min_late = difference % 60
    if hour_late == 0:
        print(f'{min_late} minutes after the start')
    else:
        print(f'{hour_late}:{min_late:02d} hours after the start')
elif difference == 0:
    print('')
else:
    early = exam_time - arrival_time
    hour_early = early // 60
    min_early = early % 60
    if hour_early == 0:
        print(f'{min_early} minutes before the start')
    else:
        print(f'{hour_early}:{min_early:02d} hours before the start')




