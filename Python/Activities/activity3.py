player1 = input("Enter player1 name : ")
player2 = input("Enter player2 name : ")

player1_answer = input (player1 + ",please choose rock, paper or scissors : ")
player2_answer = input (player2 + ",please choose rock, paper or scissors : ")

if player1_answer == player2_answer:
    print("Game Tie")
elif player1_answer == 'rock':
    if player2_answer == 'scissors':
        print (player1 + " rock wins")
    else:
        print (player2 + "paper wins")
elif player1_answer == 'scissors':
    if player2_answer == 'paper':
        print (player1 + "scissors wins")
    else:
        print (player2 + "rock wins")
elif player1_answer == 'paper':
    if player2_answer == 'rock':
        print (player1 + "paper wins")
    else:
        print (player2 + "scissors")

else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")
