package jmk.test;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmk.system.comment.Article;
import jmk.system.dao.impl.ArticleDaoImp;

public class test{
	public static void main(String [] args){  
        ApplicationContext context =   
                new ClassPathXmlApplicationContext("Beans.xml");  
        ArticleDaoImp articleDaoImp = (ArticleDaoImp)context.getBean("articleDaoImp");  
          
          
        String[] title = { "周一", "周二", "周三", "周四", "周五","周六"};  
        String[] type = { "日记", "照片", "日记", "照片", "日记", "视频"};  
        int[] readcount = { 10, 18, 20, 20, 30, 40 };  
        String[] bloggername = {"姜明鲲", "刘佳伟", "陈鑫", "陈波", "冯志豪", "姜明鲲"};
        int[] number={1,2,3,4,5,6};
        String[] content={"今天是周一","今天是周二","今天是周三","今天是周四","今天是周五","今天是周六"};
        String[] time={"2017/5/12","2017/5/13","2017/5/14","2017/5/15","2017/5/16","2017/5/17"};
        Article article = null;  
        List<Article> articles = null;  
              
        System.out.println("---------add article-------------");  
        for(int i=0; i<number.length; i++){  
            article = new Article(title[i],type[i],readcount[i],bloggername[i],number[i],content[i],time[i]);  
            articleDaoImp.addarticle(article);            
        }  
        articleDaoImp.displayall();
        System.out.println("---------update article-------------");  
        article = new Article("周二","照片",50,"陈鑫",1,"哈哈哈","2017/1/1");  
        articleDaoImp.updarticle(article);  
        articleDaoImp.displayall();  
        System.out.println("---------search article by number-------------");  
        articles = articleDaoImp.seaarticle(1);  
        for(Article s : articles){  
            s.display();  
        }
        System.out.println("---------search article by type-------------");  
        articles = articleDaoImp.seaarticle2("日记");  
        for(Article s : articles){  
            s.display();  
        }
        System.out.println("---------search article by bloggername-------------");  
        articles = articleDaoImp.seaarticle3("姜明鲲");  
        for(Article s : articles){  
            s.display();  
        }
        System.out.println("---------delete article by number-------------");  
        articleDaoImp.delarticle(1);  
        articleDaoImp.displayall(); 
        
    }  
      
}
