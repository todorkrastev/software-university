import sys

max_num = -sys.maxsize
min_num = sys.maxsize
current = 0

numbers = int(input())

for each in range(numbers):
    current = int(input())

    if current > max_num:
        max_num = current
    if current < min_num:
        min_num = current

print(f'Max number: {max_num}')
print(f'Min number: {min_num}')