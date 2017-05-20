package liujiawei.userdirmgr;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sun.xml.internal.ws.api.message.AddressingUtils;

public class UserDirMgr {

	//配置文件名称
	public static final String propFileName="userdir.properties";
	//需要读取的用户目录属性的名称
	public static final String userDirPropName="userdir";
	
	//用户头像文件夹
	public static final String userHeadPictureDir="headpicture";
	
	//用户文章图片存放目录
	public static final String userArticalPictureDir="articalPicture";
	
	/*
	 * 获取用户目录
	 */
	public static String getUserDir() {
		String result = "";
		InputStream inputStream=UserDirMgr.class.getClassLoader().getResourceAsStream(propFileName);
		Properties properties=new Properties();
		try{
			properties.load(inputStream);
			result=properties.getProperty(userDirPropName);
		}catch (IOException e){
			System.out.println("读取配置文件出错");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 为新用户创建目录
	 */
	public static boolean addUserDir(String username) {
		return addDir(username)&&addDir(username+"/"+userHeadPictureDir)&&addDir(username+"/"+userArticalPictureDir);
	}
	
	/*
	 * 为新用户创建目录
	 */
	static boolean addDir(String username) {
		String destDirName=getUserDir()+username;
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		//创建目录
		if(dir.mkdirs()){
			System.out.println("创建目录"+destDirName+"成功");
			return true;
		}else {
			System.out.println("创建目录"+destDirName+"失败");
			return false;
		}
	}

	/*
	 * 为注销的用户删除目录
	 */
	public void deletUserDir(String username) {

	}

	/*
	 * 为改名的用户修改目录
	 */
	public void updateUserDir() {

	}
	
	public  static void main(String[] args) {
		
		addUserDir("刘佳伟");
		
	}
	
}
