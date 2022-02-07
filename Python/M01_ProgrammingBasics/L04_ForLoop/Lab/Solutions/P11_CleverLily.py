age = int(input())
price = float(input())
toy_price = float(input())

toys = 0
money = 0
given_money = 10


for each in range(1, age + 1):
    if each % 2 == 1:
        toys += 1
    else:
        money += given_money - 1
        given_money += 10

toy_money = toy_price * toys
total = toy_money + money

if total >= price:
    print(f'Yes! {total - price:.2f}')
else:
    print(f'No! {price - total:.2f}')