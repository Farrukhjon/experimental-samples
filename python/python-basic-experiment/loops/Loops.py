numbers = [1, 2, 3]

# for-in
for number in numbers:
    print(number)

# while
i = 0
size = len(numbers)
while i < size:
    print(numbers[i])
    i += 1

# for loop over a range, looping for 3 times: 0, 1, 2
for i in range(0, 3):
    print("looping over range: {}".format(i))

# for index, value by enumerate
for i, number in enumerate(numbers):
    print(i, number)

# loop over list of list:
print("loop over list of list")

list_of_list = [
    ["a", "b", "c"],
    ["e", "f", "g"],
    ["i", "j", "k"]
]

for aList in list_of_list:
    print("---")
    for i in aList:
        print(i)

# looping over two sequences using zip function
questions = ["What is you name?", "Haw old are you?", "Where are you from?"]
answers = ["Ali", "33", "Istanbul"]

for q, a in zip(questions, answers):
    print(" - {}: - {}".format(q, a))
