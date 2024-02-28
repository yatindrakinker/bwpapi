package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountPixelPojo {
	
	private List<GetAccountPixelPojoData> data;

	public List<GetAccountPixelPojoData> getData() {
		return data;
	}

	public void setData(List<GetAccountPixelPojoData> data) {
		this.data = data;
	}
	

}
