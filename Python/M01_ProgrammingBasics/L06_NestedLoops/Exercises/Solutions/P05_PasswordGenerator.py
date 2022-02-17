n = int(input())
l = int(input())

for first in range(1, n + 1):
    for second in range(1, n + 1):
        for third in range(ord("a"), ord("a") + l):
            for fourth in range(ord("a"), ord("a") + l):
                for fifth in range(1, n + 1):
                    if first < fifth > second:
                        print(f"{first}{second}{chr(third)}{chr(fourth)}{fifth}", end=" ")