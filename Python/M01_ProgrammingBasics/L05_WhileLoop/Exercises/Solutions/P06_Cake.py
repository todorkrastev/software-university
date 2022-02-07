width = int(input())
lenght = int(input())
count = width * lenght

while count > 0:
    line = input()

    if line == "STOP":
        break
    else:
        new_pieces = int(line)
        count = count - new_pieces

if count > 0:
    print(f"{count} pieces are left.")
else:
    print(f"No more cake left! You need {abs(count)} pieces more.")
