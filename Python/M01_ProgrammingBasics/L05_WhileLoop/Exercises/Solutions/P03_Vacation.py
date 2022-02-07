money_needed = float(input())
money_have = float(input())
amount = 0
number_spend = 0
days = 0

while True:
    act = input()
    amount = float(input())
    days += 1

    if act == "spend":
        number_spend += 1
        money_have -= amount
        if money_have <= 0:
            money_have = 0
    else:
        number_spend = 0

    if number_spend == 5:
        print(f"You can't save the money.")
        print(f"{days}")
        break

    if act == "save":
        money_have += amount

    if money_have >= money_needed:
        print(f"You saved the money for {days} days.")
        break
