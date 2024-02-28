package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetConfigPojoData {

	private String group_code;
	private GetConfigPojoDataValue value;
	public String getGroup_code() {
		return group_code;
	}
	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	public GetConfigPojoDataValue getValue() {
		return value;
	}
	public void setValue(GetConfigPojoDataValue value) {
		this.value = value;
	}
	
}
