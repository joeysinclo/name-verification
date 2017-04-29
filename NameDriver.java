/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nameexercise3;

/**
 *
 * @author jordan
 */
public class NameDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        NameCreator name = new NameCreator();
        name.getFirstName();
        name.getMiddleName();
        name.getLastName();
        name.callNameConfirmation();
    }
}
