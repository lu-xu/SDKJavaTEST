package sdk;

public abstract class InterfacePark {

	/**
	*  @brief  接收服务端发送给停车场的消息
	*  @param  [IN] msg	发送给停车场的Json格式字符串
	*/
	public abstract void receive(String msg);
	
	static void callBack(InterfacePark park, String msg){
		 park.receive(msg);
	}
	
	protected InterfacePark(){
		
	}
	
}
