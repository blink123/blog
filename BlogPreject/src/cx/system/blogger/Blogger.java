package cx.system.blogger;

public class Blogger extends User{

	private int likenumber;
	private int rewardnumber;
	private String headpicture;
	private String time;
	
	public Blogger() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Blogger(String name, String password,int likenumber,int rewardnumber,String headpicture,String time) {
		super(name, password);
		this.likenumber = likenumber;
		this.rewardnumber = rewardnumber;
		this.headpicture = headpicture;
		this.time = time;
		// TODO Auto-generated constructor stub
	}
	
	public String getHeadpicture() {
		return headpicture;
	}

	public void setHeadpicture(String headpicture) {
		this.headpicture = headpicture;
	}

	public String getDatetime() {
		return time;
	}

	public void setDatetime(String datetime) {
		this.time = datetime;
	}

	public int getLikeNumber() {
		return likenumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likenumber = likeNumber;
	}

	public int getRewardNumber() {
		return rewardnumber;
	}

	public void setRewardNumber(int rewardNumber) {
		this.rewardnumber = rewardNumber;
	}

	public void releaseArticle()
	{}
	
	public void updateArticle()
	{}
	
	public void deleteArticle()
	{}
	
	public void lookupArticle()
	{}
	
	public void classiffyArticle()
	{}
	
	public void releaseComment()
	{}
	
	public void updateComment()
	{}
	
	public void deleteComment()
	{}
	
	public void replyComment()
	{}
	
	public void leavingMessage()
	{}
	
	public void replyMessage()
	{}
	
	public void deleteMessage()
	{}
	
	public void updateMessage()
	{}
	
	public void sendPrivateLetter()
	{}
	
	public void lookupPrivateLetter()
	{}
	
	public void deletePrivateLetter()
	{}
	
	public void payAttention()
	{}
	
	public void cancelAttention()
	{}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println(name + " " + password + " " + likenumber + " " + rewardnumber + " " + headpicture + " " + time + " ");
	}
}
