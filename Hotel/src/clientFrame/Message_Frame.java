package clientFrame;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

import javax.swing.*;
public class Message_Frame extends JFrame implements ActionListener, Runnable{
	private JButton sendB;
	private JTextArea output;
	private JTextField input;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public Message_Frame() {
		setTitle("채팅창");
		
		output = new JTextArea();
		input = new JTextField();
		sendB = new JButton("보내기");
		
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);	
		
		Panel p = new Panel();
		p.setLayout(new BorderLayout());			
		p.add("Center",input);
		p.add("East",sendB);
		
		Container c = this.getContentPane();
		c.add("Center",scroll);
		c.add("South",p);
		
		setBounds(1300, 500, 250, 350);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				//서버가 응답 전까지는 절대 종료해서는 안된다.
				if(oos==null || ois ==null)
					System.exit(0);
				try{
					InfoDTO dto = new InfoDTO();
					dto.setCommand(Info.QUIT);
					oos.writeObject(dto);
					oos.flush();
				}catch(IOException f){
					f.printStackTrace();
				}
				
			}
		});

	}//ChatClient();
	
	public void service(){		//서버 IP를 입력받는 다이얼로그
		
		/*
		String serverIP = JOptionPane.showInputDialog(this,				//IP값을 입력받기위해 String으로 잡았다.
					"서버 IP를 입력하세요",
					"서버IP",
					JOptionPane.INFORMATION_MESSAGE);
					*/
		String serverIp = JOptionPane.showInputDialog(this,"서버IP를 입력하세요","192.168.0.21");
		if(serverIp==null || serverIp.length()==0){
			System.out.println("서버IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		//닉네임
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요",
													"닉네임",JOptionPane.INFORMATION_MESSAGE);
		if(nickName==null || nickName.length()==0){
			nickName="Guest";
		}
	
		try{
			//소켓
			socket = new Socket(serverIp,9500);
			
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
			
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			oos.writeObject(dto);
			oos.flush();
			
	
		}catch(UnknownHostException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
			}

		Thread t = new Thread(this);
		t.start();

		sendB.addActionListener(this);
		input.addActionListener(this);
	}
	@Override
	public void run(){
		//받는쪽
		InfoDTO dto = null;
		while(true){
			try{
				dto = (InfoDTO)ois.readObject();		//캐스팅 걸어줘야함
				if(dto.getCommand()==Info.QUIT){	//dto.Command가 QUIT일 때
					oos.close();											
					ois.close();
					socket.close();
					System.exit(0);
				}
				output.append(dto.getMsg()+"\n");		//output에 dto.getMsg()에서 읽은 걸 차례대로 뿌려라
				
				int pos = output.getText().length();
				output.setCaretPosition(pos);		//스크롤바가 저절로 내려가는 명령어
			}catch(IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException f){
				f.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		//보내는쪽
		String msg = input.getText();		//input에서 쓴 내용을 꺼내서 String형으로 msg에 담았다
		InfoDTO dto = new InfoDTO();
		if(msg.toLowerCase().equals("quit")){
			dto.setCommand(Info.QUIT);
		}else{
			dto.setCommand(Info.SEND);
			dto.setMsg(msg);
		}
		try{
			oos.writeObject(dto);
			oos.flush();
		}catch(IOException f){
			f.printStackTrace();
		}
		
		input.setText("");					//input에 쓴 내용을 초기화
		
	}

	public static void main(String[] args){
		new Message_Frame().service();
	}
}