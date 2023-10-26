import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Serializable class representing a food item
class Food implements Serializable {
    int itemno;     // Item number
    int quantity;   // Quantity of the item
    float price;    // Price of the item
    
    // Constructor to initialize the food item details
    Food(int itemno, int quantity) {
        this.itemno = itemno;
        this.quantity = quantity;
        // Calculate the price based on the item number and quantity
        switch (itemno) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;
                break;
        }
    }
}

// Serializable class representing a single room
class Singleroom implements Serializable {
    String name;        // Customer name
    String contact;     // Customer contact number
    String gender;      // Customer gender
    ArrayList<Food> food = new ArrayList<>(); // List of ordered food items

    // Default constructor
    Singleroom() {
        this.name = "";
    }

    // Constructor to initialize single room details
    Singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

// Serializable class representing a double room (inhSerializableerits from Singleroom)
class Doubleroom extends Singleroom   {
    String name2;        // Second customer name
    String contact2;     // Second customer contact number
    String gender2;      // Second customer gender
    
    // Default constructor
    Doubleroom() {
        this.name = "";
        this.name2 = "";
    }

    // Constructor to initialize double room details
    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        super(name,contact,gender);
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

// Custom exception class for indicating unavailability
class NotAvailable extends Exception {
    @Override
    public String toString() {
        return "Not Available!";
    }
}

// Serializable class holding room data arrays
class holder implements Serializable {
    private static final long serialVersionUID = 2453715569550704114L;
    static Doubleroom luxury_doublerrom[] = new Doubleroom[10];     // Array to hold luxury double rooms
    static Doubleroom deluxe_doublerrom[] = new Doubleroom[20];     // Array to hold deluxe double rooms
    static Singleroom luxury_singleerrom[] = new Singleroom[10];    // Array to hold luxury single rooms
    static Singleroom deluxe_singleerrom[] = new Singleroom[20];    // Array to hold deluxe single rooms
}

// Main Hotel class containing various room booking and management methods
class Hotel {
    static holder hotel_ob = new holder();    // Instance of the holder class to hold room data
    static Scanner sc = new Scanner(System.in); // Scanner for user input
    
    
    // Method to input customer details for room booking
    static void CustDetails(int i, int rn) {
        // ...
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";

        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();

        if (i < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:
                holder.luxury_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                holder.deluxe_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                holder.luxury_singleerrom[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                holder.deluxe_singleerrom[rn] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }
    
    // Method to book a room
    static void bookroom(int roomType) {
        try {
        int roomNumber = 0;
        int roomArrayIndex = 0;

        // Display available room numbers for the selected room type
        System.out.println("\nChoose room number from available rooms: ");
        switch (roomType) {
            case 1:
                for (roomNumber = 1; roomNumber <= holder.luxury_doublerrom.length; roomNumber++) {
                    if (holder.luxury_doublerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + ", ");
                    }
                }
                break;
            case 2:
                for (roomNumber = 1; roomNumber <= holder.deluxe_doublerrom.length; roomNumber++) {
                    if (holder.deluxe_doublerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 10 + ", ");
                    }
                }
                break;
            case 3:
                for (roomNumber = 1; roomNumber <= holder.luxury_singleerrom.length; roomNumber++) {
                    if (holder.luxury_singleerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 30 + ", ");
                    }
                }
                break;
            case 4:
                for (roomNumber = 1; roomNumber <= holder.deluxe_singleerrom.length; roomNumber++) {
                    if (holder.deluxe_singleerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 40 + ", ");
                    }
                }
                break;
            default:
                System.out.println("Invalid room type selection.");
                return;
        }   

// Prompt user to enter the selected room number
        System.out.print("\nEnter room number: ");
        roomNumber = sc.nextInt();

        // Validate the selected room number
        //int roomArrayIndex;
        switch (roomType) {
            case 1:
                roomArrayIndex = roomNumber - 1;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.luxury_doublerrom.length ||
                    holder.luxury_doublerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 2:
                roomArrayIndex = roomNumber - 11;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.deluxe_doublerrom.length ||
                    holder.deluxe_doublerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 3:
                roomArrayIndex = roomNumber - 31;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.luxury_singleerrom.length ||
                    holder.luxury_singleerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 4:
                roomArrayIndex = roomNumber - 41;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.deluxe_singleerrom.length ||
                    holder.deluxe_singleerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
    }

