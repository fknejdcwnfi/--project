package edu.sustech.xiangqi;

import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;

import javax.swing.*;

public class XiangqiApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();//输入框另起一个类，现在是在调用父类
        });
    }
}
