deposit = float(input())
months = int(input())
interest = float(input())
real_interest = interest / 100
amount = deposit + (months * ((deposit * real_interest) / 12))
print(amount)