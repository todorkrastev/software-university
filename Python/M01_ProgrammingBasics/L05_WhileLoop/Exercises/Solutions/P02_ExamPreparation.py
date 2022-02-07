max_bad_scores = int(input())
bad_scores = 0
tasks = 0
total_score = 0
last_problem = 0

while True:
    name_task = input()

    if name_task == "Enough":
        print(f"Average score: {total_score / tasks:.2f}")
        print(f"Number of problems: {tasks}")
        print(f"Last problem: {last_problem}")
        break

    score = int(input())
    tasks += 1
    total_score += score
    last_problem = name_task

    if score <= 4:
        bad_scores += 1

    if bad_scores == max_bad_scores:
        print(f"You need a break, {bad_scores} poor grades.")
        break
