/**
 * Ryan Bookram
 * Software Development 1 (14877)
 * September 13, 2025
 * Patron.java
 * This class is the basis for the LMS.java class. This patron class stores information that the LMS would need about patrons.
 */

public class Patron {

    private int idNum = -1;
    private String name = "Unassigned";
    private String address = "Unassigned";
    private double finesDue = 0.0;

    public Patron(int ID, String name, String address, double finesDue) {
        String tempValue = String.format("%.2f", finesDue);

        this.idNum = ID;
        this.name = name;
        this.address = address;
        this.finesDue = Double.parseDouble(tempValue);
    }

    public void setID(int idNum) {
        this.idNum = idNum;
    }

    public int getID() {
        return idNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setFinesDue(double finesDue) {
        String tempValue = String.format("%.2f", finesDue);
        this.finesDue = Double.parseDouble(tempValue);
    }

    public double getFinesDue() {
        return finesDue;
    }

    @Override
    public String toString() {
        return "ID: " + idNum + ", Name: " + name + ", Address: " + address + ", Fines: " + finesDue;
    }
}
