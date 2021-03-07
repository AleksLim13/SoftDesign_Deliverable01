/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project.Cards;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * return values: a String representation of a card. 
     * Could be an UNO card, a regular playing card etc.
     */
    
        public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS, DEFAULT};
        public enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, DEFAULT};
        protected Suit suit;
        protected Value value;
        private Suit[] suitList; 
        private Value[] valueList; 
        
        //Default Constructor:
        public Card(){
            suit = Suit.DEFAULT;
            value = Value.DEFAULT;
        }//End C:*
        
        public Card(Suit s, Value gVal)
        {
           suit =s;
           value= gVal;
        }//End C:*
        
	public Value getValue() {
		return this.value;
	}//End G:*

	
	public Suit getSuit() {
		return this.suit;
        }//End G:*
        
        //Extract values and add them field var list
        public void setSuitList(){
            //A:
            this.suitList = Suit.values();
            
        }
        
        //Make this var normal array of card values 
        public void setValueList(){
            //A: 
           this.valueList = Value.values();
       
        }
        
        //Return value of list 
        public Suit[] getSuitList(){
        return suitList;
        }
        
        //Return value of list
        public Value[] getValueList(){
            return valueList;
        }
        
    @Override
    public abstract String toString();
    
}//End Class:_______________________+
