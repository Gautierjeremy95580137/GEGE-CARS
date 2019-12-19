package IHM;

import java.util.ArrayList;
import java.util.List;




public class Main {

    public static void main(String[] args) {

        //ArrayList<Object> userslist = new ArrayList<>();

        List<Users> userList=  new ArrayList<>();

        String ch = "";

        // Welcome message
        System.out.println("----****  BIENVENUE CHEZ GEGE-CARS  ****----");

        // Display the list of commands

        //AppControls.helpCommand();

        do {
            ch= AppControls.KeyboardScan();
            AppControls.commandsAction(ch);
        } while (!ch.equals("exit"));

    }


}
