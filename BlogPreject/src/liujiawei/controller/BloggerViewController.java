package liujiawei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cx.system.blogger.Blogger;
import liujiawei.service.BlogAttrs;
import liujiawei.service.BloggerMgr;
import liujiawei.service.ContentMgr;

@Controller
public class BloggerViewController {
	
	@RequestMapping("toBloggerOwn.do")
    public String toBloggerOwn(HttpServletRequest request,String username){
		System.out.println(username+"--进入博主博文页--controller");
		HttpSession session=request.getSession(); 
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		if(currentBlogger.getPermission()==1)
		{
		session.setAttribute(BlogAttrs.ATTR_AIMBLOGGER, currentBlogger);	
		//是同一个用户，就把权限设为1	
		currentBlogger.setPermission(1);
		}
		return "bloggerOwnView";
    }
	
	@RequestMapping("toBloggerLeaveMSg.do")
    public String toBloggerLeaveMSg(String username){
		System.out.println(username+"--进入留言页--controller");
		return "leaveMessageView";
    }
	
	@RequestMapping("toBloggerHome.do")
    public String toBloggerHome(HttpServletRequest request, String username){
		System.out.println(username+"--进入朋友圈--controller");
		HttpSession session=request.getSession(); 
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		session.setAttribute(BlogAttrs.ATTR_AIMBLOGGER, currentBlogger);
		//博主访问自己的主页时权限为1
		currentBlogger.setPermission(1);
		return "bloggerMainView";
    }
	
	@RequestMapping("toAboutMe.do")
    public String toAboutMe(String username){
		System.out.println(username+"--进入关于我--controller");
		return "AboutMeView";
    }
	
	@RequestMapping("toOtherBlogger.do")
	public String toOtherBlogger(HttpServletRequest request,String aimblogger){		
		System.out.println("我进入了"+aimblogger+"的主页");
		HttpSession session=request.getSession(); 
		//为目标博主创建实例
		//这里从数据库获取所有信息实例化
		Blogger aimBlogger=BloggerMgr.getInstance().getBkiggerByName(aimblogger);
		session.setAttribute(BlogAttrs.ATTR_AIMBLOGGER, aimBlogger);
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		//是同一个用户，就把权限设为1
		if(currentBlogger!=null){
		if(aimblogger.equals(currentBlogger.getName())){
			currentBlogger.setPermission(1);
			aimBlogger=currentBlogger;
		}else {
			currentBlogger.setPermission(0);
		}
		}
		return "bloggerOwnView";
	}
	
	@RequestMapping("onLeaveLetter.do")
	public String onLeaveLetter(HttpServletRequest request,String content){
		HttpSession session=request.getSession(); 
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		Blogger aimBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_AIMBLOGGER);
		ContentMgr.getInstance().addLeaveLetter(content, currentBlogger.getName(), aimBlogger.getName(), 1);
		return "leaveMessageView";
	}
	
	@RequestMapping("onAddFriend.do")
	@ResponseBody
	public String onAddFriend(HttpServletRequest request){
		HttpSession session=request.getSession(); 
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		Blogger aimBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_AIMBLOGGER);
		BloggerMgr.getInstance().addFriend(currentBlogger.getName(), aimBlogger.getName());
		return "yes";
	}
	
	@RequestMapping("onCancelFriend.do")
	@ResponseBody
	public String onCancelFriend(HttpServletRequest request){
		HttpSession session=request.getSession(); 
		Blogger currentBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);
		Blogger aimBlogger=(Blogger)session.getAttribute(BlogAttrs.ATTR_AIMBLOGGER);
		BloggerMgr.getInstance().delFriend(currentBlogger.getName(), aimBlogger.getName());
		return "yes";
	}
	
}
