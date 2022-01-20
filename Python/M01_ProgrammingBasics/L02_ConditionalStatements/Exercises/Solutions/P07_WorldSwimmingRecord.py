import math

record = float(input())
distance = float(input())
speed = float(input())

normal = speed * distance
slow_down_time = distance / 15
slow_rounded = math.floor(slow_down_time)
slow = slow_rounded * 12.5
real_time = normal + slow
needed = real_time - record

if real_time < record:
    print(f'Yes, he succeeded! The new world record is {real_time:.2f} seconds.')
else:
    print(f'No, he failed! He was {needed:.2f} seconds slower.')