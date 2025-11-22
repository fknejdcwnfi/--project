package edu.sustech.xiangqi;


import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame  extends JFrame {

    private JButton Startbutton;
    private JButton changeinformation;
    private JButton Returnbutton;
    private JButton returntologinbutton;


    public GameFrame() {

        super("中国象棋"); // 使用 super() 设置窗口标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout()); // <--- 关键：使用 BorderLayout

        // 1. 棋盘面板 (CENTER)
        ChessBoardModel model = new ChessBoardModel();
        ChessBoardPanel boardPanel = new ChessBoardPanel(model);
        this.add(boardPanel, BorderLayout.CENTER); // <--- 棋盘放在中心

        // 2. 按钮面板 (EAST)
        JPanel buttonPanel = new JPanel();
        // 按钮垂直排列，例如使用 GridLayout
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 20)); // 4行1列，间距10x20

        // 初始化按钮（不再需要 setSize/setLocation，由布局管理器控制）
        Startbutton = new JButton("点击开始");
        changeinformation = new JButton("修改信息");
        Returnbutton = new JButton("菜单退出");
        returntologinbutton = new JButton("返回登录"); // 建议将文本改得更清晰

        // 添加到按钮面板
        buttonPanel.add(Startbutton);
        buttonPanel.add(changeinformation);
        buttonPanel.add(Returnbutton);
        buttonPanel.add(returntologinbutton);

        // 将按钮面板添加到窗口右侧
        this.add(buttonPanel, BorderLayout.EAST);

        // 初始设置
        this.pack(); // <--- 调整窗口大小以适应所有组件
        this.setVisible(false);
    }


    public void setVisible(boolean b) {
        super.setVisible(b);
    }


    public JButton getReturntologinbutton() {
        return returntologinbutton;
    }


    public JButton getChangeinformation() {
        return this.changeinformation;
    }
}
