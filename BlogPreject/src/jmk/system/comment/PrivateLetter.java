package jmk.system.comment;

public class PrivateLetter extends MessageBase{
	private int readflag;//1Ϊ���ԣ�������0Ϊ˽�ţ�������
	
	public PrivateLetter(){
		
	}

	public int getReadflag() {
		return readflag;
	}

	public void setReadflag(int readflag) {
		this.readflag = readflag;
	}

	public PrivateLetter(String content,String time,String sendBloggerName,String aimBloggerName,int readflag){
		this.content=content;
		this.time=time;
		this.sendBloggerName=sendBloggerName;
		this.aimBloggerName=aimBloggerName;
		this.readflag=readflag;
	}

	
	public PrivateLetter(int number,String content,String time,String sendBloggerName,String aimBloggerName,int readflag){
		this.number=number;
		this.content=content;
		this.time=time;
		this.sendBloggerName=sendBloggerName;
		this.aimBloggerName=aimBloggerName;
		this.readflag=readflag;
	}


	public void display() {
		System.out.println(number + " " + content + " " + time + " " + sendBloggerName + " " 
	+ aimBloggerName + " " + readflag + " ");

	}
}
