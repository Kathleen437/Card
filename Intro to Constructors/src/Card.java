

public class Card
	{
		private int value;
		String suit;
		String rank;

		public static void main(String[] args)
			{
			}
		
		public Card (int v, String s, String r)
		{	value = v;
			suit = s;
			rank = r;
		
		}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
			}

		public String getSuit()
			{
				return suit;
			}

		public void setSuit(String suit)
			{
				this.suit = suit;
			}

		public String getRank()
			{
				return rank;
			}

		public void setRank(String rank)
			{
				this.rank = rank;
			}

		
		
			

			}
