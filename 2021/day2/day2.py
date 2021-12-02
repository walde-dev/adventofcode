with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

# part1
hpos, depth = 0, 0

for line in lines:
    command = line.split(' ')
    if(command[0] == 'up'):
        depth -= int(command[1])
    elif(command[0] == 'down'):
        depth += int(command[1])
    else:
        hpos += int(command[1])

print(hpos*depth)

# part2
hpos, depth, aim = 0, 0, 0

for line in lines:
    command = line.split(' ')
    if(command[0] == 'up'):
        aim -= int(command[1])
    elif(command[0] == 'down'):
        aim += int(command[1])
    else:
        hpos += int(command[1])
        depth += (aim * int(command[1]))

print(hpos*depth)