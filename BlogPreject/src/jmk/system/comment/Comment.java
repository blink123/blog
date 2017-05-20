package jmk.system.comment;

public class Comment extends MessageBase{
private String bloggerName;
private int articleNumber;

public Comment(){
	
}

public Comment(String content,String time,String sendBloggerName,String aimBloggerName,String bloggerName,
		int articleNumber){
	this.content=content;
	this.time=time;
	this.sendBloggerName=sendBloggerName;
	this.aimBloggerName=aimBloggerName;
	this.bloggerName=bloggerName;
	this.articleNumber=articleNumber;
}

public Comment(int number,String content,String time,String sendBloggerName,String aimBloggerName,String bloggerName,
		int articleNumber){
	this.number=number;
	this.content=content;
	this.time=time;
	this.sendBloggerName=sendBloggerName;
	this.aimBloggerName=aimBloggerName;
	this.bloggerName=bloggerName;
	this.articleNumber=articleNumber;
}
public Comment(String bloggerName,int articleNumber){
	this.bloggerName=bloggerName;
	this.articleNumber=articleNumber;
}

public String getBloggerName() {
	return bloggerName;
}
public void setBloggerName(String bloggerName) {
	this.bloggerName = bloggerName;
}
public int getArticleNumber() {
	return articleNumber;
}
public void setArticleNumber(int articleNumber) {
	this.articleNumber = articleNumber;
}
public void display() {
	System.out.println(number + " " + content + " " + time + " " + sendBloggerName + " " + aimBloggerName + " " + bloggerName + " "
			+ articleNumber + " ");

}
}
