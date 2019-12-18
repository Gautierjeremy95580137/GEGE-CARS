package IHM;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rents  {


    private  String Firstname;
    private  String Lastname;
    private  String reference;
    private String Day_of_rent;
    private String Day_rental_return;
    static ArrayList<Rents> listrents = new ArrayList<>();

    public void Rent(){
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.reference = reference;
        this.Day_of_rent = Day_of_rent;
        this.Day_rental_return = Day_rental_return;
    }

    public void setFirstname(String fn) {
        Firstname = fn;
    }

    public void setLastname(String ln) {
        Lastname = ln;
    }

    public void setReference(String ref) {
        reference = ref;
    }
    public void setDay_of_rent(String dor) {
        Day_of_rent = dor;
    }
    public void setDay_rental_return(String drr) {
        Day_rental_return = drr;
    }

    public String getFirstname() {
        return (Firstname);
    }

    public String getLastname() {
        return (Lastname);
    }

    public String getReference() {
        return (reference);
    }

    public String getDay_of_rent() {
        return (Day_of_rent);
    }

    public String getDay_rental_return() {
        return (Day_rental_return);
    }



    public static void rentcar(String fn, String ln, String ref){

        Rents xx = new Rents();
        xx.setFirstname(fn);
        xx.setLastname(ln);
        xx.setReference(ref);
        listrents.add(xx);

    }
    public static void returncar( String ref) {
        Rents xx = new Rents();
        System.out.println("return car");
        String target = ref.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < listrents.size(); i++) {
            xx = listrents.get(i);
            String record = xx.getReference().toUpperCase();
            if (record.equals(target)) {
                System.out.println("rental found !");
                //test si loc en cour
                listrents.remove(i);
                System.out.println("car is successfully deleted ! ");
                gotit = 1;
            }

        }
    }


}
