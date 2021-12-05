with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

gamma, epsilon = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

for line in lines:
    for idx, digit in enumerate(line):
        if int(digit) == 0:
            gamma[idx] = gamma[idx]-1
        if int(digit) == 1:
            gamma[idx] = gamma[idx]+1

for idx, digit in enumerate(gamma):
    if digit > 0:
        gamma[idx] = 1
        epsilon[idx] = 0
    if digit < 0:
        gamma[idx] = 0
        epsilon[idx] = 1


gamma = int(''.join(map(str, gamma)), base=2)
epsilon = int(''.join(map(str, epsilon)), base=2)


print('Part 1:', gamma, 'x', epsilon, '=', gamma*epsilon)
