
/**
 * Write a description of class SupportTech here.
 *
 * @author Hanifa Barry
 * @version 2017-06-12
 */
public class SupportTech{
    
    //---------------------------------------------
    //          Instance variables
    //---------------------------------------------
    
    private int         id;
    private String      firstName;
    private String      lastName;
    private String      userName;
    private int         dayOff;
    
    //---------------------------------------------
    //          Constructor
    //---------------------------------------------
    
    /**
     * Creates a support technician with all references
     * 
     * @param   id          the technician ID
     * @param   firstName   the technician first name
     * @param   lastName    the technician last name
     * @param   userName    the technician username
     * @param   schedule    the technician schedule
     */
    public SupportTech(int id, String firstName, String lastName,
                       String userName, int dayOff) {
        this.id         = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.userName   = userName;
        this.dayOff     = dayOff;
    }
    
    //---------------------------------------------
    //          Accessors
    //---------------------------------------------
    
    /**
     * Gets the id of the technician
     * 
     * @return  the id of the technician
     */
    public int getID() {
        return this.id;
    }
    
    /**
     * Gets the technician first name
     * 
     * @return  the technician first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the technician last name
     * 
     * @return  the technician last name
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Gets the technician username
     * 
     * @return  the technician username
     */
    public String getUserName() {
        return this.userName;
    }
    
    /**
     * Gets the technician schedule
     * 
     * @return  the technician schedule
     */
    public int getDayOff() {
        return this.dayOff ;
    }
    
    /**
     * Text description of a support technician
     * 
     * @return   a text description of a support technician
     */
    public String toString() {
        String descrip = "Technician ID:" + this.id   + "\n";
        descrip += "First name: "    + this.firstName + "\n";
        descrip += "Last name: "     + this.lastName  + "\n";
        descrip += "Username: "      + this.userName  + "\n";
        descrip += "Day Off: "       + this.dayOff  + "\n\n";
        return descrip;  
    }
}
