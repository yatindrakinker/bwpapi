package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPojoDataMeta {
	
	private SearchPojoDataMetaCampaign campaign;
	private SearchPojoDataMetaProduct product;
	private SearchPojoDataMetaAccount account;
	private SearchPojoDataMetaGeneral general;
	public SearchPojoDataMetaCampaign getCampaign() {
		return campaign;
	}
	public void setCampaign(SearchPojoDataMetaCampaign campaign) {
		this.campaign = campaign;
	}
	public SearchPojoDataMetaProduct getProduct() {
		return product;
	}
	public void setProduct(SearchPojoDataMetaProduct product) {
		this.product = product;
	}
	public SearchPojoDataMetaAccount getAccount() {
		return account;
	}
	public void setAccount(SearchPojoDataMetaAccount account) {
		this.account = account;
	}
	public SearchPojoDataMetaGeneral getGeneral() {
		return general;
	}
	public void setGeneral(SearchPojoDataMetaGeneral general) {
		this.general = general;
	}
	

}
