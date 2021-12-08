with open('input.txt') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]


def group(seq, sep):
    g = []
    for el in seq:
        if el == sep:
            yield g
            g = []
        g.append(el)
    yield g


size = 5
# Bingo Field:
#       5  6  7  8  9
#       v  v  v  v  v
# 0 ->  0  1  2  3  4
# 1 ->  5  6  7  8  9
# 2 -> 10 11 12 13 14
# 3 -> 15 16 17 18 19
# 4 -> 20 21 22 23 24


class Bingo:
    def __init__(self, numbers):
        self.numbers = numbers

    def print(self):
        counter = 0
        for digit in self.numbers:
            if counter < 4:
                print(digit, end=' ')
            if counter >= 4:
                print(digit)
                counter = -1
            counter = counter + 1

    def check(self, number):
        for idx, digit in enumerate(self.numbers):
            if digit == (number):
                self.numbers[idx] = 'x'

    def checkForWin(self):
        counterRow, counterCol = 0, 0
        while counterRow<20:
            tempCounter, xCounter = 0, 0
            while tempCounter < 5:
                if self.numbers[counterRow+tempCounter] == 'x':
                    xCounter = xCounter + 1
                tempCounter = tempCounter + 1
            if xCounter == 5:
                return True
            xCounter  = 0
            counterRow = counterRow+5
        while counterCol<5:
            tempCounter, xCounter = 0, 0
            while tempCounter<5:
                if self.numbers[counterCol+(5*tempCounter)] == 'x':
                    xCounter = xCounter + 1
                tempCounter = tempCounter + 1
            if xCounter == 5:
                return True
            xCounter = 0
            counterCol = counterCol + 1
        return False

    def sumOfUnmarked(self):
        sum = 0
        for digit in self.numbers:
            if isinstance(digit, int):
                sum = sum + digit
        return sum



drawnNumbers = list(map(lambda x: int(x), lines[0].split(',')))

bingoInput = []
for idx, line in enumerate(lines):
    bingoInput.append(line)
bingoInput.remove(bingoInput[0])
bingoInput = list(group(bingoInput, ''))
bingoInputFormatted = []

for input in bingoInput:
    bingoField = []
    for line in input:
        if line == '':
            continue
        row = line.split(' ')
        row = list(map(lambda x: x != '' and int(x), row))
        for char in row:
            if isinstance(char, bool):
                continue
            bingoField.append(char)
    bingoInputFormatted.append(bingoField)

bingoInputFormatted.remove(bingoInputFormatted[0])

bingoObjectList = []
for input in bingoInputFormatted:
    temp = Bingo(input)
    bingoObjectList.append(temp)

winnerFound = False
for number in drawnNumbers:
    if winnerFound:
        break
    for board in bingoObjectList:
        board.check(number)
        if board.checkForWin():
            print('part1:')
            print('winning number ' + str(number))
            print('sum of unmarked ' + str(board.sumOfUnmarked()))
            print('Part 1 = ' + str(number) + ' x '+ str(board.sumOfUnmarked()) + ' = ' + str(number*board.sumOfUnmarked()))
            winnerFound = True
            break

listOfBoards = bingoObjectList
for number in drawnNumbers:
    for board in bingoObjectList:
        board.check(number)
        if board.checkForWin():
            listOfBoards.remove(board)
            if len(listOfBoards) == 1:
                print('part2:')
                print('winning number ' + str(number))
                print('sum of unmarked ' + str(board.sumOfUnmarked()))
                print('Part 2 = ' + str(number) + ' x '+ str(board.sumOfUnmarked()) + ' = ' + str(number*board.sumOfUnmarked()))
            
