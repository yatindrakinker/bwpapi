package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductsPojoDataRowsItems {
	private String shop_id;
	private String source_product_id;
	private String title;
	private String sku;
	private int quantity;
	private float price;
	private String main_image;
	private String target_marketplace;
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getSource_product_id() {
		return source_product_id;
	}
	public void setSource_product_id(String source_product_id) {
		this.source_product_id = source_product_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public String getTarget_marketplace() {
		return target_marketplace;
	}
	public void setTarget_marketplace(String target_marketplace) {
		this.target_marketplace = target_marketplace;
	}
	
	
}
