package clientFrame;

import java.io.*;
import java.net.*;
import java.util.*;

class MessageHandler_Frame extends Thread{
	private Socket socket;
	private ArrayList<MessageHandler_Frame> list;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public MessageHandler_Frame(Socket socket ,ArrayList<MessageHandler_Frame> list){
	
		this.socket = socket;
		this.list = list;
		
		try{
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		String nickName = null;
		InfoDTO dto = null;
		try{
			while(true){
				dto = (InfoDTO)ois.readObject();

				if(dto.getCommand()==Info.JOIN){
					nickName = dto.getNickName();
					
					//서버는 모든 클라이언트에게 입장했다고 메세지 전달 해야 한다.
					InfoDTO	sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName+"님 입장하였습니다");
					broadcast(sendDTO);
				
				}else if(dto.getCommand()==Info.QUIT){
					list.remove(this);				//현재 자신을 제거한다.(ChatHandlerObject)
					//퇴장 메세지 보내기
					InfoDTO	sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName+"님 퇴장하였습니다.");
					broadcast(sendDTO);

					//나한테도 quit를 보내줘야 한다 같이 끊어줘야함
					sendDTO.setCommand(Info.QUIT);
					oos.writeObject(sendDTO);
					oos.flush();

					ois.close();
					oos.close();
					socket.close();
					break;

				}else if(dto.getCommand()==Info.SEND){
					InfoDTO	sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg("["+nickName+"]"+dto.getMsg());
					broadcast(sendDTO);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException f){
			f.printStackTrace();
		}

		
	}//run
		
	public void broadcast(InfoDTO sendDTO){
		try{
			for(MessageHandler_Frame handler : list){
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}	
}
