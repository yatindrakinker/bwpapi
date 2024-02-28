package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojoDataFacebookInstalled {
	private String _id;
	private String fb_user_id;
	private String group_code;
	private String shop_status;
	private String marketplace;
	private OverAllAppPojoDataFacebookInstalledData data;
	private List<OverAllAppPojoDataFacebookInstalledSources> sources;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFb_user_id() {
		return fb_user_id;
	}
	public void setFb_user_id(String fb_user_id) {
		this.fb_user_id = fb_user_id;
	}
	public String getGroup_code() {
		return group_code;
	}
	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	public String getShop_status() {
		return shop_status;
	}
	public void setShop_status(String shop_status) {
		this.shop_status = shop_status;
	}
	public String getMarketplace() {
		return marketplace;
	}
	public void setMarketplace(String marketplace) {
		this.marketplace = marketplace;
	}
	
	public OverAllAppPojoDataFacebookInstalledData getData() {
		return data;
	}
	public void setData(OverAllAppPojoDataFacebookInstalledData data) {
		this.data = data;
	}
	public List<OverAllAppPojoDataFacebookInstalledSources> getSources() {
		return sources;
	}
	public void setSources(List<OverAllAppPojoDataFacebookInstalledSources> sources) {
		this.sources = sources;
	}

}
