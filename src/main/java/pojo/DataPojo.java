package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPojo {
	private UserPojo user;
	private List<ConfigPojo> config;

	public UserPojo getUser() {
		return user;
	}

	public void setUser(UserPojo user) {
		this.user = user;
	}

	public List<ConfigPojo> getConfig() {
		return config;
	}

	public void setConfig(List<ConfigPojo> config) {
		this.config = config;
	}

}
