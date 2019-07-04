package com.studentmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex92_6_StudentAdd extends JPanel implements ActionListener {
	Connection con;
	Statement sql;
	JButton b1, b2;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6; //J···：轻量级组件
	Box baseBox, bv1, bv2;

	public Ex92_6_StudentAdd() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch(ClassNotFoundException e) {}
		try {
			con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			sql = con.createStatement();
		} catch (SQLException ee){}
		setLayout(new BorderLayout()); //边界布局
		JPanel p1 = new JPanel(); //面板
		JPanel p2 = new JPanel();
		tf1 = new JTextField(16);
		tf2 = new JTextField(16);
		tf3 = new JTextField(16);
		tf4 = new JTextField(16);
		tf5 = new JTextField(16);
		tf6 = new JTextField(16);
		b1 = new JButton("录入");
		b2 = new JButton("重置");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		bv1 = Box.createVerticalBox(); //vertical：垂直的、纵向的
		bv1.add(new JLabel("学号："));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("姓名："));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("性别："));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("地址："));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("电话："));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("专业："));
		bv1.add(Box.createVerticalStrut(15));
		bv2 = Box.createVerticalBox(); //vertical：垂直的、纵向的
		bv2.add(tf1);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(tf2);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(tf3);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(tf4);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(tf5);
		bv2.add(Box.createVerticalStrut(8));
		bv2.add(tf6);
		bv2.add(Box.createVerticalStrut(8)); //（strut：支柱、支撑；趾高气扬地走）
		baseBox = Box.createHorizontalBox(); //horizontal：水平的、水平线
		baseBox.add(bv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(bv2);
		p2.add(baseBox);
		add(p1, "South"); //south：南
		add(p2, "Center");
		setSize(350, 350);
		setBackground(Color.pink); //pink：粉红色（的）
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				insert();
			} catch(SQLException ee) {
				
			}
			JOptionPane.showMessageDialog(this, "数据库已入库", "提示对话框", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == b2) {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		}
	}
	
	public void insert() throws SQLException {
		String s1 = "'" + tf1.getText().trim() + "'";
		String s2 = "'" + tf2.getText().trim() + "'";
		String s3 = "'" + tf3.getText().trim() + "'";
		String s4 = "'" + tf4.getText().trim() + "'";
		String s5 = "'" + tf5.getText().trim() + "'";
		String s6 = "'" + tf6.getText().trim() + "'";
		String temp = "INSERT INTO student VALUES (" + s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 +
				"," + s6 + ")";
		con = DriverManager.getConnection("jdbc:odbc:student", "", "");
		sql.executeUpdate(temp);
		con.close();
	}

}
