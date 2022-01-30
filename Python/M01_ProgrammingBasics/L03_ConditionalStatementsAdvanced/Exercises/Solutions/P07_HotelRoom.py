month = input()
days = int(input())

cost_a = 0
cost_s = 0

if month == "May" or month == "October":
    cost_a = days * 65
    cost_s = days * 50
    if 7 < days <= 14:
        cost_s = cost_s * 0.95
    if days > 14:
        cost_s = cost_s * 0.7
elif month == "June" or month == "September":
    cost_a = days * 68.70
    cost_s = days * 75.20
    if days > 14:
        cost_s = cost_s * 0.8
elif month == "July" or month == "August":
    cost_a = days * 77
    cost_s = days * 76

if days > 14:
    cost_a = cost_a * 0.9

print(f"Apartment: {cost_a:.2f} lv.")
print(f"Studio: {cost_s:.2f} lv.")