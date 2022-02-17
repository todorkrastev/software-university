number = int(input())

for first in range(1, 10):
    if number % first == 0:
        for second in range(1, 10):
            if number % second == 0:
                for third in range(1, 10):
                    if number % third == 0:
                        for fourth in range(1, 10):
                            if number % fourth == 0:
                                print(f"{first}{second}{third}{fourth}", end=" ")