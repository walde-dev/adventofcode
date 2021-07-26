input = open('input.txt').read().split("\n")
# input.remove('')
ids = []

highest_id = 0

# Part 1
print('Part 1: ')
for boarding_pass in input:
    id, row, col, final_row, final_col = 0, [0, 127], [0, 7], 0, 0
    for i in range(0, 10):
        if boarding_pass[i] == 'F':
            row[1] = row[0] + (row[1]-row[0])//2
        elif boarding_pass[i] == 'B':
            row[0] = row[0] + ((row[1] - row[0]) + 1)//2
        elif boarding_pass[i] == 'L':
            col[1] = col[0] + (col[1]-col[0])//2
        elif boarding_pass[i] == 'R':
            col[0] = col[0] + ((col[1] - col[0]) + 1)//2
        final_row, final_col = row[0], col[0]
    id = final_row * 8 + final_col
    ids.append(id)
    if id > highest_id:
        highest_id = id
print(highest_id)


# Part 2
print('Part 2: ')
# ids.sort()
for a in ids:
    if a+1 not in ids and a != highest_id:
        print(a+1)

