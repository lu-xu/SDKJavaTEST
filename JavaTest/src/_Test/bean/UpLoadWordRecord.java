package _Test.bean;

public class UpLoadWordRecord {
	/**
	 * uuid	收费员上下班唯一编号	String	1234567	是
uid	车场收费员id	number	325101	是
end_time	下班时间	number	1490879218	否（state为1时必传）
start_time	上班时间	number	1490876218	否（state为0时必传）
worksite_id	车场工作站id	number	325101	否
state	0已签到，1已签退	number	0	是
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
