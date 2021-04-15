package clientFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LostID_Frame extends JFrame implements ActionListener {
	private JLabel i_nameL, i_telL, i_mailL;
	private JTextField i_name, i_tel2, i_tel3, i_mail, i_mail2;
	private JButton i_findB;
	private JComboBox<String> i_telC, i_mailC;

	public LostID_Frame() {
		setTitle("ID찾기");

		// JLabel
		i_nameL = new JLabel("이름 : ");
		i_telL = new JLabel("전화번호 : ");
		i_mailL = new JLabel("이메일 : ");

		// JTextField
		i_name = new JTextField(8);
		i_tel2 = new JTextField(4);
		i_tel3 = new JTextField(4);
		i_mail = new JTextField(6);
		i_mail2 = new JTextField(6);

		// JButton
		i_findB = new JButton("찾기");

		// JComboBox
		String[] num = { "010", "011", "017", "019" };
		i_telC = new JComboBox<String>(num);

		String[] num2 = { "-이메일 선택-", "naver.com", "hanmal.net", "google.com", "hotmail.net", "yahoo.com", "empas.com",
				"gmail.com", "직접입력" };
		i_mailC = new JComboBox<String>(num2);

		i_mailC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox jbox = (JComboBox) e.getItemSelectable();
					String mail = (String) jbox.getSelectedItem();
					i_mail2.setText(mail);

				}
			}
		});

		JPanel nameP = new JPanel();	//이름
		nameP.setBackground(new Color(255, 245, 245));
		nameP.add(i_nameL);
		nameP.add(i_name);

		JPanel telP = new JPanel(); // 연락처
		telP.setBackground(new Color(255, 245, 245));
		telP.add(i_telL);
		telP.add(i_telC);
		telP.add(new Label("-"));
		telP.add(i_tel2);
		telP.add(new Label("-"));
		telP.add(i_tel3);

		JPanel mailP = new JPanel(); // 이메일
		mailP.setBackground(new Color(255, 245, 245));
		mailP.add(i_mailL);
		mailP.add(i_mail);
		mailP.add(i_mail2);
		mailP.add(i_mailC);
		
		JPanel buttonP = new JPanel();
		buttonP.setBackground(new Color(255, 245, 245));
		buttonP.add(i_findB);
		
		setLayout(null);
		
		nameP.setBounds(15, 35, 180, 30);
		telP.setBounds(-3, 75, 300, 30);
		mailP.setBounds(5, 115, 350, 30);
		buttonP.setBounds(60, 175, 250, 50);
		
		Container c = this.getContentPane();
		c.setBackground(new Color(255, 245, 245));
		c.add(nameP);
		c.add(telP);
		c.add(mailP);
		c.add(buttonP);

		setBounds(700, 200, 380, 290);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이벤트
		i_findB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == i_findB) {
		}
		

	}

	public static void main(String[] args) {
		new LostID_Frame();

	}

}
