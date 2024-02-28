package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetConfigPojo {
	
//	{
//	    "success": true,
//	    "data": [
//	        {
//	            "group_code": "bwp-product",
//	            "value": {
//	                "brand": "Yatindra's"
//	            }
//	        }
//	    ],
//	    "ip": "103.61.74.178",
//	    "time_taken": "0.022"
//	}
	
	private List<GetConfigPojoData> data;

	public List<GetConfigPojoData> getData() {
		return data;
	}

	public void setData(List<GetConfigPojoData> data) {
		this.data = data;
	}
	

}
