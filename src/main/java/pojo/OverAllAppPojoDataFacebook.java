package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojoDataFacebook {

	private String code;
	private String title;
	private String description;
	private List<OverAllAppPojoDataFacebookInstalled> installed;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<OverAllAppPojoDataFacebookInstalled> getInstalled() {
		return installed;
	}
	public void setInstalled(List<OverAllAppPojoDataFacebookInstalled> installed) {
		this.installed = installed;
	}
	
}
