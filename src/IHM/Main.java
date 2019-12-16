package IHM;

public class Main {

    public static void main(String[] args) {

        String ch = "";

        // Welcome message
        System.out.println("Bienvenue");

        // Display the list of commands

        //AppControls.helpCommand();

        do {
            ch= AppControls.KeyboardScan();
            AppControls.commandsAction(ch);
        } while (!ch.equals("exit"));

    }
}
