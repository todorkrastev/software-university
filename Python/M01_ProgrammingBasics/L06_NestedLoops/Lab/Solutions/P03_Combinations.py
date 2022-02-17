n = int(input())
result = 0

for x in range(0, n + 1):
    for y in range(0, n + 1):
        for z in range(0, n + 1):
            if x + y + z == n:
                result += 1

print(result)