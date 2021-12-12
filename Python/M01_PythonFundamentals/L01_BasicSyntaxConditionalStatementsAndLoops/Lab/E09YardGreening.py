square_meters = float(input())
price_per_square_meter = 7.61

price_greening = square_meters * price_per_square_meter
discount = price_greening * 1.0 * 0.18
final_price = price_greening * 0.82

formatted_discount = "{:.2f}".format(discount)
formatted_final_price = "{:.2f}".format(final_price)

print(f'The final price is: {formatted_final_price} lv.')
print(f'The discount is: {formatted_discount} lv.')
