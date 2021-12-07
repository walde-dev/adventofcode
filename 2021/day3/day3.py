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

pos = 0
while pos < 12:
    if(len(lines) == 1):
        break
    # get highest occuring bit in pos
    toRemove = []
    counter = 0
    for line in lines:
        if int(line[pos]) == 0:
            counter = counter - 1
        if int(line[pos]) == 1:
            counter = counter + 1

    # 1 is highest occurent at pos
    if counter >= 0:
        for line in lines:
            if int(line[pos]) == 0:
                toRemove.append(line)

    # 0 is highest occurent at pos
    if counter < 0:
        for line in lines:
            if int(line[pos]) == 1:
                toRemove.append(line)

    for removal in toRemove:
        if removal in lines:
            lines.remove(removal)
    counter = 0
    pos = pos + 1

oxygen = lines

with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

pos = 0
while pos < 12:
    if(len(lines) == 1):
        break
    # get highest occuring bit in pos
    toRemove = []
    counter = 0
    for line in lines:
        if int(line[pos]) == 0:
            counter = counter - 1
        if int(line[pos]) == 1:
            counter = counter + 1

    # 1 is highest occurent at pos
    if counter >= 0:
        for line in lines:
            if int(line[pos]) == 1:
                toRemove.append(line)

    # 0 is highest occurent at pos
    if counter < 0:
        for line in lines:
            if int(line[pos]) == 0:
                toRemove.append(line)

    for removal in toRemove:
        if removal in lines:
            lines.remove(removal)
    counter = 0
    pos = pos + 1

scrubber = lines

print(oxygen)

oxygen = int(''.join(map(str, oxygen)), base=2)
scrubber = int(''.join(map(str, scrubber)), base=2)
gamma = int(''.join(map(str, gamma)), base=2)
epsilon = int(''.join(map(str, epsilon)), base=2)

print('Part 1:', gamma, 'x', epsilon, '=', gamma*epsilon)
print('Part 2:', oxygen, 'x', scrubber, '=', oxygen*scrubber)

