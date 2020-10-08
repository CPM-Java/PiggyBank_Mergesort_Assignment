
/**
 * GUI for Ch10 part II test.
 * 
 * @author GrayKnight 
 * @version 2/03/08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiggyBankGUI extends JPanel
{
    // instance variables and GUI objects
    private JTextField nextCoinField;
    private JTextArea PiggyBankContentArea;
    private JLabel ncLabel, pcLabel;
    private JButton nextCoin, removeCoin, addCoin, clearPiggyBank, sortPiggyBank;
    private Coin myCoin;
    private PiggyBank myPiggyBank;
    private ButtonListener Listener = new ButtonListener();
    
    private final int FRAME_WIDTH = 400, FRAME_HEIGHT = 500;

    /**
     * Constructor for objects of class drawkcabGUI
     */
    public PiggyBankGUI()
    {
        myPiggyBank = new PiggyBank();
        myCoin = new Coin();
        
        ncLabel = new JLabel("Next Coin:");
        ncLabel.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        add(ncLabel);
        
        nextCoinField = new JTextField(myCoin.getName());
        nextCoinField.setPreferredSize(new Dimension(FRAME_WIDTH*2/3, 20));
        add(nextCoinField);
        
        nextCoin = new JButton("Change Coin");
        nextCoin.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        nextCoin.addActionListener(Listener);
        add(nextCoin);
        
        addCoin = new JButton("Add Coin");
        addCoin.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        addCoin.addActionListener(Listener);
        add(addCoin);
        
        removeCoin = new JButton("Remove Coin");
        removeCoin.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        removeCoin.addActionListener(Listener);
        add(removeCoin);
        
        pcLabel = new JLabel("PiggyBank Contents:");
        pcLabel.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        add(pcLabel);
        
        clearPiggyBank = new JButton("New PiggyBank");
        clearPiggyBank.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        clearPiggyBank.addActionListener(Listener);
        add(clearPiggyBank);
        
        sortPiggyBank = new JButton("Sort PiggyBank");
        sortPiggyBank.setPreferredSize(new Dimension(FRAME_WIDTH/3, 20));
        sortPiggyBank.addActionListener(Listener);
        add(sortPiggyBank);
        
 
       PiggyBankContentArea = new JTextArea();
       Font font = new Font("courier", Font.PLAIN, 14);
       PiggyBankContentArea.setFont(font);
       PiggyBankContentArea.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT - 80));
       //arrayDisplayArea.setBackground(Color.RED);
       add(PiggyBankContentArea);
       setPreferredSize(new Dimension(FRAME_WIDTH + 20, FRAME_HEIGHT + 20));
        
        
    }

     /**
     * Private Listener Class.
     */
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
    if (event.getSource() == nextCoin)
    {
        myCoin = new Coin();
        nextCoinField.setText(myCoin.getName());
    }        
    if (event.getSource() == addCoin)
    {      //add the Coin and get a "status report, fights etc.
        PiggyBankContentArea.setText(myPiggyBank.addMoney(myCoin));
           //clear the current Coin object
        myCoin = new Coin();
        nextCoinField.setText(myCoin.getName());
    }

    if (event.getSource() == removeCoin)
    {   //clear the field and show just the cage contents
        PiggyBankContentArea.setText(myPiggyBank.removeMoney(myCoin));
    }
    
    if (event.getSource() == sortPiggyBank)
    {
        PiggyBankContentArea.setText(myPiggyBank.sortMoney());
    }
    
    if (event.getSource() == clearPiggyBank)
    {   //clear displays and reset all objects and static counters
        PiggyBankContentArea.setText(" ");
        myPiggyBank = new PiggyBank();
        myCoin = new Coin();
        nextCoinField.setText(myCoin.getName());
    }
    }//end of listener method
}
}
