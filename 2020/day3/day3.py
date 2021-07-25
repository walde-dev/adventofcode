input = open('input.txt').read().split("\n")
input.remove('')
curr_slope, global_counter = 0, 0

# Part 1
print('Part 1: ')
for x in input:
    if x[(curr_slope * 3) % len(x)] == '#':
        global_counter += 1
    curr_slope += 1
print(global_counter)
global_counter, curr_slope = 0, 0

# Part 2
print('Part 2: ')
mult_trees = 1
slopes = [(1, 1), (3, 1), (5, 1), (7, 1), (1, 2)]
result = []

for slope in slopes:
    steps_right = 0
    for x in input:
        if slope[1] > 1 and (curr_slope+1) % slope[1] == 0:
            curr_slope += 1
            continue
        if x[(steps_right * slope[0]) % len(x)] == '#':
            global_counter += 1
        curr_slope += 1
        steps_right += 1
    mult_trees *= global_counter
    # result.append(('Right ' + str(slope[0]) + ', Down ' + str(slope[1]) + ' : ' + str(global_counter)))
    global_counter, curr_slope = 0, 0
print(str(mult_trees) + '\n')
# for a in result:
    # print(a)