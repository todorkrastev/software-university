torta = 45
gofreta = 5.80
palachinka = 3.20
days = int(input())
chefs = int(input())
num_torta = int(input())
num_gofreta = int(input())
num_palachinka = int(input())
amount_1 = torta * num_torta
amount_2 = gofreta * num_gofreta
amount_3 = palachinka * num_palachinka
power = days * chefs * (amount_1 + amount_2 + amount_3)
commission = power / 8
print(power - commission)