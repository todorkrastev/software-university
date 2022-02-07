change = float(input())
change_in_coins = int(change * 100)
coin_count = 0

while change_in_coins > 0:

    if change_in_coins >= 200:
        coin_count += 1
        change_in_coins -= 200

    elif change_in_coins >= 100:
        coin_count += 1
        change_in_coins -= 100

    elif change_in_coins >= 50:
        coin_count += 1
        change_in_coins -= 50

    elif change_in_coins >= 20:
        coin_count += 1
        change_in_coins -= 20

    elif change_in_coins >= 10:
        coin_count += 1
        change_in_coins -= 10

    elif change_in_coins >= 5:
        coin_count += 1
        change_in_coins -= 5

    elif change_in_coins >= 2:
        coin_count += 1
        change_in_coins -= 2

    elif change_in_coins >= 1:
        coin_count += 1
        change_in_coins -= 1

print(coin_count)