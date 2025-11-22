package edu.sustech.xiangqi;

import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static edu.sustech.xiangqi.interchecking.enterpassword;
import static edu.sustech.xiangqi.interchecking.enteruser;
import static edu.sustech.xiangqi.signinchecking.passworkcheck;
import static edu.sustech.xiangqi.signinchecking.rightname;

public class LoginFrame extends JFrame{

    private GameFrame gameFrame;

    public LoginFrame() {
        //检测密码登录框/////////////////////////////////////////////////////
        JFrame loginFrame = new JFrame("登录");
        loginFrame.setLayout(null);
        loginFrame.setSize(500, 500);
        loginFrame.setVisible(true);
        //输入框是什么？
        //
        JLabel login = new JLabel("登录");
        login.setSize(100, 50);
        login.setLocation(100, 100);
        loginFrame.add(login);

        //

        //用户名的设置框架
        JTextField username = new JTextField();
        username.setSize(100, 50);
        username.setLocation(200, 50);
        loginFrame.add(username);
        //用户名的设置框架
        JLabel username1 = new JLabel("用户名：");
        username1.setSize(200, 50);
        username1.setLocation(160, 45);
        loginFrame.add(username1);

        //密码填写框架（登录注册框）
        JTextField password = new JTextField();
        password.setSize(100, 50);
        password.setLocation(200, 150);
        loginFrame.add(password);
        //密码标签（）
        JLabel password1 = new JLabel("密码：");
        password1.setSize(200, 200);
        password1.setLocation(170, 70);
        loginFrame.add(password1);
        //
        //开始游玩按键，按了就可以进入页面
        JButton button = new JButton("Play");
        button.setSize(100, 50);
        button.setLocation(75, 350);
        loginFrame.add(button);

        JLabel wrong = new JLabel("密码错误");
        wrong.setSize(200, 50);
        wrong.setLocation(200, 260);
        loginFrame.add(wrong);
        wrong.setVisible(false);

        JLabel unexist = new JLabel("用户名不存在");
        unexist.setSize(200, 50);
        unexist.setLocation(200, 260);
        loginFrame.add(unexist);
        unexist.setVisible(false);

        JButton buttonsignin = new JButton("注册");
        buttonsignin.setSize(100, 50);
        buttonsignin.setLocation(225, 350);
        loginFrame.add(buttonsignin);

        JButton guanbibutton=new JButton("关闭");
        guanbibutton.setSize(100,50);
        guanbibutton.setLocation(325,350);
        loginFrame.add(guanbibutton);
        /// /////////////////////////////////////////////

        /// /注册框
        JFrame Signinframe = new JFrame("注册");
        Signinframe.setLayout(null);
        Signinframe.setSize(500, 500);
        Signinframe.setVisible(false);



        JButton returnbutton = new JButton("返回");
        returnbutton.setSize(100, 50);
        returnbutton.setLocation(350, 350);
        Signinframe.add(returnbutton);

        JLabel signin = new JLabel("注册");
        signin.setSize(100, 50);
        signin.setLocation(100, 100);
        Signinframe.add(signin);
        signin.setVisible(true);

        //用户名的设置框架（注册框的那个空格）



        JTextField nickname = new JTextField();
        nickname.setSize(100, 50);
        nickname.setLocation(200, 50);
        Signinframe.add(nickname);



        //用户名的设置框架（注册框的标签）
        JLabel nickname1 = new JLabel("昵称：");
        nickname1.setSize(200, 50);
        nickname1.setLocation(160, 45);
        Signinframe.add(nickname1);

        //密码填写框架（注册的密码）
        JTextField setpassword = new JTextField();
        setpassword.setSize(100, 50);
        setpassword.setLocation(180, 150);
        Signinframe.add(setpassword);
        //密码标签（注册的密码框）
        JLabel setpassword1 = new JLabel("密码：");
        setpassword1.setSize(200, 200);
        setpassword1.setLocation(150, 70);
        Signinframe.add(setpassword1);

        JTextField changepassword = new JTextField();
        changepassword.setSize(100, 50);
        changepassword.setLocation(250, 150);
        Signinframe.add(changepassword);

        JLabel newpassword1 = new JLabel("新密码：");
        newpassword1.setSize(200, 200);
        newpassword1.setLocation(140, 130);
        Signinframe.add(newpassword1);



        JButton Confirmbutton = new JButton("确认密码");
        Confirmbutton.setSize(100, 50);
        Confirmbutton.setLocation(100, 350);
        Signinframe.add(Confirmbutton);

        JLabel Confirmsuscess = new JLabel("确认成功");
        Confirmsuscess.setSize(200, 50);
        Confirmsuscess.setLocation(150, 250);
        Signinframe.add(Confirmsuscess);
        Confirmsuscess.setVisible(false);
        /// ////////////////////////////////////////////////////////////

        this.gameFrame = new GameFrame();
        try {
            Scanner bianickname = new Scanner(new File(".\\src\\main\\java\\edu\\sustech\\xiangqi\\Nickname"));


            button.addActionListener(e -> {
                String A0=username.getText();
                String A1=password.getText();

                if (enteruser(A0)>=0)
                {
                    if(enterpassword(A1,enteruser(A0))){/// /////////////////////////////////////
                        loginFrame.setVisible(false);
                        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        gameFrame.setSize(1500, 800);
                        gameFrame.getReturntologinbutton().setVisible(true);
                        gameFrame.setLocationRelativeTo(null);
                        gameFrame.setVisible(true);////////////////////////////////////////////
                    }
                    else{wrong.setVisible(true);
                        unexist.setVisible(false);
                    }
                }
                else {wrong.setVisible(false);
                    unexist.setVisible(true);
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("操作错误1");
        } catch (IOException e) {
            System.out.println("操作错误2");
        }

        buttonsignin.addActionListener(e -> {
            Signinframe.setVisible(true);
            loginFrame.setVisible(false);
            changepassword.setVisible(false);
            newpassword1.setVisible(false);
        });

        returnbutton.addActionListener(e -> {
            Signinframe.setVisible(false);
            loginFrame.setVisible(true);
        });

        returnbutton.addActionListener(e -> {
            gameFrame.setVisible(false);
            loginFrame.setVisible(true);

        });

        Confirmbutton.addActionListener(e->{
            Confirmsuscess.setVisible(true);
            changepassword.setVisible(false);
            newpassword1.setVisible(false);
            String putnickname=nickname.getText();
            String putsetpassword=setpassword.getText();
            if(rightname(putnickname)){
                if(passworkcheck(putsetpassword)){
                    try{
                        String roadN=".\\src\\main\\java\\edu\\sustech\\xiangqi\\Nickname";
                        String roadP=".\\src\\main\\java\\edu\\sustech\\xiangqi\\Password";
                        BufferedWriter Nicknamewrite=new BufferedWriter(new FileWriter(roadN,true));
                        BufferedWriter Passwordwrite=new BufferedWriter(new FileWriter(roadP,true));
                        Nicknamewrite.write("\n");
                        Nicknamewrite.write(putnickname);
                        Passwordwrite.write("\n");
                        Passwordwrite.write(putsetpassword);
                        Nicknamewrite.close();
                        Passwordwrite.close();
                    }catch(IOException e1){
                        System.out.println("无法写入相应文件");
                    }
                }
                else{
                    Confirmsuscess.setText("密码输入过短");
                    Confirmsuscess.setVisible(true);
                }

            }
            else if(passworkcheck(putsetpassword)){
                Confirmsuscess.setText("用户名不合法或已有其他玩家使用");
                Confirmsuscess.setVisible(true);
            }
            else{
                Confirmsuscess.setText("昵称和密码都不符合规定");
            }
        });

        guanbibutton.addActionListener(e -> {
            loginFrame.setVisible(false);
        });

        gameFrame.getChangeinformation().addActionListener(e->{
            Signinframe.setVisible(true);
            nickname1.setText("新昵称");
            password1.setText("原密码");
            changepassword.setVisible(true);
            newpassword1.setVisible(true);

        });
    }


}
