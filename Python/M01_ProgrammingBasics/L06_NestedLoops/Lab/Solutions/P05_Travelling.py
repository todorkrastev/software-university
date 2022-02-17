destination = 0
new_savings = 0
savings = 0

while destination != "End":
    destination = input()
    if destination == "End":
        break
    min_budget = float(input())
    while min_budget >= new_savings:
        savings = float(input())
        new_savings += savings
        if new_savings >= min_budget:
            print(f"Going to {destination}!")
            new_savings = 0
            break
