package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojoDataOnyx {

	private String title;
	private String description;
	private List<OverAllAppPojoDataOnyxInstalled> installed;
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
	public List<OverAllAppPojoDataOnyxInstalled> getInstalled() {
		return installed;
	}
	public void setInstalled(List<OverAllAppPojoDataOnyxInstalled> installed) {
		this.installed = installed;
	}
	
	
}
