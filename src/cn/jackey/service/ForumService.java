package cn.jackey.service;

public class ForumService {
	
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public void addForum(){
		System.out.println("Ìí¼ÓÂÛÌ³¼ÇÂ¼");
		userService.addUser();
	}

}
