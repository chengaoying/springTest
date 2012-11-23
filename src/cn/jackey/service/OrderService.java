package cn.jackey.service;

public class OrderService {
	
	private ForumService forumService;

	public ForumService getForumService() {
		return forumService;
	}

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public void save(){
		System.out.println("save order");
		forumService.addForum();
		System.out.println("½áÊø");
	}
}
