package pojo;

public class GetRefineProductsPojoDataQuery {

	private GetRefineProductsPojoDataQueryMatch $match;
	private String $skip;
	private String $limit;

	public GetRefineProductsPojoDataQueryMatch get$match() {
		return $match;
	}

	public void set$match(GetRefineProductsPojoDataQueryMatch $match) {
		this.$match = $match;
	}

	public String get$skip() {
		return $skip;
	}

	public void set$skip(String $skip) {
		this.$skip = $skip;
	}

	public String get$limit() {
		return $limit;
	}

	public void set$limit(String $limit) {
		this.$limit = $limit;
	}

}
