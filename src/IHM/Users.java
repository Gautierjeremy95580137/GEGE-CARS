package IHM;

import java.util.ArrayList;
import java.util.Scanner;

public class Users {

    static ArrayList<String> firstname = new ArrayList<String>();
    static ArrayList<String> lastname = new ArrayList<String>();
    static ArrayList<String> country = new ArrayList<String>();
    static ArrayList<Integer> departement = new ArrayList<Integer>();
    static ArrayList<Integer> age = new ArrayList<Integer>();

    public static void  adduserCommand() {

        System.out.println("Add a new user");
        Scanner sc = new Scanner(System.in);
        System.out.println("Firstname ? ");
        firstname.add(sc.nextLine());
        System.out.println("Lastname ? ");
        lastname.add(sc.nextLine());
        System.out.println("Country ? ");
        country.add(sc.nextLine());
        int a;
        do {
            System.out.println("departement ? (between 1 and 95");
            a = Integer.valueOf(sc.nextLine());
        } while (a > 95 || a < 1);
        departement.add(a);
        do {
            System.out.println("age ? (must be between 18 years and 110 years");
            a = Integer.valueOf(sc.nextLine());
        }while (a > 110 || a < 18);
        age.add(a);
        System.out.println(" New user is recorded ! ");

        }

    public  static  void listusers() {

        System.out.println(" We have " + String.valueOf(firstname.size())+ "users ! ");
        System.out.println(" List of all users ");
        for (int i = 0 ; i < firstname.size(); i++) {
            String dept = String.valueOf(departement.get(i));
            String ab = String.valueOf(age.get(i));
            System.out.println("Firstname: " + firstname.get(i)+ ", Lastname: " + lastname.get(i)+ ", Country: " + country.get(i)+ ", Department: " + dept + ", Age: " + ab);
        }


    }

    public static void edituser() {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Search for a user ");
        System.out.println(" Firstname ? ");
        String fn = sc.nextLine();
        System.out.println(" Lastname ? ");
        String ln = sc.nextLine();
        String target = fn.toUpperCase() + ln.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < firstname.size(); i++) {
            String record = firstname.get(i).toUpperCase() + lastname.get(i).toUpperCase();
            if (record.equals(target)) {
                System.out.println(" User found !");
                System.out.println(" Firstname: " + firstname.get(i));
                fn = sc.nextLine();
                if(!fn.equals("")) { firstname.set(i,fn);}
                System.out.println("Lastname: " + lastname.get(i));
                fn = sc.nextLine();
                if (!fn.equals("")) { lastname.set(i,fn); }
                System.out.println("Country: " + country.get(i));
                fn = sc.nextLine();
                if (!fn.equals("")) { country.set(i,fn); }
                System.out.println(" Departement: " + departement.get(i));
                fn = sc.nextLine();
                if (!fn.equals("")) { departement.set(i,Integer.valueOf(fn));}
                System.out.println("Age: "+ age.get(i));
                fn = sc.nextLine();
                if (!fn.equals("")) { age.set(i,Integer.valueOf(fn));}
                System.out.println("User's information successfully updated ");
                String dept = String.valueOf(departement.get(i));
                String ab = String.valueOf(age.get(i));
                System.out.println("Firstname: "+ firstname.get(i)+ ",Lastname:"+ lastname.get(i)+ ", Country:"+ country.get(i)+ ", Departement:"+ dept + ", Age:"+ ab);
                gotit = 1;

            }
        }
        if (gotit == 0) {
            System.out.println("user not found !");
        }


    }
        public static void removeuser() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Remove user");
            System.out.println("Firstname ? ");
            String fn = sc.nextLine();
            System.out.println("Lastname ?");
            String ln = sc.nextLine();
            String target = fn.toUpperCase() + ln.toUpperCase();
            int gotit = 0;
            for (int i = 0 ; i < firstname.size(); i++) {
                String record = firstname.get(i).toUpperCase()+lastname.get(i).toUpperCase();
                if (record.equals(target)) {
                    System.out.println("User found ! ");
                    //mettre la condition de location apres
                    firstname.remove(i);
                    lastname.remove(i);
                    country.remove(i);
                    departement.remove(i);
                    age.remove(i);
                    System.out.println("User successfully deleted ! ");
                    String dept = String.valueOf(departement.get(i));
                    String ab = String.valueOf(age.get(i));
                    System.out.println("Firstname: "+firstname.get(i)+ ", Lastname: "+lastname.get(i)+ ", Country: "+country.get(i)+", Departement: "+ dept + ", Age:"+ ab);
                    gotit = 1;
                }
            }
            if (gotit == 0) {
                System.out.println("User not found ! ");
            }
        }
    }

