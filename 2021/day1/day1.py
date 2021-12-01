with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]
    lines = [int(line) for line in lines]


def count_increments(list):
    counter,  temp = 0, 0
    for i, line in enumerate(list):
        if i == 0:
            temp = line
            continue
        if line > temp:
            counter += 1
        temp = line
    return counter


# part1
print(count_increments(lines))

# part2
temp1, temp2, total = 0, 0, 0
windows = []

for i, line in enumerate(lines):
    if i == 0:
        temp1 = line
        continue
    if i == 1:
        temp2 = temp1
        temp1 = line
        continue
    total = temp1+temp2+line
    windows.append(total)
    temp2 = temp1
    temp1 = line

print(count_increments(windows))
