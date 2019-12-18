package IHM;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class Users implements java.io.Serializable {



    private String Firstname;
    private String Lastname;
    private String country;
    private int departement;
    private int age;
    public static ArrayList<Users> listofUsers = new ArrayList();



    public void Users(){
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.country = country;
        this.departement = departement;
        this.age = age;
    }

    public void SetFirstname(String fn) {
        Firstname = fn;
    }

    public void SetLastname(String ln) {
        Lastname = ln;
    }

    public void SetCountry(String ln) {
        country = ln;
    }

    public void SetDepartement(int ln) {
        departement = ln;
    }

    public void SetAge(int ln) {
        age = ln;
    }

    public String getFullname() {
        String a = Firstname+ "" + Lastname;
        return (a);
    }

    public String getLastname() {
        return (Lastname);
    }

    public String getFirstname() {
        return (Firstname);
    }

    public String getCountry() {
        return (country);
    }

    public int getDepartement() {
        return (departement);
    }

    public int getAge() {
        return (age);
    }

    public static void adduser(String fn, String ln, String c, int dep, int a) {



        Users xx = new Users();
        xx.SetFirstname(fn);
        xx.SetLastname(ln);
        xx.SetCountry(c);
        xx.SetDepartement(dep);
        xx.SetAge(a);
        listofUsers.add(xx);
    }
    public static void adduser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add a new user");
        System.out.println("Firstname ?");
        String fn = sc.nextLine();
        System.out.println("Lastname ? ");
        String ln = sc.nextLine();
        System.out.println("country ?");
        String cy = sc.nextLine();
        int a;
        int dep;
        do {
            System.out.println("departement ? (between 1 and 95");
            a = Integer.valueOf(sc.nextLine());
             dep = a;
        } while (a > 95 || a < 1);
        do {
            System.out.println("age ? (must be between 18 years and 110 years");
            a = Integer.valueOf(sc.nextLine());
        } while (a > 110 || a < 18);
        Users xx = new Users();
        xx.SetFirstname(fn);
        xx.SetLastname(ln);
        xx.SetCountry(cy);
        xx.SetDepartement(dep);
        xx.SetAge(a);
        listofUsers.add(xx);
        System.out.println("a new user is created");
    }

       public static void userlist() {
            Users xx = new Users();
            System.out.println("You have " + String.valueOf(listofUsers.size())+ "users");
            System.out.println("List of all users ");
            for (int i = 0; i < listofUsers.size();i++) {
                xx = listofUsers.get(i);
                System.out.println(xx.getFirstname()+ " "+ xx.getLastname()+ " "+ xx.getCountry()+ " "+ xx.getDepartement()+ " "+ xx.getAge());
            }
        }

        public static void removeuser(String fn, String ln) {
            Users xx = new Users();
            System.out.println("remove user");
            String target = fn.toUpperCase()+ln.toUpperCase();
            int gotit = 0;
            for (int i = 0; i<listofUsers.size();i++) {
                xx = listofUsers.get(i);
                String record = xx.getFirstname().toUpperCase() + xx.getLastname().toUpperCase();
                if(record.equals(target)) {
                    System.out.println("user found !");
                    //test si loc en cour
                    listofUsers.remove(i);
                    System.out.println("user successfully deleted ! ");
                    gotit = 1;
                }
            }

        }






    public static void edituser(String fn, String ln) {

        Scanner sc = new Scanner(System.in);
        Users xx = new Users();
            System.out.println("edit user");
        String target = fn.toUpperCase() + ln.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < listofUsers.size(); i++) {

            xx = listofUsers.get(i);
            String record = xx.getFirstname().toUpperCase() + xx.getLastname().toUpperCase();
            if (record.equals(target)) {
                System.out.println(" User found !");
                System.out.println(" Firstname: " + xx.getFirstname());
                fn = sc.nextLine();
                if(!fn.equals("")) { xx.SetFirstname(fn);}
                System.out.println("Lastname: " + xx.getLastname());
                ln = sc.nextLine();
                if (!ln.equals("")) { xx.SetLastname(ln); }
                System.out.println("Country: " + xx.getCountry());
                String cy;
                cy = sc.nextLine();
                if (!cy.equals("")) { xx.SetCountry(cy); }
                System.out.println(" Departement: " + String.valueOf(xx.getDepartement()));
                String dept;
                dept = sc.nextLine();
                if (!dept.equals("")) { xx.SetDepartement(Integer.valueOf(dept));}
                System.out.println("Age: "+ String.valueOf(xx.getAge()));
                String a;
                a = sc.nextLine();
                if (!a.equals("")) {xx.SetAge(Integer.valueOf(a));}
                System.out.println("User's information successfully updated ");
                String dept1 = String.valueOf(xx.getDepartement());
                String ab = String.valueOf(xx.getAge());
                System.out.println("Firstname: "+ xx.getFirstname()+ ",Lastname:"+ xx.getLastname()+ ", Country:"+ xx.getCountry()+ ", Departement:"+ dept1 + ", Age:"+ ab);
                gotit = 1;

            }
        }
        if (gotit == 0) {
            System.out.println("user not found !");
        }


    }

    }

