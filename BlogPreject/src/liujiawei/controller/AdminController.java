package liujiawei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import liujiawei.service.BloggerMgr;
import liujiawei.service.ContentMgr;

@Controller
public class AdminController {
	@RequestMapping("onDeleteBl.do")
	@ResponseBody
	public String onDeleteBlogger(HttpServletRequest request, String aimBloggerName){
		System.out.println("我要删了"+aimBloggerName);
		BloggerMgr.getInstance().deleteBlogger(aimBloggerName);
		return "yes";
	}
	
	/*
	 * 根据编号删除一篇文章
	 */
	@RequestMapping("onDeleteArticle.do")
	@ResponseBody
	public String onDeleteArticle(String articleNumber){
		System.out.println("我要删了文章"+articleNumber);
		ContentMgr.getInstance().deleteOneArticleByNumber(Integer.parseInt(articleNumber));
		return "yes";
	}
	
	/*
	 * 增加一个新的推荐
	 */
	@RequestMapping("onAddOneRecommand.do")
	@ResponseBody
	public String onAddOneRecommand(String articleNumber) {
		System.out.println("我要增加一个推荐controller");
		BloggerMgr.getInstance().addOneRecommand(Integer.parseInt(articleNumber));
		return "yes";
	}
	
	/*
	 * 删除一个推荐
	 */
	@RequestMapping("onDeleteOneRecommand.do")
	@ResponseBody
	public  String onDeleteOneRecommand(String articleNumber) {
		System.out.println("我要删除一个推荐controller");
		BloggerMgr.getInstance().deleteOneRecommand(Integer.parseInt(articleNumber));
		return "yes";
	}
	
}
