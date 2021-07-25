input = map(int, open('day1/input.txt').read().split())
found = False

# Part 1
print('Part 1:')
for x in input:
    if 2020-x in input:
        print(x, 2020-x, x*(2020-x))
        break

# Part 2
print('Part 2:')
for x in input:
    for y in input:
        if 2020-x-y in input:
            print(x, y, 2020-x-y, x*y*(2020-x-y))
            found = True
            break
    if found:
        break
