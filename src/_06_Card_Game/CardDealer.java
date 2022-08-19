package _06_Card_Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CardDealer {
    
    static ArrayList<Card> deck;
    static Suit[] suits = new Suit[4];
    static Rank[] ranks = new Rank[13];
    public static void main(String[] args) {
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
    		suitNum = rand.nextInt(4)+1;
    		rankNum = rand.nextInt(12)+2;
    		
    		card = new Card(ranks[rankNum], suits[suitNum]);
    		while (deck.contains(card)) {
				type type = (type) en.nextElement();
				
			}
		}
	}
}
