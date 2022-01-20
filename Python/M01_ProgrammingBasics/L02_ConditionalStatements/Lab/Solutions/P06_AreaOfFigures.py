import math

item = input()

square = 0
rectangle = 0
circle = 0
triangle = 0

if item == 'square':
    square_item = float(input())
    size = square_item ** 2
    print(f'{size:.3f}')
if item == 'rectangle':
    rectangle_item1 = float(input())
    rectangle_item2 = float(input())
    size = rectangle_item1 * rectangle_item2
    print(f'{size:.3f}')
if item == 'circle':
    circle_item = float(input())
    size = math.pi * (circle_item * circle_item)
    print(f'{size:.3f}')
if item == 'triangle':
    triangle_item1 = float(input())
    triangle_item2 = float(input())
    size = triangle_item1 * (triangle_item2 / 2)
    print(f'{size:.3f}')