//package FightBoat.src;

import javax.swing.*;

public class GUI {
    
    public static void makeGUI() {
        JLabel label = new JLabel("Hi Nika");
        Main.frame.getContentPane().add(label);

    }

    public static void createWindow() {   
        JFrame frame = new JFrame("FightBoat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createWindow();
        }
    });

    public static void main(String[] args) {
        
    }

}
