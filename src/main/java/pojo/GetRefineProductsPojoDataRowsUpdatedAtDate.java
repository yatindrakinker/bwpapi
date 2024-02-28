package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductsPojoDataRowsUpdatedAtDate {

	private String $numberLong;

	public String get$numberLong() {
		return $numberLong;
	}

	public void set$numberLong(String $numberLong) {
		this.$numberLong = $numberLong;
	}
	
}
