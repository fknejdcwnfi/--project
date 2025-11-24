package edu.sustech.xiangqi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static edu.sustech.xiangqi.InterChecking.*;
import static edu.sustech.xiangqi.SignInChecking.passworkcheck;
import static edu.sustech.xiangqi.SignInChecking.rightname;


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
        login.setFont(new Font("Dialog", Font.BOLD, 24)); // 使用默认字体，24磅，粗体
        login.setSize(100, 50);
        login.setLocation(225, 50);
        loginFrame.add(login);

        //

        //用户名的设置框架
        JTextField username = new JTextField();
        username.setSize(150, 25);
        username.setLocation(195, 130);
        loginFrame.add(username);
        //用户名的设置框架
        JLabel username1 = new JLabel("用户名：");
        username1.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        username1.setSize(100, 50);
        username1.setLocation(140, 120);
        loginFrame.add(username1);

        //密码填写框架（登录注册框）
        JTextField password = new JTextField();
        password.setSize(150, 25);
        password.setLocation(195, 190);
        loginFrame.add(password);
        //密码标签（）
        JLabel password1 = new JLabel("密码：");
        password1.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        password1.setSize(100, 50);
        password1.setLocation(150, 180);
        loginFrame.add(password1);
        //
        //开始游玩按键，按了就可以进入页面
        JButton button = new JButton("开始");
        button.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        button.setSize(100, 50);
        button.setLocation(150, 350);
        loginFrame.add(button);

        JLabel wrong = new JLabel("密码错误");
        wrong.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        wrong.setForeground(java.awt.Color.RED); // 设置颜色为红色
        wrong.setSize(100, 50);
        wrong.setLocation(230, 230);
        loginFrame.add(wrong);
        wrong.setVisible(false);

        JLabel unexist = new JLabel("用户名不存在");
        unexist.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        unexist.setForeground(java.awt.Color.RED); // 设置颜色为红色
        unexist.setSize(200, 50);
        unexist.setLocation(210, 230);
        loginFrame.add(unexist);
        unexist.setVisible(false);

        JButton buttonsignin = new JButton("注册");
        buttonsignin.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        buttonsignin.setSize(100, 50);
        buttonsignin.setLocation(250, 350);
        loginFrame.add(buttonsignin);
        /// /////////////////////////////////////////////

        /// /注册框
        JFrame Signinframe = new JFrame("注册");
        Signinframe.setLayout(null);
        Signinframe.setSize(500, 500);
        Signinframe.setVisible(false);

        JButton returnbutton = new JButton("返回");
        returnbutton.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        returnbutton.setSize(100, 50);
        returnbutton.setLocation(250, 350);
        Signinframe.add(returnbutton);

        JLabel signin = new JLabel("注册");
        signin.setFont(new Font("Dialog", Font.BOLD, 24)); // 24磅，粗体
        signin.setSize(100, 50);
        signin.setLocation(220, 50);
        Signinframe.add(signin);
        signin.setVisible(true);

        //用户名的设置框架（注册框的那个空格）

        JTextField nickname = new JTextField();
        nickname.setSize(150, 25);
        nickname.setLocation(190, 130);
        Signinframe.add(nickname);

        //用户名的设置框架（注册框的标签）
        JLabel nickname1 = new JLabel("昵称：");
        nickname1.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        nickname1.setSize(100, 50);
        nickname1.setLocation(150, 120);
        Signinframe.add(nickname1);

        //密码填写框架（注册的密码）
        JTextField setpassword = new JTextField();
        setpassword.setSize(150, 25);
        setpassword.setLocation(190, 190);
        Signinframe.add(setpassword);

        //密码标签（注册的密码框）
        JLabel setpassword1 = new JLabel("密码：");
        setpassword1.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        setpassword1.setSize(100, 50);
        setpassword1.setLocation(150, 180);
        Signinframe.add(setpassword1);


        JButton Confirmbutton = new JButton("确认密码");
        Confirmbutton.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        Confirmbutton.setSize(100, 50);
        Confirmbutton.setLocation(150, 350);
        Signinframe.add(Confirmbutton);

        JLabel Confirmsuscess = new JLabel("确认成功");
        Confirmsuscess.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        Confirmsuscess.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        Confirmsuscess.setSize(200, 50);
        Confirmsuscess.setLocation(230, 280);
        Signinframe.add(Confirmsuscess);
        Confirmsuscess.setVisible(false);

        JLabel fail1 = new JLabel("密码输入过短");
        fail1.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        fail1.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        fail1.setSize(200, 50);
        fail1.setLocation(210, 280);
        Signinframe.add(fail1);
        fail1.setVisible(false);

        JLabel fail2 = new JLabel("用户名不合法或已有其他玩家使用");
        fail2.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        fail2.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        fail2.setSize(200, 50);
        fail2.setLocation(160, 280);
        Signinframe.add(fail2);
        fail2.setVisible(false);

        JLabel fail3 = new JLabel("昵称和密码都不符合规定");
        fail3.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        fail3.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        fail3.setSize(200, 50);
        fail3.setLocation(180, 280);
        Signinframe.add(fail3);
        fail3.setVisible(false);

        /// ////////////////////////////////////////////////////////////

        this.gameFrame = new GameFrame();
        try {
            Scanner bianickname = new Scanner(new File(".\\src\\main\\java\\edu\\sustech\\xiangqi\\Nickname"));


            button.addActionListener(e -> {//button指开始的按键
                String importUserName=username.getText();
                String importUserPassword=password.getText();

                if (enteruser(importUserName)>=0)//指用户存在
                {
                    if(enterpassword(importUserPassword,enteruser(importUserName))){/// /////////////////////////////////////密码正确
                        loginFrame.setVisible(false);
                        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        gameFrame.pack();
                        gameFrame.getReturntologinbutton().setVisible(true);
                        gameFrame.setLocationRelativeTo(null);
                        gameFrame.setVisible(true);////////////////////////////////////////////
                    }//密码错误
                    else{TimeForDisplayAndLater.displayAndHideJLabel(wrong,500);
                        unexist.setVisible(false);
                    }
                }//下面是用户不存在
                else {wrong.setVisible(false);
                    TimeForDisplayAndLater.displayAndHideJLabel(unexist,500);
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("操作错误1");
        } catch (IOException e) {
            System.out.println("操作错误2");
        }

        buttonsignin.addActionListener(e -> {//从登录到注册的启动按键
            Signinframe.setVisible(true);
            loginFrame.setVisible(false);
        });

        returnbutton.addActionListener(e -> {//从注册界面回到登录界面
            Signinframe.setVisible(false);
            loginFrame.setVisible(true);
        });

        gameFrame.getReturntologinbutton().addActionListener(e -> {//从游戏框架回来到登录界面
            gameFrame.setVisible(false); // 隐藏游戏
            loginFrame.setVisible(true); // 显示登录
        });

        Confirmbutton.addActionListener(e->{//点击确认注册那个按键的操作判定
            String putnickname=nickname.getText();
            String putsetpassword=setpassword.getText();
            if(rightname(putnickname) && passworkcheck(putsetpassword)){//正确的密码格式和账号格式 //后面是写入对应文本的方法
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

                        // 1.2 注册成功，显示提示并设置延时跳转
                        Confirmsuscess.setText("注册成功！"); // 假设 Confirmsuscess 是成功的提示标签
                        // 关键：Timer 的action 将执行跳转
                        Timer jumpTimer = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Confirmsuscess.setVisible(false);
                                // --- 延时 0.5 秒后才执行的跳转逻辑 ---
                                Signinframe.setVisible(false);
                                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                gameFrame.pack();
                                gameFrame.getReturntologinbutton().setVisible(true);
                                gameFrame.setLocationRelativeTo(null);
                                gameFrame.setVisible(true);
                                // --- 延时跳转逻辑结束 ---
                                ((Timer) e.getSource()).stop();
                            }
                        });
                        jumpTimer.setRepeats(false);
                        Confirmsuscess.setVisible(true); // 立即显示成功提示
                        jumpTimer.start();              // 启动延时跳转

                    }catch(IOException e1){
                        System.out.println("无法写入相应文件");
                        Confirmsuscess.setText("写入文件失败！");
                        TimeForDisplayAndLater.displayAndHideJLabel(Confirmsuscess, 500); // 提示写入失败
                    }

                } else if(rightname(putnickname)) { // 昵称正确，但密码错误////////////////////////////////////
                // 密码输入过短
                TimeForDisplayAndLater.displayAndHideJLabel(fail1,500);

                }  else if(passworkcheck(putsetpassword)){// 密码正确，但昵称错误/已存在
                // 用户名不合法或已有其他玩家使用
                TimeForDisplayAndLater.displayAndHideJLabel(fail2,500);
            }
            else {// 昵称和密码都不符合规定
                TimeForDisplayAndLater.displayAndHideJLabel(fail3,500);
            }

        });

        //现在我重新嘴一个修改密码的框架
        //检测密码登录框/////////////////////////////////////////////////////
        JFrame changePasswordFrame = new JFrame("修改密码");
        changePasswordFrame.setLayout(null);
        changePasswordFrame.setSize(500, 500);
        changePasswordFrame.setVisible(true);
        //输入框是什么？
        //
        JLabel changePasswordLabel = new JLabel("修改密码");
        changePasswordLabel.setFont(new Font("Dialog", Font.BOLD, 24)); // 使用默认字体，24磅，粗体
        changePasswordLabel.setSize(100, 50);
        changePasswordLabel.setLocation(210, 20);
        changePasswordFrame.add(changePasswordLabel);
        changePasswordFrame.setVisible(false);
        //

        //用户名的设置框架
        JTextField oldPassword = new JTextField();
        oldPassword.setSize(150, 25);
        oldPassword.setLocation(195, 130);
        changePasswordFrame.add(oldPassword);

        //用户名的设置框架
        JLabel oldPasswordText = new JLabel("原密码：");
        oldPasswordText.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        oldPasswordText.setSize(100, 50);
        oldPasswordText.setLocation(145, 120);
        changePasswordFrame.add(oldPasswordText);

        //密码填写框架（登录注册框）
        JTextField newPassword = new JTextField();
        newPassword.setSize(150, 25);
        newPassword.setLocation(195, 190);
        changePasswordFrame.add(newPassword);

        JLabel theUserName = new JLabel("用户名：");
        theUserName.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        theUserName.setSize(100, 50);
        theUserName.setLocation(145, 60);
        changePasswordFrame.add(theUserName);

        JTextField theUserNameText = new JTextField();
        theUserNameText.setSize(150, 25);
        theUserNameText.setLocation(195, 70);
        changePasswordFrame.add(theUserNameText);

        //密码标签（）
        JLabel newPasswordText = new JLabel("新密码：");
        newPasswordText.setFont(new Font("Dialog", Font.PLAIN, 14)); // 14磅
        newPasswordText.setSize(100, 50);
        newPasswordText.setLocation(145, 180);
        changePasswordFrame.add(newPasswordText);
        //
        //开始游玩按键，按了就可以进入页面
        JButton yesToChangeButton = new JButton("确认修改");
        yesToChangeButton.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        yesToChangeButton.setSize(100, 50);
        yesToChangeButton.setLocation(150, 350);
        changePasswordFrame.add(yesToChangeButton);

        JButton returnTotheGame = new JButton("返回游戏");
        returnTotheGame.setFont(new Font("Dialog", Font.BOLD, 16)); // 16磅，粗体
        returnTotheGame.setSize(100, 50);
        returnTotheGame.setLocation(250, 350);
        changePasswordFrame.add(returnTotheGame);

        JLabel susTochangePassword = new JLabel("修改密码成功");
        susTochangePassword.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        susTochangePassword.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        susTochangePassword.setSize(200, 50);
        susTochangePassword.setLocation(210, 280);
        changePasswordFrame.add(susTochangePassword);
        susTochangePassword.setVisible(false);

        JLabel errorLabel = new JLabel("文件写入失败");
        errorLabel.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        errorLabel.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        errorLabel.setSize(200, 50);
        errorLabel.setLocation(210, 280);
        changePasswordFrame.add(errorLabel);
        errorLabel.setVisible(false);

        JLabel errorLabel2 = new JLabel("验证失败：用户名不存在、旧密码错误或新密码过短");
        errorLabel2.setFont(new Font("Dialog", Font.PLAIN, 12)); // 12磅
        errorLabel2.setForeground(java.awt.Color.BLUE); // 成功提示用蓝色
        errorLabel2.setSize(200, 50);
        errorLabel2.setLocation(170, 280);
        changePasswordFrame.add(errorLabel2);
        errorLabel2.setVisible(false);

        ///////////////////////////////////现在来搞这个鼠标点击事件
        gameFrame.getChangeinformation().addActionListener(e->{//这个还没有做

            changePasswordFrame.setVisible(true);
            gameFrame.setVisible(false);
        });

        yesToChangeButton.addActionListener(e->{
            String yourUserName = theUserNameText.getText();
            String yourOldPassword = oldPassword.getText();
            String yourNewPassword = newPassword.getText();

            // 1. 获取用户索引
            int userIndex = InterChecking.enteruser(yourUserName);

            // 2. 验证：用户存在 && 旧密码正确 && 新密码格式正确
            if (userIndex >= 0
                    && InterChecking.enterpassword(yourOldPassword, userIndex)
                    && SignInChecking.passworkcheck(yourNewPassword)) {

                // 3. 执行修改文件操作 (调用上面写好的工具方法)
                // 注意：这里调用的是新写的方法 updatePasswordInFile
                boolean updateSuccess = updatePasswordInFile(userIndex, yourNewPassword);

                if (updateSuccess) {
                    // 4. UI 反馈
                    TimeForDisplayAndLater.displayAndHideJLabel(susTochangePassword, 800);
                    TimeForDisplayAndLater.onlyHideFrame(changePasswordFrame, 1000);
                    TimeForDisplayAndLater.onlyDisplayFrame(loginFrame, 1000);
                } else {
                   TimeForDisplayAndLater.displayAndHideJLabel(errorLabel, 800);
                }

            } else {
                TimeForDisplayAndLater.displayAndHideJLabel(errorLabel2, 800);
            }
        });


        returnTotheGame.addActionListener(e->{
            changePasswordFrame.setVisible(false);
            gameFrame.setVisible(true);
        });
    }
}
