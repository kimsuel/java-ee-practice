package clientFrame;

enum Info{
	JOIN, QUIT , SEND
}

class InfoDTO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickName;
	private String msg;
	private Info command;

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public void setCommand(Info command){
		this.command = command;
	}

	public String getNickName(){
		return nickName;
	}

	public String getMsg(){
		return msg;
	}

	public Info getCommand(){
		return command;
	}


}



/*
BufferedReader	=>	 ObjectInputStream
PrintWriter	 =>		ObjectOutputStream

String이 아니라 InfoDTO 객체로 데이터 주고 받고 해라
readLine	>>	readObject()
println		>>	writeObject();
*/
