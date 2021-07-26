input = open('input.txt').read().split("\n")
input.remove('')
bags, valid_bags = [], []
counter = 0


class Bag:
    def __init__(self, name, can_contain):
        self.name = name
        self.can_contain = can_contain

    def to_string(self):
        print(self.name)


# Part 1
print('Part 1: ')

for rule in input:
    rule = rule.split('contain')
    main_bag = rule[0].replace('bags', 'bag')[:len(rule[0])-2]
    sec_bags = rule[1].split(',')

    for i in range(len(sec_bags)):
        sec_bags[i] = sec_bags[i][3:].replace('bags', 'bag').replace('.', '')
        sec_bags[i] = Bag(sec_bags[i], [])

    curr_bag = Bag(main_bag, sec_bags)
    bags.append(curr_bag)

made_changes = True
while made_changes:
    made_changes = False
    for bag in bags:
        for i in bag.can_contain:
            if i.name == 'shiny gold bag' and bag not in valid_bags:
                valid_bags.append(bag)
                made_changes = True
            for j in valid_bags:
                if i.name == j.name and bag not in valid_bags:
                    valid_bags.append(bag)
                    made_changes = True
print(len(valid_bags))
