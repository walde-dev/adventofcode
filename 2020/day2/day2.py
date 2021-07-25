input = open('input.txt').read().split("\n")
globalCounter = 0

# Part 1
print('Part 1: ')
for a in input:
    if a == '':
        continue
    policy = a.split(":")
    letter = policy[0][len(policy[0]) - 1]
    min, max, counter = int(policy[0].split("-")[0]), int(policy[0].split("-")[1].split(" ")[0]), 0
    password = policy[1].replace(" ", "")
    for x in password:
        if x == letter:
            counter += 1
    if max >= counter >= min:
        globalCounter += 1
print(globalCounter)
globalCounter = 0

# Part 2
print('Part 2: ')
for a in input:
    if a == '':
        continue
    policy = a.split(":")
    letter = policy[0][len(policy[0]) - 1]
    p1, p2, counter = int(policy[0].split("-")[0]) - 1, int(policy[0].split("-")[1].split(" ")[0]) - 1, 0
    password = policy[1].replace(" ", "")
    if p1 == -1:
        p1 = 0
    if (password[p1] == letter) ^ (password[p2] == letter):
        globalCounter += 1
print(globalCounter)
