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

        //int tt = searchUser(fn,ln);
        //if (tt == 0) {
            Users xx = new Users();
            xx.SetFirstname(fn);
            xx.SetLastname(ln);
            xx.SetCountry(c);
            xx.SetDepartement(dep);
            xx.SetAge(a);
            listofUsers.add(xx);
        //} else {
           // System.out.println("error, user already exist");
        //}
    }


       public static void userlist() {
            Users xx = new Users();
            System.out.println("You have " + String.valueOf(listofUsers.size())+ " users");
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
            int rs= Rents.searchrentuser(fn,ln);
            if (rs == 1) {
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
                int tt = searchUser(fn,ln);
                //if (tt == 0) {
                   // String record = xx.getFirstname().toUpperCase() + xx.getLastname().toUpperCase();
                    //xx.SetFirstname(fn);
                  // xx.SetLastname(ln);
               // }
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

    public static void saveusers(){
        Users xx = new Users();
        System.out.println("save users");
        String outtext;
        try {
            File userfile = new File("users.csv");
            FileWriter out = new FileWriter(userfile);
            for (int i = 0; i < listofUsers.size();i++) {
                xx = listofUsers.get(i);
                String newline = System.getProperty("line.separator");
                outtext = xx.getFirstname()+ ";"+ xx.getLastname()+ ";"+ xx.getCountry()+ ";"+ xx.getDepartement()+ ";"+ xx.getAge()+ newline;
                out.write(outtext);
            }
            out.close();
            System.out.println("users data saved in users.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadusers() {
        Users xx = new Users();
        System.out.println("Load users");
        listofUsers.clear();
        try {
            File fileload = new File("users.csv");
            BufferedReader in = new BufferedReader(new FileReader(fileload));
            String st;
            while((st = in.readLine()) != null) {
                String[] strs = st.split("[,//;]");
                adduser(strs[0],strs[1],strs[2],Integer.parseInt(strs[3]),Integer.parseInt(strs[4]));
            }
            in.close();
            System.out.println("users data restored from users.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    public static void serialUsers() {
        Users xx = new Users();
        System.out.println("serialize users objects");
        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (int i = 0; i < listofUsers.size(); i++) {
                xx = listofUsers.get(i);
                out.writeObject(xx);
            }
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in users.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public  static int searchUser(String Fn, String Ln) {
        String target = Fn.toUpperCase() + Ln.toUpperCase();
        int gotit = 0;
        Users xx= new Users();
        for (int i = 0; i < listofUsers.size(); i++) {
            xx = listofUsers.get(i);
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


    }

