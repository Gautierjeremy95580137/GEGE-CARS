package IHM;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cars  {


    static ArrayList<Cars> listcars = new ArrayList<>();


    private String Brand;
    private String Model;
    private String reference;
    private int year;


    public void Cars(){
        this.Brand = Brand;
        this.Model = Model;
        this.reference = reference;
        this.year = year;

    }

    public void SetBrand(String br) {
        Brand = br;
    }

    public void SetModel(String mo) {
        Model = mo;
    }

    public void SetRef(String ref) {
        reference = ref;
    }

    public void SetYear(int ye) {
        year = ye;
    }


    public String getBrand() {
        return (Brand);
    }

    public String getModel() {
        return (Model);
    }

    public String getReference() {
        return (reference);
    }

    public int getYear() {
        return (year);
    }


    public static void addcar(String br, String mo, String ref, int ye) {

        Cars xx = new Cars();
        xx.SetBrand(br);
        xx.SetModel(mo);
        xx.SetRef(ref);
        xx.SetYear(ye);
        listcars.add(xx);
    }


    public static void carlist() {
        Cars xx = new Cars();
        System.out.println("You have " + String.valueOf(listcars.size())+ " cars");
        System.out.println("List of all your cars ");
        for (int i = 0; i < listcars.size();i++) {
            xx = listcars.get(i);
            System.out.println(xx.getBrand()+ " "+ xx.getModel()+ " "+ xx.getReference()+ " "+ xx.getYear()+ " ");
        }
    }

    public static void removecar(String ref) {
        Cars xx = new Cars();
        System.out.println("remove car");
        String target = ref.toUpperCase();
        int gotit = 0;
        for (int i = 0; i<listcars.size();i++) {
            xx = listcars.get(i);
            String record = xx.getReference().toUpperCase();
            if(record.equals(target)) {
                System.out.println("car found !");
                //test si loc en cour
                listcars.remove(i);
                System.out.println("car is successfully deleted ! ");
                gotit = 1;
            }
        }

    }


    public static void editcar(String ref) {

        Scanner sc = new Scanner(System.in);
        Cars xx = new Cars();
        System.out.println("edit car");
        String target = ref.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < listcars.size(); i++) {

            xx = listcars.get(i);
            String record = xx.getReference().toUpperCase();
            if (record.equals(target)) {
                System.out.println(" Car found !");
                System.out.println(" reference: " + xx.getReference());
                System.out.println("please select enter to continue or write a new reference");
                ref = sc.nextLine();
                if (!ref.equals("")) {xx.SetRef(ref);}

                System.out.println("Brand: " + xx.getBrand());
                String brand = sc.nextLine();
                if (!brand.equals("")) {xx.SetBrand(brand);}
                String mo;
                System.out.println("Model: " + xx.getModel());
                mo = sc.nextLine();
                if (!mo.equals("")) { xx.SetModel(mo); }

                String ye;
                System.out.println(" Year: " + String.valueOf(xx.getYear()));
                ye = sc.nextLine();
                if (!ye.equals("")) { xx.SetYear(Integer.valueOf(sc.nextLine())); }

                System.out.println("car's information successfully updated ");
                 ye = String.valueOf(xx.getYear());

                System.out.println("Brand: "+ xx.getBrand()+ ",Model:"+ xx.getModel()+ ", Reference:"+ xx.getReference()+ ", Year: " + ye);
                gotit = 1;

            }
        }
        if (gotit == 0) {
            System.out.println("user not found !");
        }


    }
    public static void savecars(){
        Cars xx = new Cars();
        System.out.println("save cars");
        String outtext;
        try {
            File rentfile = new File("cars.csv");
            FileWriter out = new FileWriter(rentfile);
            for (int i = 0; i < listcars.size();i++) {
                xx = listcars.get(i);
                String newline = System.getProperty("line.separator");
                outtext = xx.getBrand()+ ";"+ xx.getModel()+ ";"+ xx.getReference()+ ";"+ xx.getYear()+ newline;
                out.write(outtext);
            }
            out.close();
            System.out.println("cars data saved in cars.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadcars() {
        Cars xx = new Cars();
        System.out.println("Load cars");
        listcars.clear();
        try {
            File fileload = new File("cars.csv");
            BufferedReader in = new BufferedReader(new FileReader(fileload));
            String st;
            while((st = in.readLine()) != null) {
                String[] strs = st.split("[,//;]");
                addcar(strs[0], strs[1], strs[2],Integer.parseInt(strs[3]));
            }
            in.close();
            System.out.println("cars data restored from cars.csv");
        } catch (IOException i) {
            i.printStackTrace();
        }


    }

}

