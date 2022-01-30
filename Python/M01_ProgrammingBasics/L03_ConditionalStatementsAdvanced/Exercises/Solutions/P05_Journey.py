budget = float(input())
season = input()
spend = 0

if budget <= 100:
    if season == "summer":
        spend = budget * 0.3
        print("Somewhere in Bulgaria")
        print("Camp - " + f'{spend:.2f}')
    elif season == "winter":
        spend = budget * 0.7
        print("Somewhere in Bulgaria")
        print("Hotel - " + f'{spend:.2f}')
elif 101 <= budget <= 1000:
    if season == "summer":
        spend = budget * 0.4
        print("Somewhere in Balkans")
        print("Camp - " + f'{spend:.2f}')
    elif season == "winter":
        spend = budget * 0.8
        print("Somewhere in Balkans")
        print("Hotel - " + f'{spend:.2f}')
else:
    spend = budget * 0.9
    print("Somewhere in Europe")
    print("Hotel - " + f'{spend:.2f}')