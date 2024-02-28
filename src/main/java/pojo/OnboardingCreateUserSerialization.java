package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OnboardingCreateUserSerialization {

	public String target_marketplace;
	public DataPojo data;

	public String getTarget_marketplace() {
		return target_marketplace;
	}

	public void setTarget_marketplace(String target_marketplace) {
		this.target_marketplace = target_marketplace;
	}

	public DataPojo getData() {
		return data;
	}

	public void setData(DataPojo data) {
		this.data = data;
	}

}
