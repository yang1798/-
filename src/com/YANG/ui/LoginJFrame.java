package com.YANG.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {


    public LoginJFrame(){
       //初始化界面框架
        initFrame();
        //初始化界面内容
        initcontent();


        //让界面显示，建议写在最后
        this.setVisible(true);
    }

    private void initcontent() {
        //添加用户名
        JLabel username = new JLabel(new ImageIcon("image/login/用户名.png"));
        username.setBounds(116,135,47,17);
        this.getContentPane().add(username);

        //添加用户名的文本框
        JTextField usernametextbox = new JTextField();
        usernametextbox.setBounds(195,135,200,30);
        this.getContentPane().add(usernametextbox);

        //添加密码
        JLabel password = new JLabel(new ImageIcon("image/login/密码.png"));
        password.setBounds(130,195,32,16);
        this.getContentPane().add(password);

        //添加密码框
        JPasswordField passwordtextbox = new JPasswordField();
        passwordtextbox.setBounds(195,195,200,30);
        this.getContentPane().add(passwordtextbox);

        //添加验证码
        JLabel code = new JLabel(new ImageIcon("image/login/验证码.png"));
        code.setBounds(132,256,50,30);
        this.getContentPane().add(code);

        //添加验证码框
        JTextField codetextbox = new JTextField();
        codetextbox.setBounds(195,256,100,30);
        this.getContentPane().add(codetextbox);





        //最后添加的背景图
        JLabel background = new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(2,2,470,390);
        this.getContentPane().add(background);












    }

    private void initFrame(){
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图登入");
        //设置界面永远置顶,不然点击其他会盖住界面
        this.setAlwaysOnTop(true);
        //设置界面出来时是居中屏幕的
        this.setLocationRelativeTo(null);
        //取消默认的居中放置，这样才能用坐标形式添加组件
        this.setLayout(null);
        //设置点了x程序会停止
        this.setDefaultCloseOperation(3);

    }








}
