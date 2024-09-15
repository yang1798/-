package com.YANG.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {

    public RegisterJFrame(){
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图 注册");
        //设置界面永远置顶,不然点击其他会盖住界面
        this.setAlwaysOnTop(true);
        //设置界面出来时是居中屏幕的
        this.setLocationRelativeTo(null);
        //设置点了x程序会停止
        this.setDefaultCloseOperation(3);
        //让界面显示，建议写在最后
        this.setVisible(true);

    }


}
