package com.YANG.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //创建二维数组
    int[][] data = new int[4][4];

    //记录空白方块在二维数组的位置
    int x = 0;
    int y = 0;

    //记录图片位置的变量
    String category = "sport";

    //记录是类中的第几个图片
    int index = 1;

    //胜利时的二维数组
    int[][] win ={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };

    //移动步数
    int step=0;

    // 创建条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登入");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem beautyItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

    public GameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //初始化图片（加载打乱后的图片）
        initImage();

        //让界面显示，建议写在最后
        this.setVisible(true);
    }

    private void initData() {
         //定义一个一维数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱数组顺序
        Random r = new Random();
        for(int i=0;i<tempArr.length;i++){
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //用遍历到的数据与随机索引上面的进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //遍历打乱后的一维数组，把这些元素放入二维数组里面
        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i]==0){
                x = i/4;
                y = i%4;
            }
            data[i/4][i%4] = tempArr[i];


        }


    }

    //初始化图片,用二维数组的方式添加
    private void initImage() {
        //清空原本的所有图片
        this.getContentPane().removeAll();

        //调用victory方法，如果为true就显示胜利图片
        if(victory()){
            JLabel winJlabel = new JLabel(new ImageIcon("image/win.png"));
            winJlabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJlabel);
        }

        JLabel stepCount = new JLabel("步数"+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);



        //添加图片
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //获取序号
                int num = data[i][j];
                //创建一个ImageIcon对象
                //创建一个JLabel对象
                JLabel jLabel = new JLabel(new ImageIcon("image/"+category+"/"+category+index+"/"+num+".jpg"));
                //指定图片位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //把管理容器添加到界面
                this.getContentPane().add(jLabel);
            }

        }

        //添加背景图片
        //因为先添加的图片在上方，所以背景图片要后添加
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    private void initJMenuBar() {
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changJMenu = new JMenu("更换图片");



        //将每个选项下的条目添加到选项中
        functionJMenu.add(changJMenu);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        
        aboutJMenu.add(accountItem);
        changJMenu.add(beautyItem);
        changJMenu.add(animalItem);
        changJMenu.add(sportItem);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        beautyItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);


        //将菜单两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //把菜单加到界面里面
        this.setJMenuBar(jMenuBar);


    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图游戏单机 V1.0");
        //设置界面永远置顶,不然点击其他会盖住界面
        this.setAlwaysOnTop(true);
        //设置界面出来时是居中屏幕的
        this.setLocationRelativeTo(null);
        //设置点了x程序会停止
        this.setDefaultCloseOperation(3);
        //取消默认的居中放置，这样才能用坐标形式添加组件
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松会执行这个
    @Override
    public void keyPressed(KeyEvent e) {
        //如果游戏胜利就不能执行这个方法
        if(victory())
            return;
        int code = e.getKeyCode();
        //a:65
        if (code == 65) {
            //把界面所有元素删除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon("image/"+category+"/"+category+index+"/"+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //如果游戏胜利就不能执行这个方法
        if(victory())
            return;

        //左：37 上：38 右：39 下：40 键盘上按键的编码值
        int code = e.getKeyCode();
        if(code==37){
            System.out.println("向左移动");
            //边界处理
            if(y==3){
                return;
            }
            //向左移动就是把空白方块和其右边的方块交换位置
            //改变二维数组中的序号
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            //更新新的二维数组的x,y
            y++;
            //每移动一次就将step++
            step++;
            //使用initImage()来更新向左移动后的图片
            initImage();
        }else if(code==38){
            System.out.println("向上移动");
            //边界处理
            if(x==3){
                return;
            }
            //向上移动就是把空白方块和其下方的方块交换位置
            //改变二维数组中的序号
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            //更新新的二维数组的x,y
            x++;
            //每移动一次就将step++
            step++;
            //使用initImage()来更新向上移动后的图片
            initImage();

        }else if(code==39){
            System.out.println("向右移动");
            //边界处理
            if(y==0){
                return;
            }
            //向右移动就是把空白方块和其左边的方块交换位置
            //改变二维数组中的序号
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            //更新新的二维数组的x,y
            y--;
            //每移动一次就将step++
            step++;
            //使用initImage()来更新向右移动后的图片
            initImage();
        }else if(code==40){
            System.out.println("向下移动");
            //边界处理
            if(x==0){
                return;
            }
            //向下移动就是把空白方块和其上方的方块交换位置
            //改变二维数组中的序号
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            //更新新的二维数组的x,y
            x--;
            //每移动一次就将step++
            step++;
            //使用initImage()来更新向下移动后的图片
            initImage();
        }else if(code==65){
            initImage();//当按键a松开后重新加载图片
        }else if(code==87){
            //当按下w时就会一键还原
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            //新创建的data会覆盖原来的data
            initImage();
        }
    }

    //判断data中数据是否和win数组相同
    public boolean victory() {
        //有一个不一样就可以返回false了
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前的点击对象
        Object obj = e.getSource();
        if(obj == replayItem){
            System.out.println("重新游戏");
            //先把计数器清零
            step = 0;
            //打乱数据
            initData();
            //加载图片
            initImage();



        }else if(obj == reLoginItem){
            System.out.println("重新登入");
            //关闭当前界面
            this.setVisible(false);
            //打开登入界面
            new LoginJFrame();
        }else if(obj == closeItem){
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);

        }else if(obj == accountItem){
            System.out.println("公众号");

            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建JLabel对象
            JLabel jLabel = new JLabel(new ImageIcon("image/about.jpg"));
            //设置位置和宽高
            jLabel.setBounds(0,0,288,288);
            //在JDialog中添加JLabel
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(344,344);
            //使弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不取消无法使用下面的界面
            jDialog.setModal(true);
            //显示
            jDialog.setVisible(true);
        }else if(obj == beautyItem){
            //随机女孩图片的编号
            Random r = new Random();
            index = r.nextInt(13)+1;
            category = "girl";
            initImage();
        }else if(obj == animalItem){
            Random r = new Random();
            index = r.nextInt(8)+1;
            category = "animal";
            initImage();
        }else if(obj == sportItem){
            Random r = new Random();
            index = r.nextInt(10)+1;
            category = "sport";
            initImage();
        }
    }
}
