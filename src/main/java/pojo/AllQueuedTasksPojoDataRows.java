package pojo;

public class AllQueuedTasksPojoDataRows {
	
	private AllQueuedTasksPojoDataRows_ID _id;
	private String user_id;
	private String shop_id;
	private String marketplace;
	private String appTag;
	private String process_code;
	private int progress;
	private String created_at;
	private AllQueuedTasksPojoDataRowsAdditionalData additional_data;
	private String message;
	private String tag;
	private String updated_at;
	public AllQueuedTasksPojoDataRows_ID get_id() {
		return _id;
	}
	public void set_id(AllQueuedTasksPojoDataRows_ID _id) {
		this._id = _id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getMarketplace() {
		return marketplace;
	}
	public void setMarketplace(String marketplace) {
		this.marketplace = marketplace;
	}
	public String getAppTag() {
		return appTag;
	}
	public void setAppTag(String appTag) {
		this.appTag = appTag;
	}
	public String getProcess_code() {
		return process_code;
	}
	public void setProcess_code(String process_code) {
		this.process_code = process_code;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public AllQueuedTasksPojoDataRowsAdditionalData getAdditional_data() {
		return additional_data;
	}
	public void setAdditional_data(AllQueuedTasksPojoDataRowsAdditionalData additional_data) {
		this.additional_data = additional_data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
