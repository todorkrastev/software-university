name = input()
type = 0

if name == 'banana' \
        or name == 'apple' \
        or name == 'kiwi' \
        or name == 'cherry' \
        or name == 'lemon' \
        or name == 'grapes':
    type = 'fruit'
elif name == 'tomato' \
        or name == 'cucumber' \
        or name == 'pepper' \
        or name == 'carrot':
    type = 'vegetable'
else:
    type = 'unknown'

print(type)