price_strawberry = float(input())
kg_bananas = float(input())
kg_potatoes = float(input())
kg_raspberry = float(input())
kg_strawberry = float(input())
price_raspberry = price_strawberry / 2
price_potatoes = price_raspberry * 0.6
price_bananas = price_raspberry * 0.2
cost_strawberry = price_strawberry * kg_strawberry
cost_bananas = price_bananas * kg_bananas
cost_raspberry = price_raspberry * kg_raspberry
cost_potatoes = price_potatoes * kg_potatoes
money = cost_strawberry + cost_bananas + cost_raspberry + cost_potatoes
print(money)