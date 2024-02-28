package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAudiencePojo {
	private boolean success;
	private List<GetAudiencePojoData> data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<GetAudiencePojoData> getData() {
		return data;
	}

	public void setData(List<GetAudiencePojoData> data) {
		this.data = data;
	}

}
