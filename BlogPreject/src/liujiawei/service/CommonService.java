package liujiawei.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonService {
	
	/*
	 * 获取当前时间
	 */
	public static String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String ctime = df.format(new Date());// new Date()为获取当前系统时间
		return ctime;
	}
	
}
