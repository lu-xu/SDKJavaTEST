package sdk;

public class UploadUtilNative {

	public static native String jni_Init(String strJsonData);
	
	public static native String jni_UploadInParkOrder(String strJsonData);
	
	public static native String jni_UploadOutParkOrder(String strJsonData);
	
	public static native String jni_GetPayStatus(String strJsonData);
	
	public static native void jni_SetInterfacePark(InterfacePark interfacePark);
	
	public static native String jni_UploadData(String strJsonData);
}
