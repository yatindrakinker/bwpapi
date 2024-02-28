package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverAllAppPojoDataFacebookInstalledData {
	private String pixel_id;
	private String ad_account_id;
	private String page_name;
	private String user_name;
	private String catalog_id;
	private String product_set_id;
	private String account_status;
	private String account_name;
	private boolean payment_setup;
	private boolean catalog_connected;
	private boolean tos_accepted;
	public String getPixel_id() {
		return pixel_id;
	}
	public void setPixel_id(String pixel_id) {
		this.pixel_id = pixel_id;
	}
	public String getAd_account_id() {
		return ad_account_id;
	}
	public void setAd_account_id(String ad_account_id) {
		this.ad_account_id = ad_account_id;
	}
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getProduct_set_id() {
		return product_set_id;
	}
	public void setProduct_set_id(String product_set_id) {
		this.product_set_id = product_set_id;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public boolean isPayment_setup() {
		return payment_setup;
	}
	public void setPayment_setup(boolean payment_setup) {
		this.payment_setup = payment_setup;
	}
	public boolean isCatalog_connected() {
		return catalog_connected;
	}
	public void setCatalog_connected(boolean catalog_connected) {
		this.catalog_connected = catalog_connected;
	}
	public boolean isTos_accepted() {
		return tos_accepted;
	}
	public void setTos_accepted(boolean tos_accepted) {
		this.tos_accepted = tos_accepted;
	}
	
	
}
