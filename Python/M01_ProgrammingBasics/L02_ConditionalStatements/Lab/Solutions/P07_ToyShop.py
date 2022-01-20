puzzle = 2.60
doll = 3
bear = 4.10
minion = 8.20
truck = 2

trip_price = float(input())
num_puzzle = int(input())
num_doll = int(input())
num_bear = int(input())
num_minion = int(input())
num_truck = int(input())

total_toys = num_puzzle + num_doll + num_bear + num_minion + num_truck
total_price = float(num_puzzle * puzzle) + float(num_doll * doll) + float(num_bear * bear) + float(num_minion * minion) + float(num_truck * truck)

rest = 0

if total_toys >= 50:
    total_price = total_price * 0.75
else:
    total_price = total_price * 1.00

final_money = total_price * 0.9

if final_money >= trip_price:
    print(f"Yes! {final_money - trip_price:.2f} lv left.")
else:
    print(f"Not enough money! {trip_price - final_money:.2f} lv needed.")
