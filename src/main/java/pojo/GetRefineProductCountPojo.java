package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductCountPojo {


	private String success;
	private List<GetRefineProductCountPojoQuery> query;
	private GetRefineProductCountPojoData data;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<GetRefineProductCountPojoQuery> getQuery() {
		return query;
	}

	public void setQuery(List<GetRefineProductCountPojoQuery> query) {
		this.query = query;
	}

	public GetRefineProductCountPojoData getData() {
		return data;
	}

	public void setData(GetRefineProductCountPojoData data) {
		this.data = data;
	}

	
}
