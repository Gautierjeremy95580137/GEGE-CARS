package IHM;

import java.util.ArrayList;
import java.util.Scanner;

public class Cars extends Users {

    static ArrayList<String> brand = new ArrayList<String>();
    static ArrayList<String> model = new ArrayList<String>();
    static ArrayList<String> ref = new ArrayList<String>();
    static ArrayList<Integer> year = new ArrayList<Integer>();


    public static void addcar() {

        System.out.println("Add a new car ");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Brand: ");
        brand.add(sc.nextLine());
        System.out.println("Model: ");
        model.add(sc.nextLine());
        System.out.println("Enter reference: ");
        ref.add(sc.nextLine());
        System.out.println("Year of the car: ");
        int a;
        a = Integer.valueOf(sc.nextLine());
        year.add(a);
        System.out.println(" a new car is added !");
    }

    public static void editcar() {


        Scanner sc = new Scanner(System.in);
        System.out.println(" Search for a car ");
        System.out.println(" Reference ");
        String refff = sc.nextLine();
        String target = refff.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < ref.size(); i++) {
            String record = ref.get(i).toUpperCase();
            if (record.equals(target)) {
                System.out.println(" Car found !");
                System.out.println(" Brand: " + brand.get(i));
                refff = sc.nextLine();
                if (!refff.equals("")) {
                    brand.set(i, refff);
                }
                System.out.println("Model: " + model.get(i));
                refff = sc.nextLine();
                if (!refff.equals("")) {
                    model.set(i, refff);
                }
                System.out.println("Reference : " + ref.get(i));
                refff = sc.nextLine();
                if (!refff.equals("")) {
                    ref.set(i, refff);
                }
                System.out.println("Year:  " + String.valueOf(year.get(i)));
                refff = sc.nextLine();
                if (!refff.equals("")) {
                    year.set(i, Integer.valueOf(refff));
                }

                System.out.println("Car's information successfully updated ");
                String year1 = String.valueOf(year.get(i));

                System.out.println("Brand: " + brand.get(i) + ",Model: " + model.get(i) + ", Reference: " + ref.get(i) + ", Year:" + year1);
                gotit = 1;
            }

        }
    }

    public static void removecar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Remove car");
        System.out.println("Enter reference of the car ");
        String rc = sc.nextLine();
        String target = rc.toUpperCase();
        int gotit = 0;
        for (int i = 0; i < ref.size(); i++) {
            String record = ref.get(i).toUpperCase();
            if (record.equals(target)) {
                System.out.println("Car found ! ");
                //mettre la condition de location apres
                brand.remove(i);
                model.remove(i);
                ref.remove(i);
                year.remove(i);
                System.out.println("Car successfully deleted ! ");
                String yea = String.valueOf(year.get(i));
                System.out.println("Brand:  " + brand.get(i) + ", Model: " + model.get(i) + ", Reference: " + ref.get(i) + ", Year: " + yea);
                gotit = 1;
            }
        }
        if (gotit == 0) {
            System.out.println("Car not found ! ");
        }
    }

    public static void listcars() {

        System.out.println(" We have " + brand.size() + "cars ! ");
        System.out.println(" List of all cars ");
        for (int i = 0; i < brand.size(); i++) {
            String yea = String.valueOf(year.get(i));
            System.out.println("Brand: " + brand.get(i) + ", Model: " + model.get(i) + ", Reference: " + ref.get(i) + ", Year: " + yea);
        }
    }
}
