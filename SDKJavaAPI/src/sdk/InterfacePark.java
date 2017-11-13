package sdk;

public abstract class InterfacePark {

	/**
	*  @brief  ���շ���˷��͸�ͣ��������Ϣ
	*  @param  [IN] msg	���͸�ͣ������Json��ʽ�ַ���
	*/
	public abstract void receive(String msg);
	
	static void callBack(InterfacePark park, String msg){
		 park.receive(msg);
	}
	
	protected InterfacePark(){
		
	}
	
}
