package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserPojo {

	private String target_marketplace;
	private CreateUserPojoData data;

	public String getTarget_marketplace() {
		return target_marketplace;
	}

	public void setTarget_marketplace(String target_marketplace) {
		this.target_marketplace = target_marketplace;
	}

	public CreateUserPojoData getData() {
		return data;
	}

	public void setData(CreateUserPojoData data) {
		this.data = data;
	}

}
