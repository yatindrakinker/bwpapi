package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojo {
	
	private boolean success;
	private OverAllAppPojoData data;
	private String ip ;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public OverAllAppPojoData getData() {
		return data;
	}
	public void setData(OverAllAppPojoData data) {
		this.data = data;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	

}
