package UI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<String> options;
    public Menu(List<String> options){
        setOptions(options);
    }
    private void setOptions(List<String> options){
        this.options = new ArrayList<String>(options != null ? options : new ArrayList<>());
    }
    public ArrayList<String> getOptions(){
        return new ArrayList<>(this.options);
    }

}
