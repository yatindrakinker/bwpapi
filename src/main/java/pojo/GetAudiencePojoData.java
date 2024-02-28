package pojo;

import java.util.List;

public class GetAudiencePojoData {

	private String id;
	private String name;
	private String type;
	private int audience_size_lower_bound;
	private int audience_size_upper_bound;
	private List<String> path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAudience_size_lower_bound() {
		return audience_size_lower_bound;
	}

	public void setAudience_size_lower_bound(int audience_size_lower_bound) {
		this.audience_size_lower_bound = audience_size_lower_bound;
	}

	public int getAudience_size_upper_bound() {
		return audience_size_upper_bound;
	}

	public void setAudience_size_upper_bound(int audience_size_upper_bound) {
		this.audience_size_upper_bound = audience_size_upper_bound;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

}
