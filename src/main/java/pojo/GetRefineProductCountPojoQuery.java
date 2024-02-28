package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductCountPojoQuery {

	private GetRefineProductCountPojoQueryMatch $match;

	public GetRefineProductCountPojoQueryMatch get$match() {
		return $match;
	}

	public void set$match(GetRefineProductCountPojoQueryMatch $match) {
		this.$match = $match;
	}
	
}
