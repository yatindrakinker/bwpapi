package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPojoDataMetaProduct {

	private String next_page;
	private String group_name;
	private List<SearchPojoDataMetaProductData> data;
	public String getNext_page() {
		return next_page;
	}
	public void setNext_page(String next_page) {
		this.next_page = next_page;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public List<SearchPojoDataMetaProductData> getData() {
		return data;
	}
	public void setData(List<SearchPojoDataMetaProductData> data) {
		this.data = data;
	}
	

}
