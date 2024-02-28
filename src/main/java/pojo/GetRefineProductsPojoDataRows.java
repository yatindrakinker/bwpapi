package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRefineProductsPojoDataRows {

	private GetRefineProductsPojoDataRowsId _id;
	private String container_id;
	private String source_product_id;
	private String source_shop_id;
	private String target_shop_id;
	private String user_id;
	private List<String> app_codes;
	private String brand;
	private int created_at;
	private List<GetRefineProductsPojoDataRowsItems> items;
	private String main_image;
	private String target_product_id;
	private String title;
	private String type;
	private int updated_at;
	private List<GetRefineProductsPojoDataRowsVariantAttributes> variant_attributes;
	private String tags;

	public GetRefineProductsPojoDataRowsId get_id() {
		return _id;
	}

	public void set_id(GetRefineProductsPojoDataRowsId _id) {
		this._id = _id;
	}

	public String getContainer_id() {
		return container_id;
	}

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	public String getSource_product_id() {
		return source_product_id;
	}

	public void setSource_product_id(String source_product_id) {
		this.source_product_id = source_product_id;
	}

	public String getSource_shop_id() {
		return source_shop_id;
	}

	public void setSource_shop_id(String source_shop_id) {
		this.source_shop_id = source_shop_id;
	}

	public String getTarget_shop_id() {
		return target_shop_id;
	}

	public void setTarget_shop_id(String target_shop_id) {
		this.target_shop_id = target_shop_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<String> getApp_codes() {
		return app_codes;
	}

	public void setApp_codes(List<String> app_codes) {
		this.app_codes = app_codes;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCreated_at() {
		return created_at;
	}

	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}

	public List<GetRefineProductsPojoDataRowsItems> getItems() {
		return items;
	}

	public void setItems(List<GetRefineProductsPojoDataRowsItems> items) {
		this.items = items;
	}

	public String getMain_image() {
		return main_image;
	}

	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}

	public String getTarget_product_id() {
		return target_product_id;
	}

	public void setTarget_product_id(String target_product_id) {
		this.target_product_id = target_product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(int updated_at) {
		this.updated_at = updated_at;
	}

	public List<GetRefineProductsPojoDataRowsVariantAttributes> getVariant_attributes() {
		return variant_attributes;
	}

	public void setVariant_attributes(List<GetRefineProductsPojoDataRowsVariantAttributes> variant_attributes) {
		this.variant_attributes = variant_attributes;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
