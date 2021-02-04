package FightBoat.src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFace {
    static JFrame frameP1 = new JFrame("Player 1");
    static JPanel panelP1 = new JPanel();
    
    public static void createGameWindow()
    {
    frameP1.setSize(400, 400);
    frameP1.setLocation(500, 200);
    frameP1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameP1.add(panelP1);
    panelP1.setLayout(null);
    frameP1.setVisible(true);
    }

    public static void main(String[] args) {
        createGameWindow();
    }
}
