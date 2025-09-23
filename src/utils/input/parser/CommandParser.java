package utils.input.parser;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {
    private ArrayList<String> tokens;
    public CommandParser(){
        tokens = new ArrayList<>();
    }
    public void parse(String input){
        this.tokens = new ArrayList<>(Arrays.asList(input.trim().toLowerCase().split(" ")));

        if(tokens.size() < 2){
            System.out.println("Invalid command. Use \"<verb> <object>\" syntax.");
            return;
        }

        String verb = this.tokens.get(0);
        String gameObject = this.tokens.get(1);

        if("use".equals(verb) && "toilet".equals(gameObject)) {
            outputMessage(verb,gameObject);
        } else if ("clean".equals(verb) && "toilet".equals(gameObject)){
            outputMessage(verb,gameObject);
        } else {
            System.out.println("Unknown command. Use \"<verb> <object>\" syntax.");
        }
    }
    public void outputMessage(String verb, String gameObject){
        String output;
        if(verb.charAt(verb.length()-1) == 'e'){
            System.out.println("You " + verb + "d the " + gameObject);
        } else {
            System.out.println("You " + verb + "ed the " + gameObject);
        }

    }

}
