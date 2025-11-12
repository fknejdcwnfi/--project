package edu.sustech.xiangqi;
import javax.swing.*;

public class LoginInFrame {
    public LoginInFrame() {//这里是创造的
        JFrame loginFrame = new JFrame("登录");
        loginFrame.setLayout(null);
        loginFrame.setSize(500,500);
        //一段下面的是一段输入框
        JTextField username = new JTextField();
        username.setLocation(200,50);
        username.setSize(100,50);
        loginFrame.add(username);
        //
        JLabel usernameLabel = new JLabel("用户名： ");
        usernameLabel.setSize(200,200);
        usernameLabel.setLocation(160,-30);
        loginFrame.add(usernameLabel);

        //密码
        JLabel passwordLabel = new JLabel("密码： ");
        passwordLabel.setSize(200,200);
        passwordLabel.setLocation(170,70);
        loginFrame.add(passwordLabel);
        //
        JTextField password = new JTextField();
        password.setLocation(200,150);
        password.setSize(100,50);
        loginFrame.add(password);
        //一段
        JButton button1 = new JButton("登录");
        button1.setLocation(200,250);
        button1.setSize(100,50);
        loginFrame.add(button1);
        loginFrame.setVisible(true);

        button1.addActionListener(e -> {
            loginFrame.setVisible(false);
            new GameFrame().getFrame().setVisible(true); // 需在 GameFrame 中添加 getFrame() 方法返回 frame
        });

    }
}
