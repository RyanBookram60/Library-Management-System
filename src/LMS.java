/**
 * Ryan Bookram
 * Software Development 1 (14877)
 * September 13, 2025
 * LMS.java
 * This class serves as a Library Managment System, allowing users to input/store patrons and their information.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LMS {

    public static ArrayList<Patron> patronList = new ArrayList<Patron>();

    /**
     * Method: Main
     * Return: None
     * Purpose: Create a menu system for users to interact with the LMS.
     */
    public static void main(String[] args) {

        boolean exit = false;
        Scanner scnr = new Scanner(System.in);
        String userInput = "";

        System.out.println("Welcome to the LMS system! Available commands for use include:");
        System.out.println("add - Adds a patron to the list based on the format: ID-Name-Address-Fines");
        System.out.println("addtext - Adds multiple patrons from a text file using a file path input");
        System.out.println("remove - Removes a patron using their unique 7 digit ID number");
        System.out.println("print - Prints the current list of patrons");
        System.out.println("exit - Exits the system");

        while (!exit) {

            userInput = scnr.nextLine();

            if(userInput.equals("add")){

                    System.out.println("\nEnter the patron you would like to add. Format: ID-Name-Address-Fines\nEx. 4930275-John Smith-Hollow Dr-34.55:");

                    userInput = scnr.nextLine();

                    addPatron(userInput);
                }
                else if(userInput.equals("addtext")){

                    System.out.println("\nEnter the file path of the text file you would like to input.\nEx. \"C:\\Users\\Username\\Documents\\File.txt\"");
                    System.out.println("\nThe text file should have a single entry on each line.\nEx.\n4930275-John Smith-Hollow Dr-34.55\n3927507-Amber Jones-Angel Street-10.15");

                    userInput = scnr.nextLine();

                    addFromFile(userInput);
                }
                else if(userInput.equals("remove")) {

                    System.out.println("\nEnter the 7 digit ID of the patron you want to remove:");

                    userInput = scnr.nextLine();

                    try {
                        removePatron(Integer.parseInt(userInput));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Enter a 7 digit number.");
                    }
                }
                else if(userInput.equals("print")) {

                    System.out.println("\nCurrent Patrons In System:");
                    printPatrons();
                }
                else if(userInput.equals("exit")) {

                    System.out.println("Exiting system...");
                    exit = true;
            }
                else {
                    System.out.println("Invalid input! Commands include: add, addText, remove, print");
            }
        }
        scnr.close();
    }

    /**
     * Method: addPatron
     * Parameters: info
     * Return: None
     * Purpose: Add a patron to the LMS.
     */
    public static void addPatron(String info) {

        int ID;
        String name;
        String address;
        double finesDue;
        String[] splitInfo  = info.split("-");

        if(splitInfo.length != 4){
            System.out.println("Incorrect format! Use: ID-Name-Address-Fines. Make sure to leave no spaces and only separate attributes by a dash.");
        }
        else {

            ID = Integer.parseInt(splitInfo[0]);
            name = splitInfo[1];
            address = splitInfo[2];
            finesDue = Double.parseDouble(splitInfo[3]);

            patronList.add(new Patron(ID, name, address, finesDue));

            System.out.println("Patron added!");
        }
    }

    /**
     * Method: addFromFile
     * Parameters: fileName
     * Return: None
     * Purpose: Add multiple patrons to the LMS from a text file.
     */
    public static void addFromFile(String fileName) {

        File inputFile = null;
        BufferedReader br = null;
        String patron;

        try {

            inputFile = new File(fileName);
            br = new BufferedReader(new FileReader(inputFile));

            while((patron = br.readLine()) != null) {
                addPatron(patron);
            }

            System.out.println("Patrons added successfully!");
        }
        catch(Exception e){
            System.out.println("An error has occurred. Please ensure your file path is correct and your text file is formatted correctly.");
        }
    }

    /**
     * Method: removePatron
     * Parameters: ID
     * Return: None
     * Purpose: Remove a patron from the LMS using a unique ID.
     */
    public static void removePatron(int ID) {

        for(int i = 0; i < patronList.size(); i++){

            if(patronList.get(i).getID() == ID){

                patronList.remove(i);
                System.out.println("Patron removed!");
            }
        }
    }

    /**
     * Method: printPatrons
     * Parameters: None
     * Return: None
     * Purpose: Print all the current patrons in the LMS.
     */
    public static void printPatrons() {

        for(Patron patron : patronList){
            System.out.println(patron.toString());
        }
    }
}
