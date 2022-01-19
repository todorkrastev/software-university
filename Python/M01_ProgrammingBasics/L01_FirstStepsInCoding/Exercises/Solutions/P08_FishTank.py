length = int(input())
width = int(input())
height = int(input())
occupied = float(input())
occupied_percent = occupied / 100
full_capacity = length * width * height
occupied_total = occupied_percent * full_capacity
remaining = full_capacity - occupied_total
capacity_in_dm = remaining / 1000
water = capacity_in_dm
print(water)