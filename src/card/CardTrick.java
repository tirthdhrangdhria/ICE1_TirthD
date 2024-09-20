/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            int value = rand.nextInt(13) + 1;
            int suitIndex = rand.nextInt(4);
            String suit = Card.SUITS[suitIndex];
            c.setValue(value);
            c.setSuit(suit);
            magicHand[i] = c;
        }
        System.out.println("Magic Hand:");
        for (Card c : magicHand) {
            System.out.println(c.getSuit() + "  " + c.getValue());
        }
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        
        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        boolean cardFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && c.getSuit().equals(userCard.getSuit())) {
                cardFound = true;
                break;
            }
        }
        // Hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Lucky card value: 7
        luckyCard.setSuit("Hearts"); // Lucky card suit: Hearts
        
        boolean luckyCardFound = false;
        for (Card c : magicHand) {
        if (c.getValue() == luckyCard.getValue() && c.getSuit().equals(luckyCard.getSuit())) {
        luckyCardFound = true;
        break;
        }
    }
    if (luckyCardFound) {
        System.out.println("The lucky card (7 of Hearts) is in the magic hand!");
    } else {
        System.out.println("The lucky card (7 of Hearts) is not in the magic hand.");
    }

        if (cardFound) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        scanner.close();
    }
}
