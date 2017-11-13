package sdk;

public class Environment {
//	static {
//		Environment.LoadDll();
//	}
	
	private static boolean isWrapJLoaded = false;
	
	/**
	 * 调入JNI动态库
	 */
	public static void LoadDll() {
		if (!isWrapJLoaded) {

			try {
//				//modify by xuzw 2011-04-26 Button会判断GraphicsEnvironment.isHeadless()，一旦用户启用
//				//System.setProperty("java.awt.headless", "true");就会抛出异常，用Canvas一样可以加载java.awt.Component
//				new Canvas();
//				//release使用
				
				try{
					System.loadLibrary("JavaCpp");
				}
				catch(Exception e){
				}
				catch(Error e){ // 加载动态库失败返回的是Error
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
