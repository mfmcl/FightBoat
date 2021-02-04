package FightBoat.src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MikeGUI {
    static JPanel container = new JPanel();
    static JPanel panelP1 = new JPanel(); // panel for player 1
    static JPanel panelP2 = new JPanel(); // panel for player 2
    static JPanel gamePanel = new JPanel(); // panel for game messsages


    public static void addComponentsToPane(Container f) {
        
        // container.setLayout(new BorderLayout());

        panelP1.setPreferredSize(new Dimension(400, 400));
        panelP1.setBackground(Color.red);
        f.add(panelP1, BorderLayout.LINE_START);

        gamePanel.setPreferredSize(new Dimension(400, 400));
        gamePanel.setBackground(Color.green);
        f.add(gamePanel, BorderLayout.CENTER);
       
        panelP2.setPreferredSize(new Dimension(400, 400));
        panelP2.setBackground(Color.blue);
        f.add(panelP2, BorderLayout.LINE_END);

        JButton testBtn = new JButton("click me");
        f.add(testBtn, BorderLayout.PAGE_END);

        f.add(container);

    }

    public static void createAndShowGUI() {

        // create window
        JFrame f = new JFrame("FightBoat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(1200, 450));

        // add components
        addComponentsToPane(f.getContentPane());

        // create and add 
        
        // display window
        f.pack();
        f.setVisible(true);
    }


    public static void main(String[] args) {
        createAndShowGUI();
    }
}
