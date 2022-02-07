num = int(input())
odd = 0
even = 0

for each in range(num):
    if each % 2 == 1:
        odd += int(input())
    if each % 2 == 0:
        even += int(input())

diff = abs(odd - even)

if odd == even:
    print("Yes")
    print(f"Sum = {odd}")
else:
    print("No")
    print(f"Diff = {diff}")