/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nameexercise3;

import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author jordan
 */
public class NameCreator 
{
    private String firstName, middleName, lastName, fullName;
    private Panel panel;
    private JLabel messageLabel;
    private JRadioButton namePreference1;
    private JRadioButton namePreference2;
    private JRadioButton namePreference3;


    public void Name(String fn, String mn, String ln, String fullname)
    {
        firstName = fn;
        middleName = mn;
        lastName = ln;
        this.fullName = fullname;
    }
    
    public String getFirstName()
    {
        firstName = JOptionPane.showInputDialog(null, "Please enter your first name: ", "First Name", JOptionPane.PLAIN_MESSAGE);
        
        while(firstName.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Cannot leave this blank.  Please enter your first name.", "Invalid Response!", JOptionPane.ERROR_MESSAGE);
            getFirstName();
        }
        return firstName;
    }
    
    public void setFirstName(String fn)
    {
        firstName = fn;
    }
    
    private void callMiddleName()
    {
        getMiddleName();
    }
    public String getMiddleName()
    {
        int input;
        input = JOptionPane.showConfirmDialog(null, "Do you have a middle name?", "Middle Name?", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0)
        {
            middleName = JOptionPane.showInputDialog(null, "Please enter your middle name: ", "Middle Name", JOptionPane.PLAIN_MESSAGE);
            if (middleName.equals(""))
            {
                input = JOptionPane.showConfirmDialog(null, "Middle name is blank. \nIs this correct?", "No middle name?", YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(input == 0)
                {
                   noMiddleNameConfirmed();
                }
                
                else if(input == 1)
                {
                   callMiddleName(); 
                }
            }
        }
        else if (input == 1)
        {
            middleName = ("");        
        }
                
        return middleName;
    }
    
    public void setMiddleName(String mn)
    {
        middleName = mn;
    }
    
    private void noMiddleNameConfirmed()
    {
        /**
         * Purposely left blank, so main class NameDriver can go straight to last 
         * name method.
        **/
    }
    public String getLastName()
    {
        lastName = JOptionPane.showInputDialog(null, "Please enter your last name:", "Last Name", JOptionPane.PLAIN_MESSAGE);
        while(lastName.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Cannot leave this blank.  Please enter your last name.", "Invalid Response!", JOptionPane.ERROR_MESSAGE);
            getLastName();
        }    
        return lastName;
    }
    
    public void setLastName(String ln)
    {
        lastName = ln;
    }
    
    public void callNameConfirmation()
    {
        NameConfirmation(middleName);
    }        
            
    public String NameConfirmation(String mn)
    {
        NameCreator confirm = new NameCreator();
        if (mn.equals(""))
        {
            fullName = firstName.toUpperCase().charAt(0) + firstName.toLowerCase().substring(1) + 
                    " " + 
                    lastName.toUpperCase().charAt(0) + lastName.toLowerCase().substring(1);
            
            int input = JOptionPane.showConfirmDialog(null, "Is your name " + fullName + "?", "Correct Name?", YES_NO_OPTION);
            if (input == 0)
            {
                JOptionPane.showMessageDialog(null, "Thank you, " + fullName + "! " +
                        "We will save your name in our database!", "Confirmed!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if(input == 1)
            {
                JOptionPane.showMessageDialog(null, "Please re-enter your name.", "Re-enter name", JOptionPane.OK_OPTION);
                getFirstName();
                getMiddleName();
                getLastName();
                callNameConfirmation();
            }
            return fullName;
            
        }
        
        else 
        {
            fullName = firstName.toUpperCase().charAt(0) + firstName.toLowerCase().substring(1) + " " + 
                    middleName.toUpperCase().charAt(0) + middleName.toLowerCase().substring(1) + " " + 
                    lastName.toUpperCase().charAt(0) + lastName.toLowerCase().substring(1);

            int input = JOptionPane.showConfirmDialog(null, "Is your name " + fullName + "?", "Correct Name?", YES_NO_OPTION);
            if (input == 0)
            {
                JOptionPane.showMessageDialog(null, "Thank you, " + fullName + "! " +
                        "We will save your name in our database!");
            }
            else if (input == 1)
            {
                JOptionPane.showMessageDialog(null, "Please re-enter your name" ,"Re-enter name", JOptionPane.OK_OPTION);
                getFirstName();
                getMiddleName();
                getLastName();
                callNameConfirmation();
            }
            return fullName;
        }
    }
    
    public void setNameConfirmation(String fullname)
    {
        this.fullName = fullname;
    }
}
