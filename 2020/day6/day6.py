input = open('input.txt').read().split("\n\n")
groups, counter = [], 0
for i in range(len(input)):
    groups.append(input[i].split('\n'))

# Part 1
print('Part 1: ')

for group in groups:
    letters = []
    for j in group:
        for i in range(0, 26):
            curr_char = chr(i + 97)
            if curr_char in letters:
                continue
            if curr_char in j:
                counter += 1
                letters.append(curr_char)
print(counter)
counter = 0


# Part 2
print('Part 2: ')

for group in groups:
    letters = list(map(chr, range(97, 123)))
    for j in group:
        for i in range(0, 26):
            curr_char = chr(i + 97)
            if curr_char not in j and curr_char in letters:
                letters.remove(curr_char)
    counter += len(letters)
print(counter)

