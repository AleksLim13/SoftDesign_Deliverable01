
package ca.sheridancollege.project.Turns;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.Player;
import java.util.List;

/**
 *
 * @author AllyCat13 : Sheridan High 2021. 
 * 
 * ---------------------------------------------------------------------<
 * CLASS OVERVIEW:
 * ----------------
 * 
 * What is this class all about? Is it well designed? If so, how? 
 * So, show and tell. Tasks related to strategy. 
 * Tasks related to determining what to ask for. Determining based on the
 * content of a players hand. Many calculations performed here related to 
 * the advancement of the game. 
 * ----------------------------------------------------------------------<
 */
public class ScoreBoard {
    //Declare:
    private Player winner;
 
    public ScoreBoard() 
    {
    }//End C:*

    public ScoreBoard(Player winner) 
    {
        this.winner = winner;
    }//End C:*

    public Player getWinner() 
    {
        return winner;
    }//End G:*

    public void setWinner(Player winner) 
    {
        this.winner = winner;
    }//End S:*
    
    public void calcBooks(
            Card tNum,
            List<Card> dupes,
            List<Card> books,
            List<Card> hand
    ) {
        int ilCount = 0;
        //Repeat: set outer loop. 
        for (int i = 0; i < dupes.size(); i++) 
        {
            //A.3.1: Check:
            if (tNum.equals(dupes.get(i))) 
            {
                //Increment: counter if already in duplicate list. 
                ilCount++;
            }//End I:*                    
        }//End F:*
        if (ilCount == 4) 
        {
            //Add: 
            books.add(tNum);
            //Notice: should only ever be four of a kind. E.g., standard deck format. 
            for (int j = 0; j < 4; j++) 
            {
                hand.remove(findFirstIndex(tNum, hand));
            }//End I:*                  
        }//End I:*  
    }//End M:*
     
     public int findFirstIndex(
            Card tNum,
            List<Card> tList
    ) {
        int pos = 0;
        for (int i = 0; i < tList.size(); i++) {
            if (tNum.equals(tList.get(i))) {
                pos = i;
                return pos;
            }//End I:*
        }//End F:*
        return pos;
    }//End M:*
      
       //Define: get a list of duplicate cards. Nested for loop structure with if check.
     //Notice: don't use 1 field variable for dupes if this will be called for different players. 
    public void getDupes(
                              Player player
                              ) 
    {
        //A: main for loop: compare each card to every other card in hand.
        for (int i = 0; i < player.getHand().size(); i++) {
            int lCount = 0;
            //A.1: par two of compare each card to every other card in hand.
            //----
            for (int j = 0; j < player.getHand().size(); j++) {
                //Notice: duplicates determined only by card value.
                if (player.getHand().get(i).getValue().equals(player.getHand().get(j).getValue())) {
                    //A.1.1: increase counter if they are equal. 
                    lCount++;
                }//End I:*
            }//End F:*
            //A.2: counter > 1 means theres duplicates.
            //-----
            //Check: 
            if (lCount > 1) {
                player.getDesirableList().add(player.getHand().get(i));
            }//End I:*
        }//End F:*
    }//End M:*
    
    

    //Define: under construction...
    public Player determineWinner(Player human, Player computer) {
        if(human.getBooks().size() > computer.getBooks().size()){
            winner = human;
        }//End I:*
        else{
            winner = computer;
        }//End E:*
        return winner;
    }//End M:*
    
}//End CL:*