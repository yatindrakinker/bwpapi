package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductsPojo {

	private GetRefineProductsPojoData data;

	public GetRefineProductsPojoData getData() {
		return data;
	}

	public void setData(GetRefineProductsPojoData data) {
		this.data = data;
	}
	
}
