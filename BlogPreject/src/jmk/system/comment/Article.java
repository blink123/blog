package jmk.system.comment;

public class Article extends contentBase {
	private String title;
	private String type;
	private int readcount;
	private String bloggerName;

	public Article() {

	}

	public Article(String title, String type, int readcount, String bloggerName, String content,
			String time) {
		this.title = title;
		this.type = type;
		this.readcount = readcount;
		this.bloggerName = bloggerName;
		this.content = content;
		this.time = time;
	}
	
	public Article(String title, String type, int readcount, String bloggerName, int number, String content,
			String time) {
		this.title = title;
		this.type = type;
		this.readcount = readcount;
		this.bloggerName = bloggerName;
		this.number = number;
		this.content = content;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getReadCount() {
		return readcount;
	}

	public void setReadCount(int readCount) {
		this.readcount = readCount;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public void display() {
		System.out.println("����:" + title + "	" + "����:" + type + "	" + "�Ķ���:" + readcount + "		" + "����:"
				+ bloggerName + "		" + "���:" + number + "		" + "����:" + content + "		" + "ʱ��:" + time + "	");

	}
}
