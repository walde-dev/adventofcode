from typing import Counter


with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]
    lines = [int(line) for line in lines]

currDepth,  counter,  temp = 0, 0, 0


for i, line in enumerate(lines):
    if i==0:
        temp = line
        continue
    if line>temp:
        counter+=1
    temp = line

print(counter)
