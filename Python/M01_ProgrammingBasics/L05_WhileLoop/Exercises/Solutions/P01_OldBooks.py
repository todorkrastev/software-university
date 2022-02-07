needed_book = input()
counter = 0

while True:
    line = input()

    if line == needed_book:
        print(f"You checked {counter} books and found it.")
        break

    if line == "No More Books":
        print(f"The book you search is not here!")
        print(f"You checked {counter} books.")
        break

    counter += 1