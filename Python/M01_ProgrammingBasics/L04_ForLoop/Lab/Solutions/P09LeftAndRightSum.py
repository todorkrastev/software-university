num = int(input())
left = 0
right = 0

for each in range(num):
    left += int(input())

for each in range(num):
    right += int(input())

diff = abs(left - right)

if left == right:
    print(f"Yes, sum = {right}")
else:
    print(f"No, diff = {diff}")