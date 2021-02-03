package FightBoat.src;

import javax.swing.*;

public class GUI {
    
    private static JFrame window;
    private static JPanel panel;
    private static JLabel testLabel;
    private static JButton testButton;
    

    public static void main(String[] args) {

        window = new JFrame("FightBoat");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        testLabel = new JLabel("I'm a JLabel.");
        testButton = new JButton("JButton");

        window.getContentPane().add(panel);
        panel.add(testLabel);
        panel.add(testButton);


        window.pack();
        window.setVisible(true);

    }

}
