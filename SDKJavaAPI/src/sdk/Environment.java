package sdk;

public class Environment {
//	static {
//		Environment.LoadDll();
//	}
	
	private static boolean isWrapJLoaded = false;
	
	/**
	 * ����JNI��̬��
	 */
	public static void LoadDll() {
		if (!isWrapJLoaded) {

			try {
//				//modify by xuzw 2011-04-26 Button���ж�GraphicsEnvironment.isHeadless()��һ���û�����
//				//System.setProperty("java.awt.headless", "true");�ͻ��׳��쳣����Canvasһ�����Լ���java.awt.Component
//				new Canvas();
//				//releaseʹ��
				
				try{
					System.loadLibrary("JavaCpp");
				}
				catch(Exception e){
				}
				catch(Error e){ // ���ض�̬��ʧ�ܷ��ص���Error
				}
				isWrapJLoaded = true;
			} catch (java.lang.UnsatisfiedLinkError ex) {
				ex.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
