package friend.action;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener, ListSelectionListener{
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;
	private JLabel x1L, x2L, x3L, x4L, x5L, x6L, x7L;
	private JTextField x1T, x2T, x3T;
	private JTextArea area;
	private JButton insertB, updateB, deleteB, clearB;
	private JCheckBox reading, movie, music, game, shopping;
	private JRadioButton man, woman;
	private JComboBox<String> combo;

	public FriendManager() {
		setTitle("개인정보");
		
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();

		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		x1T = new JTextField(10);
		x2T = new JTextField(4);
		x3T = new JTextField(4);

		x1L = new JLabel("이      름:");
		x2L = new JLabel("전화번호:");
		x3L = new JLabel("성      별:");
		x4L = new JLabel("취      미:");
		x5L = new JLabel("개인정보입력");
		x6L = new JLabel("전체목록");
		x7L = new JLabel("개인정보분석");

		insertB = new JButton("등록");
		updateB = new JButton("수정");
		deleteB = new JButton("삭제");
		clearB = new JButton("지우기");

		reading = new JCheckBox("독서");
		movie = new JCheckBox("영화");
		music = new JCheckBox("음악");
		game = new JCheckBox("게임");
		shopping = new JCheckBox("쇼핑");

		man = new JRadioButton("남성", true);
		woman = new JRadioButton("여성");

		String[] num = { "010", "011", "017", "019" };
		combo = new JComboBox<String>(num);

		JPanel p1 = new JPanel(); // 개인정보
		p1.setBackground(new Color(255, 200, 230));
		p1.add(x5L);

		JPanel p2 = new JPanel(); // 이름
		p2.setBackground(new Color(255, 200, 230));
		p2.add(x1L);
		p2.add(x1T);

		JPanel p3 = new JPanel(); // 성별
		p3.setBackground(new Color(255, 200, 230));
		ButtonGroup bg = new ButtonGroup();
		man.setBackground(new Color(255, 200, 230));
		woman.setBackground(new Color(255, 200, 230));
		bg.add(man);
		bg.add(woman);

		p3.add(x3L);
		p3.add(man);
		p3.add(woman);

		JPanel p4 = new JPanel(); // 취미
		p4.setBackground(new Color(255, 200, 230));
		p4.add(x4L);
		p4.add(reading);
		reading.setBackground(new Color(255, 200, 230));
		p4.add(movie);
		movie.setBackground(new Color(255, 200, 230));
		p4.add(music);
		music.setBackground(new Color(255, 200, 230));
		p4.add(game);
		game.setBackground(new Color(255, 200, 230));
		p4.add(shopping);
		shopping.setBackground(new Color(255, 200, 230));

		JPanel p5 = new JPanel(); // 버튼
		p5.setBackground(new Color(255, 200, 230));
		p5.add(insertB);
		p5.add(updateB);
		p5.add(deleteB);
		p5.add(clearB);

		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);

		JPanel p6 = new JPanel(); // 전화번호
		p6.setBackground(new Color(255, 200, 230));
		p6.add(x2L);
		p6.add(combo);
		p6.add(new Label("-"));
		p6.add(x2T);
		p6.add(new Label("-"));
		p6.add(x3T);

		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 리스트
		p7.setBackground(new Color(255, 255, 255));
		p7.add(list);

		JPanel p8 = new JPanel(); // 개인정보분석
		p8.setBackground(new Color(255, 200, 230));
		p8.add(x7L);

		JPanel p10 = new JPanel(); // 전체목록
		p10.setBackground(new Color(255, 200, 230));
		p10.add(x6L);

		scroll.setBounds(30, 350, 500, 100);
		p1.setBounds(130, 13, 80, 35);
		p2.setBounds(10, 50, 200, 30);
		p6.setBounds(9, 100, 300, 40);
		p3.setBounds(0, 150, 220, 40);
		p4.setBounds(4, 200, 380, 40);
		p5.setBounds(40, 250, 300, 40);
		p8.setBounds(90, 310, 300, 30);
		p10.setBounds(400, 13, 73, 37);
		p7.setBounds(380, 70, 145, 230);
		
		setLayout(null);
		Container c = this.getContentPane();
		c.setBackground(new Color(255, 200, 230));
		c.add(p7);
		c.add(scroll);
		c.add(p1);
		c.add(p2);
		c.add(p6);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p8);
		c.add(p10);

		setBounds(700, 200, 550, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//DB의 모든 레코드를 꺼내서  JList에 뿌리기
		getFriendList();
		
	}//FriendManager()
	
	public void getFriendList() {
		FriendDAO dao = FriendDAO.getInstance();
		ArrayList<FriendDTO> list = dao.getFriendList();
		for(FriendDTO dto : list) {
			model.addElement(dto);
		}
	}

	public void event() {
		insertB.addActionListener(this);//등록
		updateB.addActionListener(this);//수정
		deleteB.addActionListener(this);//삭제
		clearB.addActionListener(this);//지우기
		
		list.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insertB) {//등록
			//데이터
			String name = x1T.getText();
			String tel1 = (String)combo.getSelectedItem();
			String tel2 = x2T.getText();
			String tel3 = x3T.getText();
			
			int gender=0;
			if(man.isSelected()) gender=0;
			else if(woman.isSelected()) gender=1;
			
			int read = reading.isSelected() ? 1 : 0;
			int movie = this.movie.isSelected() ? 1 : 0;
			int music = this.music.isSelected() ? 1 : 0;
			int game = this.game.isSelected() ? 1 : 0;
			int shopping = this.shopping.isSelected() ? 1 : 0;
			
			FriendDTO dto = new FriendDTO();
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setGender(gender);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);
			
			//DB-insert
			FriendDAO dao = FriendDAO.getInstance();
			
			int seq = dao.getSeq();
			dto.setSeq(seq);
			 
			int su = dao.friendInsert(dto);
			
			//응답
			clear();
			area.setText("\n\t\t"+su+"개의 데이터를 저장하였습니다");
			model.addElement(dto);
									
		}else if(e.getSource()==updateB) {
			
			int seq = list.getSelectedValue().getSeq();
			String name = x1T.getText();
			String tel1 = (String)combo.getSelectedItem();
			String tel2 = x2T.getText();
			String tel3 = x3T.getText();
			
			int gender=0;
			if(man.isSelected()) gender=0;
			else if(woman.isSelected()) gender=1;
			
			int read = reading.isSelected() ? 1 : 0;
			int movie = this.movie.isSelected() ? 1 : 0;
			int music = this.music.isSelected() ? 1 : 0;
			int game = this.game.isSelected() ? 1 : 0;
			int shopping = this.shopping.isSelected() ? 1 : 0;
			
			FriendDTO dto = new FriendDTO();
			dto.setSeq(seq);
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setGender(gender);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);
			
			//DB
			FriendDAO dao = FriendDAO.getInstance();
			int su = dao.friendUpdate(dto);
			//응답
			area.setText("\n\t\t"+su+"개의 데이터를 수정하였습니다");
			model.set(list.getSelectedIndex(), dto);
		}else if(e.getSource()==deleteB) {
			
			int seq = list.getSelectedValue().getSeq();
			
			//DB
			FriendDAO dao = FriendDAO.getInstance();
			int su = dao.friendDelete(seq);
			
			//응답
			area.setText("\n\t\t"+su+"개의 데이터를 삭제하였습니다");
			model.remove(list.getSelectedIndex());
			
		}else if(e.getSource()==clearB) {
			clear();
		}
		
	}
	
	public void clear() {
		x1T.setText("");
		combo.setSelectedItem("010");
		x2T.setText("");
		x3T.setText("");
		man.setSelected(true);
		reading.setSelected(false);
		movie.setSelected(false);
		music.setSelected(false);
		game.setSelected(false);
		shopping.setSelected(false);
		area.setText("");
		
		insertB.setEnabled(true);
		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(list.getSelectedIndex()==-1) return;
		
		FriendDTO dto = list.getSelectedValue();
		x1T.setText(dto.getName());
		combo.setSelectedItem(dto.getTel1());
		x2T.setText(dto.getTel2());
		x3T.setText(dto.getTel3());
		if(dto.getGender()==0)
			man.setSelected(true);
		else if(dto.getGender()==1)
			woman.setSelected(true);
		
		reading.setSelected(dto.getRead()==1 ? true : false);
		movie.setSelected(dto.getMovie()==1 ? true : false);
		music.setSelected(dto.getMusic()==1 ? true : false);
		game.setSelected(dto.getGame()==1 ? true : false);
		shopping.setSelected(dto.getShopping()==1 ? true : false);
		
		area.setText("");
		
		insertB.setEnabled(false);
		updateB.setEnabled(true);
		deleteB.setEnabled(true);
		clearB.setEnabled(true);
		
		
	}

	public static void main(String[] args) {
		new FriendManager().event();

	}

}









