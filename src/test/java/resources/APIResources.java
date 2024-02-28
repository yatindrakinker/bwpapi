package resources;

public enum APIResources {

	isEmailExist("/onyx/user/isEmailExist"),
	otpMail("/user/otpMail"),
	onBoardingOTPSend("/user/otpMail"),
	onboardingCreateUser("/onyx/user/createUser"),
	loginAPI("/user/login"),
	overAllAppAll("/connector/get/all"),
	overallAllGetSteps("/connector/frontend/getStepCompleted"),
	campaignSyncAccountStatus("/meta/account/accountStatus"),
	createWebhook("/onyx/webhook/create"),
	initCampaign("/meta/campaign/initCampaign"),
	getCampaigns("/meta/campaign/getCampaigns"),
	allNotifications("/connector/get/allNotifications"),
	getRefineProductCount("/connector/product/getRefineProductCount"),
	getRefineProducts("/connector/product/getRefineProducts"),
	allQueuedTasks("/connector/get/allQueuedTasks"),
	getAccountPixels("/meta/account/getAccountPixels"),
	getConfig("/connector/config/getConfig"),
	getDisconnectedAccount("/meta/account/getDisconnectedAccount"),
	resetpassword("/core/user/resetpassword"),
	updatePixel("/meta/account/updatePixel"),
	createCustomAudience("/meta/account/createCustomAudience"),
	saveConfig("/connector/config/saveConfig"),
	search("/webapi/rest/v1/faq/search"),
	getAudience("/meta/campaign/getAudience"),
	publishCampaignAPI("/meta/campaign/publishCampaign");
	
	private String resource;
	
	APIResources (String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
	
}
