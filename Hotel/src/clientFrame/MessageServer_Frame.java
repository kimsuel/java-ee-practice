package clientFrame;

import java.io.*;
import java.net.*;
import java.util.*;

class MessageServer_Frame {
	private ServerSocket ss;
	private ArrayList<MessageHandler_Frame> list;

	public MessageServer_Frame(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("서버준비완료..");

			list = new ArrayList<MessageHandler_Frame>();

			while(true){
				Socket socket = ss.accept();

				MessageHandler_Frame handler = new MessageHandler_Frame(socket, list);//스레드 생성
				handler.start();//스레드 시작

				list.add(handler);
			}//while
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MessageServer_Frame();
	}
}
