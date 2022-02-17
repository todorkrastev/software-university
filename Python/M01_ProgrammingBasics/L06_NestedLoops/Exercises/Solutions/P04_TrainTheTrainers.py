people = int(input())
name_doc = input()
grade_sum = 0
average_grade = 0
total_grade = 0
numbers = 0

while name_doc != "Finish":
    for x in range(people):
        grade = float(input())
        grade_sum += grade
        average_grade = grade_sum / people
    print(f"{name_doc} - {average_grade:.2f}.")
    name_doc = input()
    grade_sum = 0
    total_grade += average_grade
    numbers += 1

print(f"Student's final assessment is {total_grade / numbers:.2f}.")