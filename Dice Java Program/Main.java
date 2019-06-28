//Mathew Argue
//Main for dice roll program

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main extends JFrame
{

    MyDieRoll rollThatDice = new MyDieRoll();

    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main(){
        prepareGUI();
    }

    public static void main(String[] args){
        Main mainSetup = new Main();
        mainSetup.showButton();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Dice Roll Example");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showButton(){
        headerLabel.setText("Click a button to roll a dice!");

        Button smallDice = new Button("Roll a 6 sided dice");

        smallDice.addActionListener(e -> statusLabel.setText("The 6 sided dice landed a " + rollThatDice.getDieRoll(6)));

        Button  midDice = new Button("Roll a 24 sided dice");

        midDice.addActionListener(e -> statusLabel.setText("The 24 sided dice landed a " + rollThatDice.getDieRoll(24)));

        Button largeDice = new Button("Roll a 54 sided dice");

        largeDice.addActionListener(e -> statusLabel.setText("The 54 sided dice landed a " + rollThatDice.getDieRoll(54)));

        controlPanel.add(smallDice);
        controlPanel.add(midDice);
        controlPanel.add(largeDice);

        mainFrame.setVisible(true);
    }




}
