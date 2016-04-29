import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Deck
	{
		private static ArrayList<Card> deck = new ArrayList<Card>();
		private static boolean gameContinues=true;
		private static int bet;
		private static int dealerTotal;
		private	static int playerTotal;
		private static int balance=100;
	
		
		public static void main(String[] args)
			{
				fillDeck();
				converse();
				shuffleDeck();
				while(gameContinues)
					{
				makeBet();
				dealDealerHand();
				dealPlayerHand();
				checkCards();
				userDecides();
					}
			
			}
		
		public static void converse()
			{
			System.out.println("Let's play Black Jack");
			Scanner userInput = new Scanner (System.in);
			String answer = userInput.nextLine();
			Scanner showCards = new Scanner (System.in);
			System.out.println("I'll deal.  Do you want to see the cards?");
			String YON = showCards.nextLine();
			YON.toLowerCase();
			if (YON.equals("yes"))
				{
					printDeck();
				}
			else if(YON.equals("no"))
				{
					
				}
			
			}
		public static void printDeck()
			{
				for(Card c : deck)
					{
						System.out.println(c.getRank() + " of " +c.getSuit());
					}
			}
		
		public static void fillDeck()
			{
				deck.add(new Card(11, "Clubs", "Ace"));
				deck.add(new Card(2, "Clubs", "Two"));
				deck.add(new Card(3, "Clubs", "Three"));
				deck.add(new Card(4, "Clubs", "Four"));
				deck.add(new Card(5, "Clubs", "Five"));
				deck.add(new Card(6, "Clubs", "Six"));
				deck.add(new Card(7, "Clubs", "Seven"));
				deck.add(new Card(8, "Clubs", "Eight"));
				deck.add(new Card(9, "Clubs", "Nine"));
				deck.add(new Card(10, "Clubs", "Ten"));
				deck.add(new Card(10, "Clubs", "Jack"));
				deck.add(new Card(10, "Clubs", "Queen"));
				deck.add(new Card(10, "CLubs", "King"));
				
				deck.add(new Card(11, "Spades", "Ace"));
				deck.add(new Card(2, "Spades", "Two"));
				deck.add(new Card(3, "Spades", "Three"));
				deck.add(new Card(4, "Spades", "Four"));
				deck.add(new Card(5, "Spades", "Five"));
				deck.add(new Card(6, "Spades", "Six"));
				deck.add(new Card(7, "Spades", "Seven"));
				deck.add(new Card(8, "Spades", "Eight"));
				deck.add(new Card(9, "Spades", "Nine"));
				deck.add(new Card(10, "Spades", "Ten"));
				deck.add(new Card(10, "Spades", "Jack"));
				deck.add(new Card(10, "Spades", "Queen"));
				deck.add(new Card(10, "Spades", "King"));
				
				deck.add(new Card(11, "Hearts", "Ace"));
				deck.add(new Card(2, "Hearts", "Two"));
				deck.add(new Card(3, "Hearts", "Three"));
				deck.add(new Card(4, "Hearts", "Four"));
				deck.add(new Card(5, "Hearts", "Five"));
				deck.add(new Card(6, "Hearts", "Six"));
				deck.add(new Card(7, "Hearts", "Seven"));
				deck.add(new Card(8, "Hearts", "Eight"));
				deck.add(new Card(9, "Hearts", "Nine"));
				deck.add(new Card(10, "Hearts", "Ten"));
				deck.add(new Card(10, "Hearts", "Jack"));
				deck.add(new Card(10, "Hearts", "Queen"));
				deck.add(new Card(10, "Hearts", "King"));
				
				deck.add(new Card(11, "Diamonds", "Ace"));
				deck.add(new Card(2, "Diamonds", "Two"));
				deck.add(new Card(3, "Diamonds", "Three"));
				deck.add(new Card(4, "Diamonds", "Four"));
				deck.add(new Card(5, "Diamonds", "Five"));
				deck.add(new Card(6, "Diamonds", "Six"));
				deck.add(new Card(7, "Diamonds", "Seven"));
				deck.add(new Card(8, "Diamonds", "Eight"));
				deck.add(new Card(9, "Diamonds", "Nine"));
				deck.add(new Card(10, "Diamonds", "Ten"));
				deck.add(new Card(10, "Diamonds", "Jack"));
				deck.add(new Card(10, "Diamonds", "Queen"));
				deck.add(new Card(10, "Diamonds", "King"));
			
			}
			
		public static void shuffleDeck()
			{
				Collections.shuffle(deck);
			}
			
		public static void makeBet()
			{
				System.out.println("Shuffling.");
				Scanner userInput = new Scanner(System.in);
				System.out.println("You have $"+balance+", please make a bet.");
				bet= userInput.nextInt();
				if (bet<0||bet>balance)
					{
						makeBet();
					}
			}
			
		public static void dealDealerHand()
			{
				dealerTotal=0;
				dealerTotal= deck.get(1).getValue()+deck.get(0).getValue();
				System.out.println("Dealer has a "+deck.get(0).getValue()+" and a hidden card.");
				System.out.println(deck.get(0).getValue()+ ", ?");
			}
			
		public static void dealPlayerHand()
			{
				playerTotal=0;
				playerTotal= deck.get(2).getValue()+deck.get(3).getValue();
				System.out.println("Player total is " + playerTotal + ".");
				System.out.println(deck.get(2).getValue()+ ", " +deck.get(3).getValue());
				deck.remove(3);
				deck.remove(2);
			}
				
		public static void checkCards()
			{
				if(playerTotal==21)
					{
						printPlayerWin();
					}
				if(playerTotal>21)
					{
						printDealerWin();
					}
				while (playerTotal<21)
				{
					System.out.println("Hit or Stay?");
					Scanner pick = new Scanner (System.in);
					String choice = pick.nextLine();
					choice.toLowerCase();
					while(choice.equals("hit"))
						{
							playerTotal=playerTotal+deck.get(2).getValue();
							System.out.println("Your new total is "+playerTotal);
							deck.remove(2);
							if(playerTotal==21)
								{
									printPlayerWin();
								}
							else if(playerTotal>21)
								{
									printDealerWin();
								}
							break;
						}
					if (choice.equals("stay"))
						{
							dealerTotal=0;
							dealerTotal= deck.get(1).getValue()+deck.get(0).getValue();
							System.out.println("Dealer total is "+ dealerTotal+".");
							System.out.println(deck.get(0).getValue()+ ", " +deck.get(1).getValue());
							if(dealerTotal==21)
								{
									printDealerWin();
								}
							if(dealerTotal==playerTotal)
								{
									printTie();
									break;
								}
							while(dealerTotal<17)
								{
									dealerTotal=dealerTotal+deck.get(2).getValue();
									System.out.println("Dealer draws another card "+deck.get(2).getValue()+".");
									System.out.println("Dealer's new total is " +dealerTotal+".");
									deck.remove(2);
									if(dealerTotal==21)
										{
											printDealerWin();
											break;
										}
									else if (dealerTotal>21)
										{
											printPlayerWin();
											break;
										}
									else
										{
										}
								}
							
							while(dealerTotal<21&&dealerTotal>=17)
								{
									if(21-playerTotal<21-dealerTotal)	
										{
											System.out.println(dealerTotal);
											printPlayerWin();
											break;
										}
									else if (21-playerTotal>21-dealerTotal)
										{
												printDealerWin();
											break;
										}
									else
										{
											printTie();
											break;
										}
								}
							break;
						}
				}
			}
		
		static void printTie()
			{
				System.out.println("Tie.  Game over.");
			}
			
		static void printDealerWin()
			{
				System.out.println("Dealer wins.");
				System.out.print("Your new balance is $");
				balance=balance-bet;
				System.out.print(balance);
				System.out.println();
			}
			
		static void printPlayerWin()
			{
				System.out.println("You win.");	
				System.out.print("Your new balance is $");
				balance= balance+bet;
				System.out.print(balance);
				System.out.println();
			}
			
		static void userDecides()
			{
				if(balance>0)
				{
					deck.remove(0);
					deck.remove(1);
					System.out.println("Would you like to play again? Yes or no?");
					Scanner playAgain= new Scanner (System.in);
					String YN = playAgain.nextLine();
					YN.toLowerCase();
					if(YN.equals("yes"))
						{	
						}
					else if(YN.equals("no"))
						{
							System.out.println("Thanks for playing.");
							System.exit(0);
						}
					else
						{
							System.out.println("I'll take that as a yes.");
						}
				}
				else if(balance==0)
				{
					System.out.println("I'm sorry you can not play anymore. Your balance is $0.");
					System.exit(0);
				}
			}
		}