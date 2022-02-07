import sys
number = int(input())
max_odd = -sys.maxsize
max_even = -sys.maxsize
min_odd = sys.maxsize
min_even = sys.maxsize

odd = 0
even = 0
odd_sum = 0
even_sum = 0

for each in range(number):
    current = float(input())

    if each % 2 == 1:
        even_sum += current

        if current > max_even:
            max_even = current
        if current < min_even:
            min_even = current
    else:
        odd_sum += current

        if current > max_odd:
            max_odd = current
        if current < min_odd:
            min_odd = current

print(f"OddSum={odd_sum:.2f},")
if min_odd == sys.maxsize:
    print('OddMin=No,')
else:
    print(f"OddMin={min_odd:.2f},")
if max_odd == -sys.maxsize:
    print('OddMax=No,')
else:
    print(f"OddMax={max_odd:.2f},")

print(f"EvenSum={even_sum:.2f},")
if min_even == sys.maxsize:
    print('EvenMin=No,')
else:
    print(f"EvenMin={min_even:.2f},")
if max_even == -sys.maxsize:
    print('EvenMax=No')
else:
    print(f"EvenMax={max_even:.2f}")

