package loop;

import utils.input.parser.CommandParser;

import java.util.Scanner;

public class GameLoop {
    public static void main(String[] args){
        CommandParser parser = new CommandParser();
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the MVP.");
        System.out.println("Type q to quit.");
        while(running){
            System.out.println("Enter a command: ");
            String input = scan.nextLine().trim().toLowerCase();

            if("q".equals(input) || "quit".equals(input)){
                running = false;
                System.out.println("Exiting...");
                break;
            }
            parser.parse(input);

            System.out.println("tick updated.");
        }
        scan.close();
    }
}
