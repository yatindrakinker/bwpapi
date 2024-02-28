package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InitCampaignData {
	
	private int  products_count;
	private String pixel_id;
	private String ad_account_id;
	private String catalog_id;
	private String account_status;
	private String disable_reason;
	private String currency;
	private boolean payment_setup;
	private String account_name;
	private boolean is_instagram_connected;
	private String website_url;
	private String form_token;
	
	
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
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public boolean isPayment_setup() {
		return payment_setup;
	}
	public void setPayment_setup(boolean payment_setup) {
		this.payment_setup = payment_setup;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public boolean isIs_instagram_connected() {
		return is_instagram_connected;
	}
	public void setIs_instagram_connected(boolean is_instagram_connected) {
		this.is_instagram_connected = is_instagram_connected;
	}
	public String getWebsite_url() {
		return website_url;
	}
	public void setWebsite_url(String website_url) {
		this.website_url = website_url;
	}
	public int getProducts_count() {
		return products_count;
	}
	public void setProducts_count(int products_count) {
		this.products_count = products_count;
	}
	public String getDisable_reason() {
		return disable_reason;
	}
	public void setDisable_reason(String disable_reason) {
		this.disable_reason = disable_reason;
	}
	public String getForm_token() {
		return form_token;
	}
	public void setForm_token(String form_token) {
		this.form_token = form_token;
	}
	
	
}
