listOne = [10, 30, 23, 13, 19]
listTwo = [53, 43, 14, 38, 12]

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)

for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)