package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OverAllAppPojoData {

	private OverAllAppPojoDataOnyx onyx;
	private OverAllAppPojoDataFacebook meta;

	public OverAllAppPojoDataOnyx getOnyx() {
		return onyx;
	}

	public void setOnyx(OverAllAppPojoDataOnyx onyx) {
		this.onyx = onyx;
	}

	public OverAllAppPojoDataFacebook getMeta() {
		return meta;
	}

	public void setMeta(OverAllAppPojoDataFacebook meta) {
		this.meta = meta;
	}

}
