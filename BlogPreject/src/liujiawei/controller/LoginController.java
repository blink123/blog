package liujiawei.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.Attributes;

import cx.system.blogger.Blogger;
import liujiawei.service.BlogAttrs;
import liujiawei.service.BloggerMgr;
import liujiawei.test.BlogTest;
/*http://localhost:8080/BlogPreject/blog/login.do?username=1&password=1
*/
@Controller
public class LoginController {
	@RequestMapping("login.do")
    public String login(HttpServletRequest request, String username,String password){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username.equals("admin")&&password.equals("admin")){
			return "adminview";
		}
		HttpSession session = request.getSession();
		Blogger blogger=BloggerMgr.getInstance().checkBlogger(username, password);
		if(blogger!=null){
			System.out.println(blogger.getName());
			session.setAttribute(BlogAttrs.ATTR_CURRENTBLOGGER, blogger);
		}
		return (String)session.getAttribute(BlogAttrs.ATTR_CURRENTVIEW);
    }
	
	@RequestMapping("toLogout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute(BlogAttrs.ATTR_CURRENTBLOGGER, null);
		return (String)session.getAttribute(BlogAttrs.ATTR_CURRENTVIEW);
	}
	
	@RequestMapping("regist.do")
	public String regist(HttpServletRequest request,String username,String password){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		System.out.println("name:"+username+"password"+password);
		Blogger blogger=BloggerMgr.getInstance().addBlogger(username, password);
		if(blogger!=null){
			session.setAttribute(BlogAttrs.ATTR_CURRENTBLOGGER, blogger);
		}else {
			session.setAttribute(BlogAttrs.ATTR_CURRENTBLOGGER, null);
		}
		return (String)session.getAttribute(BlogAttrs.ATTR_CURRENTVIEW);
	}
	
}
