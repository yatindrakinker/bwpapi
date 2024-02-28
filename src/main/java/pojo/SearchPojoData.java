package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPojoData {
	
	private SearchPojoDataMeta meta;

	public SearchPojoDataMeta getMeta() {
		return meta;
	}

	public void setMeta(SearchPojoDataMeta meta) {
		this.meta = meta;
	}
	

}
