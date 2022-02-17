floors = int(input())
rooms = int(input())

for x in range(floors, 0, -1):
    room_type = ""
    if x == floors:
        room_type = "L"
    elif x % 2 == 1:
        room_type = "A"
    elif x % 2 == 0:
        room_type = "O"

    for y in range(rooms):
        print(f"{room_type}{x}{y}", end=" ")
    print()
