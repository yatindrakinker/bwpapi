package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllQueuedTasksPojo {
	
		 private AllQueuedTasksPojoData data;

		public AllQueuedTasksPojoData getData() {
			return data;
		}

		public void setData(AllQueuedTasksPojoData data) {
			this.data = data;
		}

		
		 
		 

}
