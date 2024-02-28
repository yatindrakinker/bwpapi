package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCustomAudiencePojo {

	
	private CreateCustomAudiencePojoAudience audience;

	public CreateCustomAudiencePojoAudience getAudience() {
		return audience;
	}

	public void setAudience(CreateCustomAudiencePojoAudience audience) {
		this.audience = audience;
	}
	
	

}
