package edu.sustech.xiangqi;


import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;

import javax.swing.*;

public class GameFrame {
    JFrame frame = new JFrame("中国象棋");
    public GameFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessBoardModel model = new ChessBoardModel();
        ChessBoardPanel boardPanel = new ChessBoardPanel(model);

        frame.add(boardPanel);
        frame.pack();//先add的显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
    }
    public JFrame getFrame() {
        return this.frame;
    }

}
