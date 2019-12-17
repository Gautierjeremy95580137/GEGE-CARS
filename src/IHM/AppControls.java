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
            Users.adduserCommand();

        } else if (commands.equals("listusers")){
            Users.listusers();

        } else if (commands.equals("edituser")) {
            Users.edituser();

        } else if (commands.equals("removeuser")) {
            Users.removeuser();
        }

    }

    private static void exitCommand() {
        System.out.println("goodbye");
    }

}
