package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserPojoData {

	private CreateUserPojoDataUser user;
	private List<CreateUserPojoDataConfig> config;

	public CreateUserPojoDataUser getUser() {
		return user;
	}

	public void setUser(CreateUserPojoDataUser user) {
		this.user = user;
	}

	public List<CreateUserPojoDataConfig> getConfig() {
		return config;
	}

	public void setConfig(List<CreateUserPojoDataConfig> config) {
		this.config = config;
	}

}
