package clientFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lostpwd_Frame extends JFrame implements ActionListener {
	private JLabel p_idL, p_nameL, p_telL, p_mailL;
	private JTextField p_id, p_name, p_tel2, p_tel3, p_mail, p_mail2;
	private JButton p_findB;
	private JComboBox<String> p_telC, p_mailC;

	public Lostpwd_Frame() {
		setTitle("비밀번호찾기");

		// JLabel
		p_idL = new JLabel("ID : ");
		p_nameL = new JLabel("이름 : ");
		p_telL = new JLabel("전화번호 : ");
		p_mailL = new JLabel("이메일 : ");

		// JTextField
		p_id = new JTextField(8);
		p_name = new JTextField(8);
		p_tel2 = new JTextField(4);
		p_tel3 = new JTextField(4);
		p_mail = new JTextField(6);
		p_mail2 = new JTextField(6);

		// JButton
		p_findB = new JButton("찾기");

		// JComboBox
		String[] num = { "010", "011", "017", "019" };
		p_telC = new JComboBox<String>(num);
		
		String[] num2 = { "-이메일 선택-", "naver.com", "hanmal.net", "google.com", "hotmail.net", "yahoo.com", "empas.com",
				"gmail.com", "직접입력" };
		p_mailC = new JComboBox<String>(num2);

		p_mailC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox jbox = (JComboBox) e.getItemSelectable();
					String mail = (String) jbox.getSelectedItem();
					p_mail2.setText(mail);

				}
			}
		});

		JPanel idP = new JPanel();		//ID
		idP.setBackground(new Color(255, 245, 245));
		idP.add(p_idL);
		idP.add(p_id);

		JPanel nameP = new JPanel();	//이름
		nameP.setBackground(new Color(255, 245, 245));
		nameP.add(p_nameL);
		nameP.add(p_name);

		JPanel telP = new JPanel(); // 연락처
		telP.setBackground(new Color(255, 245, 245));
		telP.add(p_telL);
		telP.add(p_telC);
		telP.add(new Label("-"));
		telP.add(p_tel2);
		telP.add(new Label("-"));
		telP.add(p_tel3);

		JPanel mailP = new JPanel(); // 이메일
		mailP.setBackground(new Color(255, 245, 245));
		mailP.add(p_mailL);
		mailP.add(p_mail);
		mailP.add(p_mail2);
		mailP.add(p_mailC);

		JPanel buttonP = new JPanel();	//Button
		buttonP.setBackground(new Color(255, 245, 245));
		buttonP.add(p_findB);

		setLayout(null);

		idP.setBounds(23, 35, 180, 30);
		nameP.setBounds(15, 75, 180, 30);
		telP.setBounds(-3, 115, 300, 30);
		mailP.setBounds(5, 155, 350, 30);
		buttonP.setBounds(60, 205, 250, 50);

		Container c = this.getContentPane();
		c.setBackground(new Color(255, 245, 245));
		c.add(idP);
		c.add(nameP);
		c.add(telP);
		c.add(mailP);
		c.add(buttonP);

		setBounds(700, 200, 380, 290);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트
		p_findB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p_findB) {
			
		}
	}

	public static void main(String[] args) {
		new Lostpwd_Frame();

	}

}
