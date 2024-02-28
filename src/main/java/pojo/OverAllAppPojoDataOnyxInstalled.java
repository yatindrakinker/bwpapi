package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojoDataOnyxInstalled {

	private String email;
	private String currency;
	private String marketplace;
	private String shop_status;
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	private List<OverAllAppPojoDataOnyxInstalledTargets> targets;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(String marketplace) {
		this.marketplace = marketplace;
	}

	public String getShop_status() {
		return shop_status;
	}

	public void setShop_status(String shop_status) {
		this.shop_status = shop_status;
	}

	public List<OverAllAppPojoDataOnyxInstalledTargets> getTargets() {
		return targets;
	}

	public void setTargets(List<OverAllAppPojoDataOnyxInstalledTargets> targets) {
		this.targets = targets;
	}

}
