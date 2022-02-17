start = int(input())
end = int(input())
magic_number = int(input())
is_found = False

combinations = 0
for first in range(start, end + 1):
    for second in range(start, end + 1):
        combinations += 1
        if first + second == magic_number:
            is_found = True
            print(f"Combination N:{combinations} ({first} + {second} = {first + second})")
            break
    if is_found:
        break

if not is_found:
    print(f"{combinations} combinations - neither equals {magic_number}")


