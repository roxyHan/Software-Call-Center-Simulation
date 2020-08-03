# Software-Call-Center-Simulation
 Program that shows the use of Queues and ArrayList to manage a Call Center

# Scenario
Sophocles Software is launching soon, and is building a customer support call center. They want you to
build them a simulation that shows how call and support tech queueing will work. While you have a grand
plan for a fancy simulation, this project will encompass only the first steps toward that goal. <br/>

Create a mocked customer list of 1,000 customers1
, including customer number, first name, last name,
email address, and phone number. Store this data in a simple text file, in a format of your choosing.<br/>

Create a mocked tech list of 50 support techs, including id number, first name, last name, user name, and
schedule. Assume techs have one day off during the week; come up with a good way record schedules
with this understanding.<br/>

When the program runs, ask the user for simulation data including how many customers to put in the
initial queue (e.g., 20). Also ask them the call interval to use (e.g., 1.5 seconds), and how many
calls/iterations to simulate (e.g., 30) before terminating the simulation. These interactions should be
bulletproofed, i.e., it should do data type and range checking and re-prompt as necessary.<br/>

Then read in the customers and techs into respective ArrayLists (yours, not Java’s). Pick the specified
number of random customers and put them into a queue; this simulates calls waiting when the call center
opens). Pick a random tech schedule (simulating a random day of the week), and add all techs working
that schedule to a queue.<br/>

At the specified timer interval, pair the next queued customer with the next queued tech. Show that
pairing as output on the console. Then put a random customer into the queue (simulating an incoming
call), and put the tech back into the tech queue.<br/>

Continue the simulation until the specified number of iterations is reached. At that point, tell the user
that the simulation has ended.