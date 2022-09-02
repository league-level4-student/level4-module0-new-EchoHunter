package _06_Card_Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CardDealer {

	static ArrayList<Card> deck;
	static ArrayList<Card> discard;
	static ArrayList<Card> hand;
	static ArrayList<Card> dealer;
	static Suit[] suits = new Suit[4];
	static Rank[] ranks = new Rank[13];

	public static void main(String[] args) {
		int contPlay = 0;
		Boolean nonStand = true;
		discard = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		dealer = new ArrayList<Card>();
		newDeck();
		while (contPlay == 0) {
			clearHands();
			dealCard(hand);
			dealCard(dealer);
			dealCard(hand);
			Card c = deck.get(0);
			deck.remove(0);
			nonStand = true;
			while (nonStand) {
				String choice = JOptionPane.showInputDialog(
						"You have " + getHand(hand) + ". The dealer's visible card is " + dealer.get(0).getRank()
								+ " of " + dealer.get(0).getSuit() + "\nType H to hit, S to stand");
				if (choice.equals("H")) {
					dealCard(hand);
					if(isBust(hand)) {
						JOptionPane.showMessageDialog(null, "Bust, you lose");
						nonStand = false;
					}
				} else if (choice.equals("S")) {
					nonStand = false;
				}
			}
			if(!isBust(hand)) {
			dealer.add(c);
			JOptionPane.showMessageDialog(null, "Dealer turns over " + c.getRank() + " of " + c.getSuit());
			
			while(getHand(dealer) < 17) {
				dealCard(dealer);
			}
			JOptionPane.showMessageDialog(null, "Dealer has " + getHand(dealer) + "\nYou have " + getHand(hand));
			if ((isBust(dealer))&&(!isBust(hand))) {
				JOptionPane.showMessageDialog(null, "Dealer Bust, you win");
			}
			else if (getHand(dealer)>getHand(hand)) {
				JOptionPane.showMessageDialog(null, "Dealer has " + getHand(dealer) + ", you lose");
			}
			else if (getHand(dealer) == getHand(hand)) {
				JOptionPane.showMessageDialog(null, "Push, you tie");
			}
			else {
				JOptionPane.showMessageDialog(null, "Dealer has " + getHand(dealer) + ", you win");
			}
			}
			contPlay = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
		
		}
	}

	public static void newDeck() {
		Random rand = new Random();
		Card card;
		suits[0] = Suit.Hearts;
		suits[1] = Suit.Clubs;
		suits[2] = Suit.Diamonds;
		suits[3] = Suit.Spades;
		ranks[0] = Rank.TWO;
		ranks[1] = Rank.THREE;
		ranks[2] = Rank.FOUR;
		ranks[3] = Rank.FIVE;
		ranks[4] = Rank.SIX;
		ranks[5] = Rank.SEVEN;
		ranks[6] = Rank.EIGHT;
		ranks[7] = Rank.NINE;
		ranks[8] = Rank.TEN;
		ranks[9] = Rank.JACK;
		ranks[10] = Rank.QUEEN;
		ranks[11] = Rank.KING;
		ranks[12] = Rank.ACE;
		int suitNum = 0;
		int rankNum = 0;
		for (int i = 0; i < 53; i++) {
			suitNum = rand.nextInt(4);
			rankNum = rand.nextInt(13);

			card = new Card(ranks[rankNum], suits[suitNum]);
			while (deck.contains(card)) {
				suitNum = rand.nextInt(4) + 1;
				rankNum = rand.nextInt(12) + 2;
				card = new Card(ranks[rankNum], suits[suitNum]);
			}
			deck.add(card);
		}
	}

	public static void shuffle() {
		Card placeholder;
		Random rand = new Random();
		int place = 0;
		for (int i = 0; i < deck.size(); i++) {
			place = rand.nextInt(52);
			placeholder = deck.get(place);
			deck.set(place, deck.get(i));
			deck.set(i, placeholder);
		}
	}

	public static void dealCard(ArrayList<Card> cardHand) {
		Random rand = new Random();
		int selection = rand.nextInt(deck.size());
		cardHand.add(deck.get(selection));
		if(deck.size()==0) {
			JOptionPane.showMessageDialog(null, "deck empty, shuffling in discard pile");
			for (int i = 0; i < discard.size(); i++) {
				deck.add(discard.get(i));
				discard.remove(i);
			}
			shuffle();
		}
		if (cardHand.equals(hand)) {
			JOptionPane.showMessageDialog(null,
					"Dealt " + deck.get(selection).getRank() + " of " + deck.get(selection).getSuit() + " to player");
			
		}
		if (cardHand.equals(dealer)) {
			JOptionPane.showMessageDialog(null,
					"Dealt " + deck.get(selection).getRank() + " of " + deck.get(selection).getSuit() + " to dealer");
		}
		
		
		
		deck.remove(selection);
	}


	public static void clearHands() {
		hand.clear();
		dealer.clear();
	}

	public static int getHand(ArrayList<Card> cardHand) {
		int returned = 0;
		for (int i = 0; i < cardHand.size(); i++) {
			returned += cardHand.get(i).getRank().getRankValue();
		}
		if(returned > 21) {
			for (int i = 0; i < cardHand.size(); i++) {
				if (cardHand.get(i).getRank() == Rank.ACE) {
					returned -= 10;
					if (returned <= 21) {
						break;
					}
				}
			}
		}
		return returned;
	}

	public static Boolean isBust(ArrayList<Card> cardHand) {
		if (getHand(cardHand) > 21) {
			return true;
		}
		return false;
	}

}
