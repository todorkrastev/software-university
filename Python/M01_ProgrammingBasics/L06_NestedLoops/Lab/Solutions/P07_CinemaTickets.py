capacity = 0
total_tickets = 0
kid = 0
student = 0
standard = 0

while True:
    movie = input()
    if movie == "Finish":
        break
    total_available = int(input())
    available = total_available

    while available != 0:
        seat_type = input()
        if seat_type == "End":
            break
        else:
            if seat_type == "kid":
                kid += 1
            elif seat_type == "student":
                student += 1
            elif seat_type == "standard":
                standard += 1
        available = available - 1
        total_tickets += 1
        capacity = ((total_available - available) / total_available) * 100
    print(f"{movie} - {capacity:.2f}% full.")

student_p = (student / total_tickets) * 100
standard_p = (standard / total_tickets) * 100
kid_p = (kid / total_tickets) * 100

print(f"Total tickets: {total_tickets}")
print(f"{student_p:.2f}% student tickets.")
print(f"{standard_p:.2f}% standard tickets.")
print(f"{kid_p:.2f}% kids tickets.")
