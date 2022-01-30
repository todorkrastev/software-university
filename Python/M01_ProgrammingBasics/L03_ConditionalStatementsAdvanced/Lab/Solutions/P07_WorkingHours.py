hour = int(input())
day = input()

if 0 <= hour <= 24:
    if day == 'Monday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Tuesday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Wednesday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Thursday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Friday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Saturday':
        if 10 <= hour <= 18:
            print('open')
        else:
            print('closed')
    elif day == 'Sunday':
        print('closed')
