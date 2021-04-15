package clientFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InputInfo_Frame extends JFrame implements ActionListener {
	private JLabel infoL, nameL, telL, mailL, birthL, genderL;
	private JTextField nameT,tel2T,tel3T, mailT,mail2T, yearT;
	private JButton okB, cancelB;
	private JComboBox<String> telC, monthC, dayC,mailC;
	private JRadioButton maleB, femaleB;

	public InputInfo_Frame() {
		setTitle("정보 입력");
		infoL = new JLabel("필수정보 입력");
		nameL = new JLabel("이름 : ");
		telL = new JLabel("연락처 : ");
		mailL = new JLabel("이메일 : ");
		birthL = new JLabel("생일 : ");
		genderL = new JLabel("성별 : ");

		nameT = new JTextField(8);
		tel2T = new JTextField(4);
		tel3T = new JTextField(4);
		mailT = new JTextField(6);
		mail2T = new JTextField(6);
		yearT = new JTextField(4);

		maleB = new JRadioButton("남성", true);
		femaleB = new JRadioButton("여성");

		String[] num = { "010", "011", "017", "019" };
		telC = new JComboBox<String>(num);

		String[] num2 = { "월", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		monthC = new JComboBox<String>(num2);

		String[] num3 = { "일", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		dayC = new JComboBox<String>(num3);
		
		String[] num4 = { "-이메일 선택-","naver.com", "hanmal.net", "google.com", "hotmail.net", "yahoo.com"
						, "empas.com", "gmail.com","직접입력" };
		mailC = new JComboBox<String>(num4);
		
		mailC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox jbox = (JComboBox)e.getItemSelectable();
					String mail = (String)jbox.getSelectedItem();
					mail2T.setText(mail);
							
				}
			}
		});
		
		
	
		okB = new JButton("확인");
		cancelB = new JButton("취소");

		// 패널
		JPanel infoP = new JPanel(); // 필수정보
		infoP.setBackground(new Color(255, 245, 245));
		infoP.add(infoL);

		JPanel nameP = new JPanel(); // 이름
		nameP.setBackground(new Color(255, 245, 245));
		nameP.add(nameL);
		nameP.add(nameT);

		JPanel genderP = new JPanel(); // 성별
		genderP.setBackground(new Color(255, 245, 245));
		genderP.add(genderL);
		maleB.setBackground(new Color(255, 245, 245));
		femaleB.setBackground(new Color(255, 245, 245));
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleB);
		bg.add(femaleB);
		genderP.add(maleB);
		genderP.add(femaleB);

		JPanel telP = new JPanel(); // 연락처
		telP.setBackground(new Color(255, 245, 245));
		telP.add(telL);
		telP.add(telC);
		telP.add(new Label("-"));
		telP.add(tel2T);
		telP.add(new Label("-"));
		telP.add(tel3T);

		JPanel birthP = new JPanel(); // 생일
		birthP.setBackground(new Color(255, 245, 245));
		birthP.add(birthL);
		birthP.add(yearT);
		birthP.add(monthC);
		birthP.add(dayC);

		JPanel mailP = new JPanel(); // 이메일
		mailP.setBackground(new Color(255, 245, 245));
		mailP.add(mailL);
		mailP.add(mailT);
		mailP.add(mail2T);
		mailP.add(mailC);

		JPanel buttonP = new JPanel();
		buttonP.setBackground(new Color(255, 245, 245));
		buttonP.add(okB);
		buttonP.add(cancelB);

		setLayout(null);

		infoP.setBounds(150, 22, 80, 20);
		nameP.setBounds(15, 55, 180, 30);
		genderP.setBounds(23, 85, 180, 30);
		birthP.setBounds(5, 115, 250, 30);
		telP.setBounds(4, 145, 300, 30);
		mailP.setBounds(5, 175, 350, 30);
		buttonP.setBounds(30, 215, 250, 50);

		Container c = this.getContentPane();
		c.setBackground(new Color(255, 245, 245));
		c.add(infoP);
		c.add(nameP);
		c.add(birthP);
		c.add(telP);
		c.add(genderP);
		c.add(birthP);
		c.add(mailP);
		c.add(buttonP);

		setBounds(700, 200, 380, 290);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cancelB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelB)
			System.exit(0);

	}

	public static void main(String[] args) {
		new InputInfo_Frame();
	}
}
