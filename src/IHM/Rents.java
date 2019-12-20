package IHM;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Rents  {


    /**
     * create variables
     */

    private  String Firstname;
    private  String Lastname;
    private  String reference;
    private String Day_of_rent;
    private String Day_rental_return;


    /**
     * create ArrayList of rents objects
     */

    static ArrayList<Rents> listrents = new ArrayList<>();


    /**
     * Rents class constructor
     */

    public void Rent(){
            this.Firstname = Firstname;
            this.Lastname = Lastname;
            this.reference = reference;
            this.Day_of_rent = Day_of_rent;
            this.Day_rental_return = Day_rental_return;
        }

    /**
     * methods for set and get Rents variables
      * @param fn
     */

    public void setFirstname(String fn) {
        Firstname = fn;
    }

    public void setLastname(String ln) {
        Lastname = ln;
    }

    public void setReference(String ref) {
        reference = ref;
    }

    public void setDay_of_rent(String dr) {
        Day_of_rent = dr;
    }

    public void setDay_rental_return(String dor) { Day_rental_return = dor; }

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


    /**
     * methods for rent a car
     * @param fn
     * @param ln
     * @param ref
     * @param dr
     * @param dor
     */

    public static void rentcar(String fn, String ln, String ref, String dr, String dor){

        Rents xx = new Rents();
        int ty = Users.searchUser(fn,ln);
        int to = Cars.searchref(ref);
        if (ty == 1 && to == 1) {
            xx.setFirstname(fn);
            xx.setLastname(ln);
            xx.setReference(ref);
            xx.setDay_of_rent(dr);
            xx.setDay_rental_return(dor);
            listrents.add(xx);
        }else {
            System.out.println(" user or reference doesn't exist !");
            System.out.println("please add a new user first or a new car !");
        }

    }


    /**
     * methods for return rental
     * @param ref
     */


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
                System.out.println("car is successfully return ! ");
                gotit = 1;
            }

        }
    }


    /**
     * methods for display the list of rents
     */


    public static void listrent(){
        Rents xx = new Rents();
        System.out.println("You have " + String.valueOf(listrents.size())+ "rents");
        System.out.println("List of all rents ");
        for (int i = 0; i < listrents.size();i++) {
            xx = listrents.get(i);
            System.out.println(xx.getFirstname()+ " "+ xx.getLastname()+ " "+ xx.getReference()+ " "+ xx.getDay_of_rent()+ " "+ xx.getDay_rental_return());
        }

    }


    /**
     * method for search a user with a current rents
     * @param Fn
     * @param Ln
     * @return
     */

    public  static int searchrentuser(String Fn, String Ln) {
        String target = Fn.toUpperCase() + Ln.toUpperCase();
        int gotit = 0;
        Rents xx= new Rents();
        for (int i = 0; i < listrents.size(); i++) {
            xx = listrents.get(i);
            String record = xx.getFirstname().toUpperCase() + xx.getLastname().toUpperCase();
            // ************ Test if user already exist
            if (record.equals(target)) {
                System.out.println("warning : User already exist !");
                gotit = 0;
            } else {
                gotit = 1;
            }
        }
        return(gotit);
    }


    /**
     * method for save the list of rents in a file
     */

    public static void saverents(){
        Rents xx = new Rents();
        System.out.println("save rents");
        String outtext;
        try {
            File rentfile = new File("rents.csv");
            FileWriter out = new FileWriter(rentfile);
            for (int i = 0; i < listrents.size();i++) {
                xx = listrents.get(i);
                String newline = System.getProperty("line.separator");
                outtext = xx.getFirstname()+ ";"+ xx.getFirstname()+ ";"+ xx.getLastname()+ ";"+ xx.getReference()+ ";"+ xx.getDay_of_rent()+ ";"+ xx.getDay_rental_return()+ newline;
                out.write(outtext);
            }
            out.close();
            System.out.println("rents data saved in rents.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    /**
     * method for load a file with a list of rents
     */

    public static void loadrents() {
        Rents xx = new Rents();
        System.out.println("Load rents");
        listrents.clear();
        try {
            File fileload = new File("rents.csv");
            BufferedReader in = new BufferedReader(new FileReader(fileload));
            String st;
            while((st = in.readLine()) != null) {
                String[] strs = st.split("[,//;]");
                rentcar(strs[0], strs[1], strs[2],strs[3], strs[4]);
            }
            in.close();
            System.out.println("rents data restored from rents.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }


    }
}
