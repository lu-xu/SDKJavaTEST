package _Test.bean;

public class UpLoadWordRecord {
	/**
	 * uuid	�շ�Ա���°�Ψһ���	String	1234567	��
uid	�����շ�Աid	number	325101	��
end_time	�°�ʱ��	number	1490879218	��stateΪ1ʱ�ش���
start_time	�ϰ�ʱ��	number	1490876218	��stateΪ0ʱ�ش���
worksite_id	��������վid	number	325101	��
state	0��ǩ����1��ǩ��	number	0	��
	 */
	String uuid;
	int uid;
	long end_time;
	long start_time;
	int worksite_id;
	int state;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public long getStart_time() {
		return start_time;
	}
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	public int getWorksite_id() {
		return worksite_id;
	}
	public void setWorksite_id(int worksite_id) {
		this.worksite_id = worksite_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "WordRecordEntity [uuid=" + uuid + ", uid=" + uid + ", end_time=" + end_time + ", start_time="
				+ start_time + ", worksite_id=" + worksite_id + ", state=" + state + "]";
	}
	
}
