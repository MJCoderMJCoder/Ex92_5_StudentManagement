package com.studentmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ex92_5_StudentManagement extends JFrame implements ActionListener {
	JMenuBar bar = null;
	JMenu menu1, menu2, menu3, menu4, menu5; //声明菜单; JMenu为轻量级组件
	JMenuItem item1, item2, item3, item4, item5; //item:项目、条款、一件物品、一则新闻
	Ex92_6_StudentAdd zengjia;
	EX92_7_StudentQuery chaxun;
	EX92_8_StudentUpdate gengxin;
	EX92_9_StudentDelete shanchu;

	public Ex92_5_StudentManagement() {
		super("学生信息管理系统");
		zengjia = new Ex92_6_StudentAdd();
		chaxun = new EX92_7_StudentQuery();
		gengxin = new EX92_8_StudentUpdate();
		shanchu = new EX92_9_StudentDelete();
		bar = new JMenuBar();
		menu1 = new JMenu("信息录入");
		menu2 = new JMenu("信息查询");
		menu3 = new JMenu("信息更新");
		menu4 = new JMenu("信息删除");
		menu5 = new JMenu("退出系统");
		item1 = new JMenuItem("单击录入");
		item2 = new JMenuItem("单击查询");
		item3 = new JMenuItem("单击更新");
		item4 = new JMenuItem("单击删除");
		item5 = new JMenuItem("单击退出");
		menu1.add(item1);
		menu2.add(item2);
		menu3.add(item3);
		menu4.add(item4);
		menu5.add(item5);
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		bar.add(menu5);
		setJMenuBar(bar); //？？？
		
		item1.addActionListener(this); //this用来处理监听到的事件；this真正的处理事件
		item2.addActionListener(this); //注册监听器，并进行授权、；参数为事件处理者对象
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		
		JLabel label = new JLabel("学生信息管理系统", JLabel.CENTER); //标签
		String s = "";
		Font f = new Font(s, Font.BOLD, 22);
		label.setFont(f);
		label.setBackground(Color.green);
		label.setForeground(Color.BLUE);
		add(label, "Center");
		setVisible(true);
		setSize(350, 350);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //performed：执行、表演
		if (e.getSource() == item1) {
			this.getContentPane().removeAll();
			this.getContentPane().add(zengjia, "Center");
			this.getContentPane().repaint();
			this.getContentPane().validate(); //validate：验证、确认、使生效
		}
		if (e.getSource() == item2) {
			this.getContentPane().removeAll();
			this.getContentPane().add(chaxun, "Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
		}
		if (e.getSource() == item3) {
			this.getContentPane().removeAll();
			this.getContentPane().add(gengxin, "Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
		}
		if (e.getSource() == item4) {
			this.getContentPane().removeAll();
			this.getContentPane().add(shanchu, "Center");
			this.getContentPane().repaint();
			this.getContentPane().validate();
		}
		if(e.getSource() == item5) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Ex92_5_StudentManagement stuM = new Ex92_5_StudentManagement();
		stuM.setVisible(true); //将JFrame类创建的窗体设置为可见
		
		stuM.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); //用匿名类创建对象时，java允许把类体与对象的创建组合在一起，并重写抽象方法；
	}
}
