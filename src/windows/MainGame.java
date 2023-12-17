package windows;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame{
    private JPanel north_panel;
    private JPanel south_panel;
    private JPanel west_panel;
    private JLabel gameLabel;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton exitButton;

    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 800;
    private final String NEW_GAME = "NEW GAME";
    private final String LOAD_GAME = "LOAD GAME";
    private final String EXIT = "EXIT";
    public MainGame(){
        super("Pizza Delivery Game");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildPanel();

        add(north_panel, BorderLayout.NORTH);
        add(south_panel,BorderLayout.SOUTH);
        add(west_panel,BorderLayout.WEST);

        setActionListeners();

        pack();
        setVisible(true);
    }
    public void buildPanel(){
        gameLabel = new JLabel("Welcome to Pizza delivery.");
        newGameButton = new JButton(NEW_GAME);
        loadGameButton = new JButton(LOAD_GAME);

        exitButton = new JButton(EXIT);

        north_panel = new JPanel();
        west_panel = new JPanel();
        south_panel = new JPanel();
        north_panel.add(gameLabel);
        west_panel.add(newGameButton);
        west_panel.add(loadGameButton);
        south_panel.add(exitButton);




    }
    private void setActionListeners(){
        exitButton.addActionListener(new ExitButtonListener());
        newGameButton.addActionListener(new ButtonListener());
        loadGameButton.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand() == NEW_GAME){
                System.out.println(NEW_GAME);
                OtherWindowClass otherWindow = new OtherWindowClass();
            }else if(e.getActionCommand() == LOAD_GAME){
                System.out.println(LOAD_GAME);
            }
        }
    }
    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        MainGame main = new MainGame();
    }
}
