
/**
 * Write a description of class Customer here.
 *
 * @author Hanifa Barry
 * @version 2017-06-12
 */
public class Customer {

    //---------------------------------------------
    //          Instance variables
    //---------------------------------------------

    private int     number;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String     phoneNum;

    /**
     * Creates a customer with all references
     * 
     * @param   number      the customer number
     * @param   firstName   the customer first name
     * @param   lastName    the customer last name
     * @param   email       the customer email address
     * @param   phoneNum    the customer phone number
     */
    public Customer(int number, String firstName, String lastName,
                    String email, String phoneNum) {
        this.number     = number;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.phoneNum   = phoneNum;
    }

    /**
     * Gets the customer number
     * 
     * @return  the customer number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Gets the customer first name
     * 
     * @return  the customer first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the customer last name
     * 
     * @return  the customer last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the customer email address
     * 
     * @return  the customer email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the customer phone number
     * 
     * @return  the customer phone number
     */
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    /**
     * Text description of a customer
     * 
     * @return   a text description of a customer
     */
    public String toString() {
        String descrip = "Customer #" + this.number + " :\n";
        descrip += "---------------------------------------\n";
        descrip += "First name: "    + this.firstName + "\n";
        descrip += "Last name: "     + this.lastName  + "\n";
        descrip += "Email address: " + this.email     + "\n";
        descrip += "Phone number: "  + this.phoneNum  + "\n\n";
        return descrip;  
    }
}
