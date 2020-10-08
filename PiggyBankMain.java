/**
 * begins execution.
 * 
 * DO NOT MODIFY
 * 
 * @author GrayKnight 
 * @version 2/4/08  Ch10 Assignment
 */

import javax.swing.JFrame;

public class PiggyBankMain
{
 
    public static void main(String Args[])
    {
        JFrame frame = new JFrame("Mergesorting Piggy Bank");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new PiggyBankGUI());
	    frame.pack();
	    frame.setLocation(225,30);
	    frame.setResizable(false);
	    frame.setVisible(true);
    }
}
