package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPojo {

	private SearchPojoData data;

	public SearchPojoData getData() {
		return data;
	}

	public void setData(SearchPojoData data) {
		this.data = data;
	}
	
	
}
