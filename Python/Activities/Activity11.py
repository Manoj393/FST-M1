fruit_shop = {
    "mango": 40,
    "apple": 25,
    "orange": 18,
    "pappaya": 35
}

check = input("Which fruit are you looking for? ").lower()

if(check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")