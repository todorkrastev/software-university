import sys

max_num = -sys.maxsize
total_num = 0

n = int(input())

for each in range(1, n + 1):
    number = int(input())

    if max_num < number:
        max_num = number

    total_num += number

total_num = total_num - max_num

if total_num == max_num:
    print("Yes")
    print(f"Sum = {max_num}")
else:
    print("No")
    print(f"Diff = {abs(max_num - total_num)}")
