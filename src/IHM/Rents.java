package IHM;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rents extends Cars {

    static ArrayList<String> firstname = new ArrayList<String>();
    static ArrayList<String> lastname = new ArrayList<String>();
    static ArrayList<String> reference = new ArrayList<String>();
    static ArrayList<String> day_of_rent = new ArrayList<String>();
    static ArrayList<String> day_rental_return = new ArrayList<String>();
    static ArrayList<String> currentrental = new ArrayList<String>();



    public static void rentcar(){
        System.out.println("Add a new rent");
        Scanner sc = new Scanner(System.in);
        System.out.println("Firstname: ");
        firstname.add(sc.nextLine());
        System.out.println("Lastname: ");
        lastname.add(sc.nextLine());
        System.out.println("Reference: ");
        reference.add(sc.nextLine());
        System.out.println("Day of rent: ");
        day_of_rent.add(sc.nextLine());
        System.out.println("Day of rental return: ");
        day_rental_return.add(sc.nextLine());
        System.out.println("New rent added");
    }
    public static void returncar(){
        System.out.println("Return car, please enter the reference of car");
        Scanner sc = new Scanner(System.in);
            for(int i=0;i <ref.size();i ++) {
                String rec = ref.get(i).toUpperCase();
                if(rec.equals(sc.nextLine())) {
                    System.out.println("Rental founded !");
                    System.out.println("Enter the new day of rental return: " );
                    day_rental_return.set(i,sc.nextLine());
                    System.out.println("Firstname: " + firstname.get(i)+ "Lastname: "+ lastname.get(i)+ "Reference: "+ reference.get(i)+ "Day of rent: " + day_of_rent.get(i)+ ", Day of rental renturn: "+ day_rental_return.get(i));

                } else {
                    System.out.println("Error, this reference not exist");
                    returncar();

                }
            }

    }


}
