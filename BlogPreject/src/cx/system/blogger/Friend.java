package cx.system.blogger;

public class Friend{
	public Friend() {
		// TODO Auto-generated constructor stub
	}
	public Friend(String bloggername, String friendname) {
		// TODO Auto-generated constructor stub
		this.bloggername = bloggername;
		this.friendname = friendname;
	}
	public String getBloggername() {
		return bloggername;
	}
	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public void display()
	{
		System.out.println(bloggername + " " + friendname);
	}
	
	private String bloggername;
	private String friendname;
}
