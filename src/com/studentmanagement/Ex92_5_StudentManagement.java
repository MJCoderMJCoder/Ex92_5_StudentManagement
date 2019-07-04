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
	JMenu menu1, menu2, menu3, menu4, menu5; //�����˵�; JMenuΪ���������
	JMenuItem item1, item2, item3, item4, item5; //item:��Ŀ�����һ����Ʒ��һ������
	Ex92_6_StudentAdd zengjia;
	EX92_7_StudentQuery chaxun;
	EX92_8_StudentUpdate gengxin;
	EX92_9_StudentDelete shanchu;

	public Ex92_5_StudentManagement() {
		super("ѧ����Ϣ����ϵͳ");
		zengjia = new Ex92_6_StudentAdd();
		chaxun = new EX92_7_StudentQuery();
		gengxin = new EX92_8_StudentUpdate();
		shanchu = new EX92_9_StudentDelete();
		bar = new JMenuBar();
		menu1 = new JMenu("��Ϣ¼��");
		menu2 = new JMenu("��Ϣ��ѯ");
		menu3 = new JMenu("��Ϣ����");
		menu4 = new JMenu("��Ϣɾ��");
		menu5 = new JMenu("�˳�ϵͳ");
		item1 = new JMenuItem("����¼��");
		item2 = new JMenuItem("������ѯ");
		item3 = new JMenuItem("��������");
		item4 = new JMenuItem("����ɾ��");
		item5 = new JMenuItem("�����˳�");
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
		setJMenuBar(bar); //������
		
		item1.addActionListener(this); //this����������������¼���this�����Ĵ����¼�
		item2.addActionListener(this); //ע�����������������Ȩ��������Ϊ�¼������߶���
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		
		JLabel label = new JLabel("ѧ����Ϣ����ϵͳ", JLabel.CENTER); //��ǩ
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
	public void actionPerformed(ActionEvent e) { //performed��ִ�С�����
		if (e.getSource() == item1) {
			this.getContentPane().removeAll();
			this.getContentPane().add(zengjia, "Center");
			this.getContentPane().repaint();
			this.getContentPane().validate(); //validate����֤��ȷ�ϡ�ʹ��Ч
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
		stuM.setVisible(true); //��JFrame�ഴ���Ĵ�������Ϊ�ɼ�
		
		stuM.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); //�������ഴ������ʱ��java��������������Ĵ��������һ�𣬲���д���󷽷���
	}
}
