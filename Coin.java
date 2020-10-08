/**
 * @author GrayKnight 
 * @version 2/4/08
 * 
 * DO NOT MODIFY THIS CLASS
 */

import java.util.Random;

public class Coin implements Comparable
{
    private double myValue;
    private String myName;
    private Random coinGen = new Random();

    // Constructor
    public Coin(){
        int c = coinGen.nextInt(20) + 1;

        if (c <= 6){myValue = .01; myName = "penny";}
        else if (c <= 11){myValue = .05; myName = "nickel";}
        else if (c <= 15){myValue = .10; myName = "dime";}
        else if (c <= 18){myValue = .25; myName = "quarter";}
        else             {myValue = .50; myName = "half dollar";}
          
    }

    // Accessor Methods
    public double getValue(){
        return myValue;
    }
    public String getName(){
        return myName;
    }
    
    // toString method
    public String toString(){
        return myName + " worth " + myValue;
    }
    
    // compareTo method
    public int compareTo(Object anotherCoin) throws ClassCastException {
       if (!(anotherCoin instanceof Coin))
          throw new ClassCastException("A Coin object expected.");
       double anotherCoinValue = ((Coin) anotherCoin).getValue();  
       int diff = (int)Math.round(100*this.getValue() - 100*anotherCoinValue);  
       return diff;
    }
}
