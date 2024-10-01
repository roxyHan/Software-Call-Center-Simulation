---

# Call Center Simulation

## Overview
This project simulates a customer support call center for Sophocles Software. It models the queueing system for customer calls and support technicians.

## Features
- **Mock Customer Data**: Generates a list of 1,000 customers with details (ID, first name, last name, email, phone), stored in a text file.
- **Mock Technician Data**: Creates a list of 50 support technicians with IDs, names, usernames, and schedules (including one day off per week).
  
## User Interaction
Users can specify:
- Number of customers in the initial queue (e.g., 20).
- Call interval (e.g., 1.5 seconds).
- Total iterations for simulation (e.g., 30).

Input is validated for type and range to ensure reliability.

## Simulation Process
1. Load customer and technician data into ArrayLists.
2. Randomly select initial customers for the queue.
3. Identify available technicians based on their schedules.
4. Pair customers with technicians at the specified interval, outputting pairings to the console.
5. Simulate incoming calls and reassign technicians as needed.
6. The simulation runs until the specified iterations are completed, after which a completion message is displayed.

---
