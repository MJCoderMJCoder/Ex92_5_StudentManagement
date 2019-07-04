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
	JTextField tf1, tf2, tf3, tf4, tf5, tf6; //J�����������������
	Box baseBox, bv1, bv2;

	public Ex92_6_StudentAdd() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch(ClassNotFoundException e) {}
		try {
			con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			sql = con.createStatement();
		} catch (SQLException ee){}
		setLayout(new BorderLayout()); //�߽粼��
		JPanel p1 = new JPanel(); //���
		JPanel p2 = new JPanel();
		tf1 = new JTextField(16);
		tf2 = new JTextField(16);
		tf3 = new JTextField(16);
		tf4 = new JTextField(16);
		tf5 = new JTextField(16);
		tf6 = new JTextField(16);
		b1 = new JButton("¼��");
		b2 = new JButton("����");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		bv1 = Box.createVerticalBox(); //vertical����ֱ�ġ������
		bv1.add(new JLabel("ѧ�ţ�"));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("������"));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("�Ա�"));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("��ַ��"));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("�绰��"));
		bv1.add(Box.createVerticalStrut(15));
		bv1.add(new JLabel("רҵ��"));
		bv1.add(Box.createVerticalStrut(15));
		bv2 = Box.createVerticalBox(); //vertical����ֱ�ġ������
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
		bv2.add(Box.createVerticalStrut(8)); //��strut��֧����֧�ţ�ֺ��������ߣ�
		baseBox = Box.createHorizontalBox(); //horizontal��ˮƽ�ġ�ˮƽ��
		baseBox.add(bv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(bv2);
		p2.add(baseBox);
		add(p1, "South"); //south����
		add(p2, "Center");
		setSize(350, 350);
		setBackground(Color.pink); //pink���ۺ�ɫ���ģ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				insert();
			} catch(SQLException ee) {
				
			}
			JOptionPane.showMessageDialog(this, "���ݿ������", "��ʾ�Ի���", JOptionPane.INFORMATION_MESSAGE);
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
