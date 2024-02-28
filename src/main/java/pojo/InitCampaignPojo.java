package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InitCampaignPojo {

	private InitCampaignData data;
	private List<String> error;

	

	public InitCampaignData getData() {
		return data;
	}

	public void setData(InitCampaignData data) {
		this.data = data;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}
}
