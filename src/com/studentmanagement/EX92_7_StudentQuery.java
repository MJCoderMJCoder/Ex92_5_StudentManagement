package com.studentmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EX92_7_StudentQuery extends JPanel implements ActionListener {
	Connection con;
	Statement sql;
	JButton b;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6; //J�����������������
	Box baseBox, bv1, bv2;
	int flag = 0;

	public EX92_7_StudentQuery() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch(ClassNotFoundException e) {}
		try {
			con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			sql = con.createStatement();
		} catch (SQLException ee){}
		setLayout(new BorderLayout()); //�߽粼��
		b = new JButton("��ѯ");
		b.setBackground(Color.orange); //orange���Ȼ�ɫ
		b.addActionListener(this); //ע���¼�������������Ϊ�¼������߶���
		tf1 = new JTextField(8);
		tf2 = new JTextField(16);
		tf3 = new JTextField(16);
		tf4 = new JTextField(16);
		tf5 = new JTextField(16);
		tf6 = new JTextField(16);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		JPanel p1 = new JPanel(), p2 = new JPanel();
		p1.add(new Label("������ѧ�ţ�"));
		p1.add(tf1);
		p1.add(b);
		bv1 = Box.createVerticalBox(); //vertical����ֱ�ġ������
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
		add(p1, "North"); //north����
		add(p2, "Center");
		setSize(350, 350);
		setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		flag = 0;
		try {
			query();
		} catch(SQLException ee) {
		}
	}
	
	public void query() throws SQLException {
		String num, name, gender, address, phone, major;
		con = DriverManager.getConnection("jdbc:odbc:student", "", "");
		num = tf1.getText().trim(); //trim():ȥ����ʼ�ͽ�β�Ŀո�
		ResultSet rs = sql.executeQuery("SELECT * FROM student WHERE id='" + num + "'");
		if(rs.next()) {
			name = rs.getString("name");
			gender = rs.getString("gender");
			address = rs.getString("address");
			phone = rs.getString("phone");
			major = rs.getString("major");
			tf2.setText(name);
			tf3.setText(gender);
			tf4.setText(address);
			tf5.setText(phone);
			tf6.setText(major);
			flag = 1;
		} else {
			JOptionPane.showMessageDialog(this, "û�и�ѧ��", "��ʾ�Ի���", JOptionPane.INFORMATION_MESSAGE);
		}
		con.close();
		if (flag == 0) {
			tf1.setText("û�и�ѧ��");
		}
	}

}
