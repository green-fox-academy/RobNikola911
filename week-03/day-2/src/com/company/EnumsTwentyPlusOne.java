package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwentyPlusOne {
    public class Player {

        private String nickName;
        private int playerNumOfCards;
        ArrayList<Card> playerHand;

        public Player(String name) {
            this.nickName = name;
            playerHand = new ArrayList<Card>();

        }

        public String getNickName() {
            return nickName;
        }

        public void addCard(Card aCard) {
            playerHand.add(aCard);
            this.playerNumOfCards++;
        }

        public int getHandSum() {
            int totalSum = 0;
            for (Card countSum : playerHand) {
                totalSum = totalSum + countSum.getFace();
            }
            return totalSum;
        }

        public void getPlayerHand(boolean hideCard) {
            System.out.println(this.nickName + "s current hand.");
            for (int c = 0; c < playerNumOfCards; c++) {
                if (c == 0 && !hideCard) {
                    System.out.println("[Hidden card]");
                } else {
                    System.out.println(playerHand.get(c).toString());
                }
            }
        }
    }

    public Player(String name) {
        this.nickName = name;
        playerHand = new ArrayList<Card>();

    }

    public String getNickName() {
        return nickName;
    }

    public void addCard(Card aCard) {
        playerHand.add(aCard);
        this.playerNumOfCards++;
    }

    public int getHandSum() {
        int totalSum = 0;
        for (Card countSum : playerHand) {
            totalSum = totalSum + countSum.getFace();
        }
        return totalSum;
    }

    public class Card {

        private Face face; //Face of card, i.e "King" & "Queen"
        private Suit suit; //Suit of card, i.e "Hearts" & "diamonds"
        int total = 0;

        public Card(Face cardFace, Suit cardSuit) { //Constructor which initializes card's face and suit
            this.face = cardFace;
            this.suit = cardSuit;
        }

        public int getFace() {
            return face.getFaceValue();
        }

        public String getSuit() {
            return suit.PrintSuitText();
        }

        public String toString() { //return String representation of Card
            return face + " of " + suit;
        }
    }

    public enum Suit {

        HEARTS(" Hearts"),
        SPADES(" Spades"),
        DIAMONDS(" Diamonds"),
        CLUBS(" Clubs");

        private final String suitText;

        private Suit(String suitText) {
            this.suitText = suitText;
        }

        public String PrintSuitText() {
            return suitText;
        }
    }

    public enum Face {

        ACE(1), DEUCE(2), THREE(3),
        FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(10), QUEEN(10),
        KING(10);


        private final int faceValue;

        private Face(int faceValue) {
            this.faceValue = faceValue;
        }

        public int getFaceValue() {
            return faceValue;
        }
    }

    public void getPlayerHand(boolean hideCard) {
        System.out.println(this.nickName + "s current hand.");
        for (int c = 0; c < playerNumOfCards; c++) {
            if (c == 0 && !hideCard) {
                System.out.println("[Hidden card]");
            } else {
                System.out.println(playerHand.get(c).toString());
            }
        }
    }

    public class DeckOfCards {

        private Card[] deck;
        private static final Random random = new Random();

        private int currentCard; //index of next Card to be deal (0-51)
        private static int NUMBER_OF_CARDS = 52; //Constant number of cards

        public DeckOfCards() {

            Face[] faces = {Face.ACE, Face.DEUCE, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX,
                    Face.SEVEN, Face.EIGHT, Face.NINE, Face.TEN, Face.JACK, Face.QUEEN,
                    Face.KING};
            Suit[] suits = {Suit.HEARTS, Suit.SPADES, Suit.DIAMONDS, Suit.CLUBS};

            deck = new Card[NUMBER_OF_CARDS]; // create array with Cards (52)
            currentCard = 0;

            //Populate deck with Cards
            for (int count = 0; count < deck.length; count++)
                deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }

        public void shuffleDeck() {
            currentCard = 0;

            for (int first = 0; first < deck.length; first++) {

                int second = random.nextInt(NUMBER_OF_CARDS); //Select a random card from number 0-51 (Number_of_cards)

                //Loops through all the cards and swaps it with the "Second" card which is randomly chosen card from hte same list.
                Card temp = deck[first];
                deck[first] = deck[second];
                deck[second] = temp;
            }
        }

        public void getCardDeck() {
            int start = 1;
            for (Card k : deck) {
                System.out.println("" + start + "/52 " + k);
                start++;
            }
        }

        public Card dealNextCard() {

            //Get the top card
            Card topCard = this.deck[0];

            //shift all the subsequent cards to the left by one index
            for (int currentCard = 1; currentCard < NUMBER_OF_CARDS; currentCard++) {
                this.deck[currentCard - 1] = this.deck[currentCard];
            }
            this.deck[NUMBER_OF_CARDS - 1] = null;

            //decrement the number of cards in our deck
            this.NUMBER_OF_CARDS--;

            return topCard;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean stay = false;

        System.out.println("What nickName would you like to have?");
        String pAnswer = scanner.nextLine();
        Player me = new Player(pAnswer);
        Player dealer = new Player("Dealer");


        System.out.println("Would you like to start a new game?  'Yes/No' :");
        pAnswer = scanner.nextLine();

        if (pAnswer.equalsIgnoreCase("Yes")) {

            DeckOfCards deck1 = new DeckOfCards();
            Card card1 = new Card(Face.ACE, Suit.CLUBS);
            deck1.shuffleDeck();

            me.addCard(deck1.dealNextCard());
            me.addCard(deck1.dealNextCard());
            me.getPlayerHand(true);
            System.out.println(" ");
            dealer.addCard(deck1.dealNextCard());
            dealer.addCard(deck1.dealNextCard());
            dealer.getPlayerHand(false);

            //PLAYER
            do {
                System.out.println("Would " + me.getNickName() + " like to bust or stay? 'Bust/Stay'");
                pAnswer = scanner.nextLine();
                //BUST
                if (pAnswer.equalsIgnoreCase("Bust")) {
                    me.addCard(deck1.dealNextCard());
                    System.out.println(me.getHandSum());
                    if (me.getHandSum() > 21) {
                        System.out.println("You busted and got a total of " + me.getHandSum() + ". Dealer wins this time! ");
                        System.exit(0);
                    }
                }
                //STAY
                if (pAnswer.equalsIgnoreCase("stay")) {
                    System.out.println("You have chosen to stay. Your hand: " + me.getHandSum());
                }

            } while (pAnswer.equalsIgnoreCase("Bust"));

            //DEALER
            stay = false;

            do {
                System.out.println("");
                System.out.println("- Dealers turn -");
                //DRAW CARD
                if (dealer.getHandSum() <= 15) {
                    dealer.addCard(deck1.dealNextCard());
                    if (dealer.getHandSum() == 15) {
                        System.out.println("Blackjack! Dealer won.");
                        System.exit(0);
                    }
                    if (dealer.getHandSum() > 21) {
                        System.out.println("Dealer busted and got a total of " + dealer.getHandSum() + ". " + me.getNickName() + " wins this time!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Dealer has chosen to stay!");
                    int totalDealerSum = dealer.getHandSum();
                    int totalPlayerSum = me.getHandSum();

                    if (totalDealerSum > totalPlayerSum) {
                        System.out.println("Both players has decided to stay. The winner is " + dealer.getNickName() + " with a total of " + totalDealerSum + ".");
                    } else {
                        System.out.println("Both players has decided to stay. The winner is " + me.getNickName() + " with a total of " + totalPlayerSum + ".");
                    }
                    stay = false;
                }

            } while (stay);
        }
    }
}
}