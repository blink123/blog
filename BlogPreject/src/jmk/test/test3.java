package jmk.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmk.system.comment.PrivateLetter;
import jmk.system.dao.impl.CommentDaoImp;
import jmk.system.dao.impl.PrivateLetterDaoImp;

public class test3 {
	public static void main(String [] args){  
        ApplicationContext context =   
                new ClassPathXmlApplicationContext("Beans.xml");  
        PrivateLetterDaoImp privateletterDaoImp = (PrivateLetterDaoImp)context.getBean("privateletterDaoImp");  
          
         
        int[] number={1,2,3,4,5,6};
        String[] content={"真好","真棒","不好","无聊","没意思","垃圾"};
        String[] time={"2017/5/12","2017/5/13","2017/5/14","2017/5/15","2017/5/16","2017/5/17"};
        String[] sendbloggername={"姜明鲲", "刘佳伟", "陈鑫", "陈波", "冯志豪", "姜明鲲"};
        String[] aimbloggername = {"陈鑫", "陈波", "冯志豪", "姜明鲲","刘佳伟","陈波"};
        int[] readflag={1,1,1,0,0,0};
        PrivateLetter privateletter = null;  
        List<PrivateLetter> privateletters = null;  
              
        System.out.println("---------add privateletter-------------");  
        for(int i=0; i<number.length; i++){  
        	privateletter = new PrivateLetter(number[i],content[i],time[i],sendbloggername[i],aimbloggername[i],readflag[i]);  
        	privateletterDaoImp.addprivateletter(privateletter);            
        }  
        privateletterDaoImp.displayall();
        System.out.println("---------update comment-------------");  
        privateletter = new PrivateLetter(1,"不好","2017/5/13","陈鑫","姜明鲲",1); 
        
        privateletterDaoImp.updprivateletter(privateletter);  
        privateletterDaoImp.displayall();  
        System.out.println("---------search comment by number-------------");  
        privateletters = privateletterDaoImp.seaprivateletter(1);  
        for(PrivateLetter s : privateletters){  
            s.display();  
        }
        System.out.println("---------search comment by aimBloggerName-------------");  
        privateletters = privateletterDaoImp.seaprivateletter2("姜明鲲");  
        for(PrivateLetter s : privateletters){  
            s.display();  
        }
        System.out.println("---------delete comment by number-------------");  
        privateletterDaoImp.delprivateletter(1);  
        privateletterDaoImp.displayall(); 
        
    }  
}
