input = open('input.txt').read().split("\n\n")
valid_passport, counter = True, 0,
req_fields = ('byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid', 'cid')
min_byr, max_byr = 1920, 2002
min_iyr, max_iyr = 2010, 2020
min_eyr, max_eyr = 2020, 2030
min_hgt_cm, max_hgt_cm, min_hgt_in, max_hgt_in = 150, 193, 59, 76
valid_hcl_chars = ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', '#')
valid_ecl_chars = ('amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth')
print('Total number of passports: ' + str(len(input)))



def check_passport(passport):
    attributes = passport.replace('\n', ' ').split(' ')
    for i in range(len(attributes)):
        attributes[i] = attributes[i].split(':')[0]
    for a in req_fields:
        if a not in attributes and a != 'cid':
            return False
    return True


# Part 1:
print('Part 1: ')

for passport in input:
    if check_passport(passport):
        counter += 1
print(counter)
counter = 0

# Part 2:
print('Part 2: ')

for passport in input:
    valid_passport = check_passport(passport)
    attributes = passport.replace('\n', ' ').split(' ')
    for attr in attributes:
        curr_attr = attr.split(':')[0]
        # Check Birth Year
        if curr_attr == 'byr':
            byr = int(attr.split(':')[1])
            if not max_byr >= byr >= min_byr:
                # print('Birth Year not valid ' + str(byr))
                valid_passport = False
                break
        # Check Issue Year
        elif curr_attr == 'iyr':
            iyr = int(attr.split(':')[1])
            if not max_iyr >= iyr >= min_iyr:
                # print('Issue Year not valid ' + str(iyr))
                valid_passport = False
                break
        # Check Expiration Year
        elif curr_attr == 'eyr':
            eyr = int(attr.split(':')[1])
            if not max_eyr >= eyr >= min_eyr:
                # print('Expiration Year not valid ' + str(eyr))
                valid_passport = False
                break
        # Check Height
        elif curr_attr == 'hgt':
            hgt = attr.split(':')[1]
            hgt_val = int(hgt.replace('cm', '').replace('in', ''))
            hgt_metric = hgt[-2:]
            if hgt_metric == 'cm':
                if not max_hgt_cm >= hgt_val >= min_hgt_cm:
                    # print('Height not valid ' + str(hgt))
                    valid_passport = False
                    break
            elif hgt_metric == 'in':
                if not max_hgt_in >= hgt_val >= min_hgt_in:
                    # print('Height not valid ' + str(hgt))
                    valid_passport = False
                    break
        # Check Hair Color
        elif curr_attr == 'hcl':
            hcl = attr.split(':')[1]
            if not (hcl[0] == '#'):
                # print('No # in Hair Color ' + str(hcl))
                valid_passport = False
                break
            for char in hcl:
                if char not in valid_hcl_chars:
                    # print('Hair Color not valid ' + str(hcl))
                    valid_passport = False
                    break
        # Check Eye Color
        elif curr_attr == 'ecl':
            ecl = attr.split(':')[1]
            if ecl not in valid_ecl_chars:
                # print('Eye Color not valid ' + str(ecl))
                valid_passport = False
                break
        # Check Passport ID
        elif curr_attr == 'pid':
            pid = attr.split(':')[1]
            if len(pid) != 9:
                # print('Passport ID not valid ' + str(pid))
                valid_passport = False
                break
    if valid_passport:
        counter += 1
print(counter)
