/**
 * For chapter 7 sorting
 * @author CPM 2018
 * @version 2/4/06 mods 2/16/09, 1/27/18
 */
import java.util.ArrayList;
import java.util.Random;

public class PiggyBank{

    private ArrayList<Coin> myPiggyBankList; //this listlist holds the Coin objects
    private String myContentsStr;//for displaying bank contents

    //constructor
    public PiggyBank()
    {
        myPiggyBankList = new ArrayList<Coin>();
        this.bankContents();//update myContentsStr
    }
    
    /** 
     * Preconditon: Receives valid Coin object reference from client
     * Postcondition: Adds Coin to instance ArrayList 
     * 
     * @param  x   an object reference of type Coin   
     * @return     instance String of ArrayList contents 
     * 
     * Do Not Modify
     */
    public String addMoney(Coin x)
    {
        myPiggyBankList.add(0,x);//put coin at (0)
        this.bankContents();//update myContentsStr
        return myContentsStr;
    }
    
    /** 
     *  Searches ArrayList for Coin of the same value
     *  
     *  Precondition: Receives valid Coin object reference from client 
     *  Postcondition: Updated instance String of ArrayList contents
     * 
     * @param  x   an object reference of type Coin   
     * @return     instance String of ArrayList contents 
     * 
     */
    public String removeMoney(Coin x)
    {
        //find the index of the matching coin
        for (int z = 0; z < myPiggyBankList.size();z++)
        { //linear search
            if (x.compareTo(myPiggyBankList.get(z)) == 0)
            {
                myPiggyBankList.remove(z);
                this.bankContents();//update myContentsStr
                return myContentsStr;
            }
        }
        this.bankContents();//update myContentsStr
        return myContentsStr;
    }
    
    /** 
     *  Postcondition: Performs an ascending sort on the ArrayList contents
     *    according to the compareTo method of Coin.
     * 
     *  Demonstrate the use of mergesort here
     */
    public String sortMoney()
    {

      return myContentsStr;
    }
    

	
    /**
     *  Private Helper Method
     *  Builds the string that shows the Piggybank contents. 
     * 
     * Do Not Modify
     */
    private void bankContents()
    {   double total$ = 0;
        if(myPiggyBankList.size() == 0) 
                myContentsStr = "The Coin Purse is Empty";
        else
        {
            myContentsStr = "";
            for (int x = 0; x < myPiggyBankList.size(); x++)
            {
                myContentsStr += " $" +(myPiggyBankList.get(x)).getValue() + 
                    " \t" + (myPiggyBankList.get(x)).getName() + "\n";
                total$ += (myPiggyBankList.get(x)).getValue();
            }
            total$ = (Math.round(total$ * 100))/100.0;  //clean up trailing decimals.
            myContentsStr += "For a total value of $" + total$;
        }              
    }    
}
