package IHM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppControls {


    /**
     * to display the list of controls
     */
    public static void helpCommand(){

        System.out.println("--------list of controls-------");
        System.out.println("'help' : display the list of control");
        System.out.println("'exit' : for quit the app /n");
        System.out.println("'adduser' : you can add user with this command,<fistname>,<lastname>,<country>,<departement>,<age>");
        System.out.println("'edituser' : you can edit an user with this command, <firstname>,<lastname>");
        System.out.println("'removeuser' : you can remove an user with this command, <firstanme>,<lastname>");
        System.out.println("'listusers' : display all of users");
        System.out.println("'addcar' : add a car to the list, <brand>,<model>,<ref>,<year>");
        System.out.println("'editcar' : use this command for edit a car, <ref>");
        System.out.println("'removecar' : use this command for remove a car");
        System.out.println("'listcars' : display all the cars");
        System.out.println("'rentcar' : command for rent a car");
        System.out.println("'returncar' : command for return a car");
        System.out.println("'listrent' : display the list of rents");
        System.out.println("'save' : use this command for save your file");
        System.out.println("'restore' : this command open your save file");
        System.out.println("----------------------------------");

    }

    public static String KeyboardScan(){

        System.out.println("Enter a command : ");
        Scanner sc = new Scanner(System.in);
        String command = sc.next().toLowerCase();
        if(command.equals("help") || command.equals("exit") || command.equals("adduser") || command.equals("edituser") || command.equals("removeuser") || command.equals("listusers") || command.equals("addcar") || command.equals("editcar") || command.equals("removecar") || command.equals("listcars") || command.equals("rentcar") || command.equals("returncar") || command.equals("listrent") || command.equals("save") || command.equals("restore")) {
            return command;
        } else {
            return "error";
        }

    }

    public static void commandsAction(String commands) {

        if(commands.equals("help")){
            helpCommand();
        } else if (commands.equals("exit")){
            exitCommand();
        } else if (commands.equals("adduser")){
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
            Users.adduser(fn, ln , cy , dep , a);

        } else if (commands.equals("listusers")){
            Users.userlist();

        } else if (commands.equals("edituser")) {
            Users xx = new Users();
            System.out.println("Edit user");
            Scanner sc = new Scanner(System.in);
            System.out.println("Firstname ?");
            String fn = sc.nextLine();
            System.out.println("Lastname ? ");
            String ln = sc.nextLine();
            Users.edituser(fn , ln);

        } else if (commands.equals("removeuser")) {
            Users xx = new Users();
            System.out.println("remove user");
            Scanner sc = new Scanner(System.in);
            System.out.println("Firstname ?");
            String fn = sc.nextLine();
            System.out.println("Lastname ? ");
            String ln = sc.nextLine();
            Users.removeuser(fn, ln);

        } else if (commands.equals("addcar")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Add a new car");
            System.out.println("Brand ?");
            String br = sc.nextLine();
            System.out.println("model ? ");
            String mo = sc.nextLine();
            System.out.println("reference ?");
            String ref = sc.nextLine();
            System.out.println("year ? ");
            int ye = Integer.valueOf(sc.nextLine());
            Cars.addcar(br, mo , ref , ye);
            System.out.println("a new car is added");

        } else if (commands.equals("editcar")) {
            Cars xx = new Cars();
            System.out.println("Edit car");
            Scanner sc = new Scanner(System.in);
            System.out.println("Reference ?");
            String ref = sc.nextLine();
            Cars.editcar(ref);

        } else if (commands.equals("removecar")) {
            Cars xx = new Cars();
            System.out.println("remove car");
            Scanner sc = new Scanner(System.in);
            System.out.println("reference ?");
            String ref = sc.nextLine();
            Cars.removecar(ref);

        } else if(commands.equals("listcars")) {
            Cars.carlist();

        } else if (commands.equals("rentcar")) {
            System.out.println("Add a new rent");
            Scanner sc = new Scanner(System.in);
            System.out.println("Firstname: ");
            String fn = sc.nextLine();
            System.out.println("Lastname: ");
            String ln = sc.nextLine();
            System.out.println("Reference: ");
            String ref = sc.nextLine();

            System.out.println("New rent added");
            Rents.rentcar(fn, ln ,ref);

        } else if (commands.equals("returncar")) {
            Rents xx = new Rents();
            System.out.println("remove rental");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the reference please ?");
            String ref = sc.nextLine();
            Rents.returncar(ref);

        }

    }

    private static void exitCommand() {
        System.out.println("goodbye");
    }

}
