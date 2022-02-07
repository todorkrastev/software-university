width = int(input())
length = int(input())
height = int(input())

free_space = width * length * height
space_needed = 0
diff = 0

while True:
    line = input()
    if line == "Done":
        break
    boxes = int(line)
    space_needed += boxes
    if space_needed > free_space:
        break

diff = abs(free_space - space_needed)

if space_needed > free_space:
    print(f"No more free space! You need {diff} Cubic meters more.")
else:
    print(f"{diff} Cubic meters left.")