        switch (roomType) {
            case 1:
                for (roomNumber = 1; roomNumber <= holder.luxury_doublerrom.length; roomNumber++) {
                    if (holder.luxury_doublerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + ", ");
                    }
                }
                break;
            case 2:
                for (roomNumber = 1; roomNumber <= holder.deluxe_doublerrom.length; roomNumber++) {
                    if (holder.deluxe_doublerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 10 + ", ");
                    }
                }
                break;
            case 3:
                for (roomNumber = 1; roomNumber <= holder.luxury_singleerrom.length; roomNumber++) {
                    if (holder.luxury_singleerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 30 + ", ");
                    }
                }
                break;
            case 4:
                for (roomNumber = 1; roomNumber <= holder.deluxe_singleerrom.length; roomNumber++) {
                    if (holder.deluxe_singleerrom[roomNumber - 1] == null) {
                        System.out.print(roomNumber + 40 + ", ");
                    }
                }
                break;
            default:
                System.out.println("Invalid room type selection.");
                return;
        }

        // Prompt user to enter the selected room number
        System.out.print("\nEnter room number: ");
        roomNumber = sc.nextInt();

        // Validate the selected room number
        switch (roomType) {
            case 1:
                roomArrayIndex = roomNumber - 1;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.luxury_doublerrom.length ||
                    holder.luxury_doublerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 2:
                roomArrayIndex = roomNumber - 11;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.deluxe_doublerrom.length ||
                    holder.deluxe_doublerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 3:
                roomArrayIndex = roomNumber - 31;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.luxury_singleerrom.length ||
                    holder.luxury_singleerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
            case 4:
                roomArrayIndex = roomNumber - 41;
                if (roomArrayIndex < 0 || roomArrayIndex >= holder.deluxe_singleerrom.length ||
                    holder.deluxe_singleerrom[roomArrayIndex] != null) {
                    System.out.println("Invalid room number or room already booked.");
                    return;
                }
                break;
        }

        // Get customer details and store them in the corresponding room object
        CustDetails(roomType, roomArrayIndex);

        // Display success message
        System.out.println("Room Booked.");
    } catch (Exception e) {
        System.out.println("An error occurred while booking the room: " + e.getMessage());
    }
        // ...
    }

    // Method to display room features based on room type
    static void features(int i) {
        // ...
    }

    // Method to check room availability based on room type
    static void availability(int i) {
        // ...
    }

    // Method to generate and display a bill for a room
    static void bill(int rn, int rtype) {
        // ...
    }

    // Method to deallocate (checkout) a room
    static void deallocate(int rn, int rtype) {
        // ...
    }

    // Method to order food for a room
    static void order(int rn, int rtype) {
        // ...
    }
}

// Runnable class to write room data to a file
class write implements Runnable {
    holder hotel_ob;    // Instance of the holder class for data storage

    write(holder hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try {
            // Write the room data to a file
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error in writing " + e);
        }
    }
}

// Main class containing the application entry point
public class CrystalHaven{
    public static void main(String[] args) {
        try {
            // Check if a backup file exists and restore room data if available
            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder) ois.readObject();
                ois.close();
            }

            Scanner sc = new Scanner(System.in); // Scanner for user input
            int ch, ch2; // Menu choice variables
            char wish;   // User wish variable

            x: // Label for the main menu loop
            do {
                // Display the main menu
                System.out.println("\nEnter your choice:\n1. Display room details\n2. Display room availability\n3. Book a room\n4. Order food\n5. Checkout\n6. Exit\n");
                ch = sc.nextInt(); // Read user choice

                // Process user choice
                switch (ch) {
                    case 1:
                        System.out.println("\nChoose room type:\n1. Luxury Double Room\n2. Deluxe Double Room\n3. Luxury Single Room\n4. Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2); // Display room features
                        break;
                    case 2:
                        System.out.println("\nChoose room type:\n1. Luxury Double Room\n2. Deluxe Double Room\n3. Luxury Single Room\n4. Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2); // Check room availability
                        break;
                    case 3:
                        System.out.println("\nChoose room type:\n1. Luxury Double Room\n2. Deluxe Double Room\n3. Luxury Single Room\n4. Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2); // Book a room
                        break;
                    case 4:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        // Order food for the specified room
                        if (ch2 > 60) {
                            System.out.println("Room doesn't exist");
                        } else if (ch2 > 40) {
                            Hotel.order(ch2 - 41, 4);
                        } else if (ch2 > 30) {
                            Hotel.order(ch2 - 31, 3);
                        } else if (ch2 > 10) {
                            Hotel.order(ch2 - 11, 2);
                        } else if (ch2 > 0) {
                            Hotel.order(ch2 - 1, 1);
                        } else {
                            System.out.println("Room doesn't exist");
                        }
                        break;
                    case 5:
                        System.out.print("Room Number - ");
                        ch2 = sc.nextInt();
                        // Deallocate (checkout) the specified room
                        if (ch2 > 60) {
                            System.out.println("Room doesn't exist");
                        } else if (ch2 > 40) {
                            Hotel.deallocate(ch2 - 41, 4);
                        } else if (ch2 > 30) {
                            Hotel.deallocate(ch2 - 31, 3);
                        } else if (ch2 > 10) {
                            Hotel.deallocate(ch2 - 11, 2);
                        } else if (ch2 > 0) {
                            Hotel.deallocate(ch2 - 1, 1);
                        } else {
                            System.out.println("Room doesn't exist");
                        }
                        break;
                    case 6:
                        break x; // Exit the main menu loop

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }

                // Prompt user to continue
                System.out.println("\nContinue? (y/n)");
                wish = sc.next().charAt(0);
                // Validate user input
                if (!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')) {
                    System.out.println("Invalid option. Please enter 'y' or 'n'.");
                    System.out.println("\nContinue? (y/n)");
                    wish = sc.next().charAt(0);
                }

            } while (wish == 'y' || wish == 'Y'); // Continue the main menu loop

            // Create a new thread to write room data to a backup file
            Thread t = new Thread(new write(Hotel.hotel_ob));
            t.start();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
