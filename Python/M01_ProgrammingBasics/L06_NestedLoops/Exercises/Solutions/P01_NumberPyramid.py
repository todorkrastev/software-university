n = int(input())
new = 0
proof = False

for x in range(1, n + 1):
    for y in range(1, x + 1):

        if new >= n:
            proof = True
            break

        new += 1
        print(str(new) + " ", end="")
    if proof:
        break
    print()