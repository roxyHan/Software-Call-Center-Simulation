import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.io.FileNotFoundException;
import java.io.File;



/**
 * Write a description of class Client here.
 *
 * @author Hanifa Barry
 * @version 2017-06-12
 */
public class Main {

    //------------------------------
    //          Data
    //------------------------------
    
    private static int callCount = 0;
    
    
    // Main function
    public static void main(String[] args) {
        // Gathering information from the user
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of customers to put in "+
                           "the queue: ");
        int initialCustCount = console.nextInt();
        System.out.println("Please specify the Call Interval to use: ");
        double callInterval = console.nextDouble();
        System.out.println("Please specify the number of calls for "+ 
                           "this simulation: ");
        int maxCalls = console.nextInt();

        // Reads in Customers and Support techs from the respective files
        ArrayList<Customer> customers      = readCustomers();
        ArrayList<SupportTech> technicians = readTechnicians();

        // Instantiates both queues
        Queue techQueue = new Queue<SupportTech>();
        Queue custQueue = new Queue<Customer>();

        // Adds random customers to the customers' queue
        for (int index = 0; index < initialCustCount; index++) {
            custQueue.add(customers.get(getRandomInt(0, customers.size())));
        }

        // Adds all tech working on a random day of the week
        int day = getRandomInt(1,7);
        int t = 0;
        for (SupportTech tech : technicians) {
            
            if (tech.getDayOff() != day) {
                t++;
                techQueue.add(tech);
            }
            
        }
        
        Timer callTimer = new Timer();
        System.out.println("Start of Simulation\n"+
                           "--------------------");
        class CallCenter  extends TimerTask {
            public void run() {
                
                SupportTech tech  = (SupportTech) techQueue.peek();
                Customer cust     = (Customer) custQueue.peek();
                
                // Displays the pairing between tech and customer at each
                // time interval
                System.out.println(cust.getFirstName() + " " + cust.getLastName()
                                   + " is currently being helped by " + 
                                   tech.getUserName() +"\n");
                
                // Removes the customer that has just been helped from the
                // customers queue
                custQueue.remove(cust);
                
                // Removes the current tech from the queue 
                techQueue.remove(tech);
                // Puts the same tech back in the tech queue
                techQueue.add(tech);
                
                // Adds a new random customer to the customers' queue
                custQueue.add(customers.get(getRandomInt(0, customers.size())));
                
                callCount++; // Increments the count of calls
                
                if (callCount >= maxCalls) {
                    System.out.println("-----------------\n" +
                                       "End of Simulation");
                    callTimer.cancel();
                }
            }
        }
        callTimer.schedule(new CallCenter(), 0, (int) (callInterval * 1000));
    }

    /**
     * Reads from the customers file to fill the arrayList of customers
     * 
     * @return      arrayList of Customers
     */
    public static ArrayList<Customer> readCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("CustomersData.txt"));
            scan.nextLine();
            
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] pieces = line.split(",");
                int number       = Integer.parseInt(pieces[0]);
                String firstName = pieces[1];
                String lastName  = pieces[2];
                String email     = pieces[3];
                String phoneNum  = pieces[4];
                customers.add(new Customer(number,firstName,lastName,
                        email, phoneNum));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("The file could not be located.");
        }
        return customers;
    }

    /**
     * Reads from the tech file to fill the arrayList of tech
     * 
     * @return      arrayList of tech
     */
    public static ArrayList<SupportTech> readTechnicians() {
        ArrayList<SupportTech> technicians = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("TechniciansData.txt"));
            scan.nextLine();
            
            while(scan.hasNextLine()) {
                String line         = scan.nextLine();
                String[] pieces     = line.split(",");
                int    id           = Integer.parseInt(pieces[0]);
                String firstName    = pieces[1];
                String lastName     = pieces[2];
                String userName     = pieces[3];
                int    dayOff       = Integer.parseInt(pieces[4]);
                
                technicians.add(new SupportTech(id, firstName,lastName,
                                                userName, dayOff));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("The file could not be located.");
        }
        return technicians;
    }

    //-------------------------------
    //          Helper function(s)
    //-------------------------------

    /**
     * Gets a random number in a specific range
     * 
     * @param   min     the lowest value of the number 
     * @param   max     the highest value of the number 
     * 
     * @return   random integer between min and max
     */ 
    public static int getRandomInt(int min, int max){
        return ((int) (Math.random()*(max - min))) + min;
    } 
    
}
