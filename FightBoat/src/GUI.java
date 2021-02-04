package FightBoat.src;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends Main {

 BoatBattleship testBB = new BoatBattleship(testGrid, 0, 3, true);

    private static final int gridSize = 10;
    private final List<JButton> list = new ArrayList<JButton>();

    private JButton getGridButton(int r, int c) {
        int index = r * gridSize + c;
        return list.get(index);
    }

    private JButton createGridButton(final int row, final int col) {
        String thisSquare = Boolean.toString(testGrid.getSquare(col, row));
        final JButton b = new JButton(thisSquare);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton gb = GUI.this.getGridButton(row, col);
                BoatBattleship testBB = new BoatBattleship(testGrid, col, row, true);
                testBB.placeBoat();
                for (int i = 0; i < list.size(); i++) {
                    int row = i / gridSize;
                    int col = i % gridSize;        
                    getGridButton(row, col).setLabel(Boolean.toString(testGrid.getSquare(col, row)));
                }
                recolor();
                System.out.println("");
                
            }
        });
        return b;
    }

    private JPanel createGridPanel() {
        JPanel p = new JPanel(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize * gridSize; i++) {
            int row = i / gridSize;
            int col = i % gridSize;
            JButton gb = createGridButton(row, col);
            list.add(gb);
            p.add(gb);
        }
        recolor();
        return p;
    }

    public void display() {
        JFrame f = new JFrame("GridButton");
        f.setSize(200, 200);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createGridPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    private void recolor() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (testGrid.getSquare(i, j)) {
                    GUI.this.getGridButton(j, i).setBackground(Color.gray);
                } else {
                    GUI.this.getGridButton(j, i).setBackground(Color.cyan);
                }
    
            }
        }


    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().display();
            }
        });
    }
}