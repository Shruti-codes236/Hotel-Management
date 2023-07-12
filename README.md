# Hotel-Management
Hotel booking portal for Travellers and Employee management for Hotel Le Lotus Grand. 

This repository contains a Python script that can be used to manage a hotel. The script allows users to create, update, and delete hotel guests, rooms, and reservations.

# Requirements
* The script requires the following dependencies:
  * numpy
  * pandas
  * datetime

# Instructions
To run the script, you will need to install the dependencies and then run the script from the command line. The following command will install the dependencies:

 `pip install numpy pandas datetime`

Once the dependencies are installed, you can run the script by typing the following command into the command line:

 `python hotel_management.py`

The script will take a few command-line arguments, which you can use to specify the hotel's name, the number of rooms, and the number of guests. For example, the following command will create a hotel with the name "The Ritz-Carlton" with 100 rooms and 50 guests:

 `python hotel_management.py The Ritz-Carlton 100 50`

The script will create a file called hotel_data.csv. This file contains the data for the hotel, including the guests, rooms, and reservations.

Example
The following is an example of the output of the script:

 **Guests:**
   ****
    | Name	      | Room Number |
    -----------------------------
    | John        |	 Occupied   |
    | Jane        |	 Available  |

 **Rooms:**
  
    | Room Number| Status   |
    ---------------------------
    | 101         |	 Occupied |
    | 102         |	 Available|
    
 **Reservations:**
 ```
 | Reservation ID |	Guest Name |	Room Number |	Check-in Date |	Check-out Date |
 -----------------------------------------------------------------------------------
 |    1	          | John Smith |	   101	    |  2023-03-01	  | 2023-03-03 |
 |    2	          | Jane Doe	 |     102	    |  2023-03-04	  | 2023-03-06 |
```
