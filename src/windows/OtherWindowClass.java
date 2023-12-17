package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherWindowClass extends JFrame {
    JButton button;
    OtherWindowClass(){
        super("Other window class");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        buildPanel();
        setActionListeners();
        setVisible(true);

    }
    private void setActionListeners(){
        button.addActionListener(new ButtonListener());
    }
    public void buildPanel(){
        button = new JButton("buttontest");
        add(button);
    }
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SomeNewClass testing = new SomeNewClass();
        }
    }

    public static void main(String[] args){
        OtherWindowClass otherWindow = new OtherWindowClass();
    }
}
