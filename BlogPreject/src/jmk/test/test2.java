package jmk.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jmk.system.comment.Comment;
import jmk.system.dao.impl.CommentDaoImp;


public class test2 {
	public static void main(String [] args){  
        ApplicationContext context =   
                new ClassPathXmlApplicationContext("Beans.xml");  
        CommentDaoImp commentDaoImp = (CommentDaoImp)context.getBean("commentDaoImp");  
          
         
        int[] number={1,2,3,4,5,6};
        String[] content={"ÕæºÃ","Õæ°ô","²»ºÃ","ÎÞÁÄ","Ã»ÒâË¼","À¬»ø"};
        String[] time={"2017/5/12","2017/5/13","2017/5/14","2017/5/15","2017/5/16","2017/5/17"};
        String[] sendbloggername={"½ªÃ÷öï", "Áõ¼ÑÎ°", "³ÂöÎ", "³Â²¨", "·ëÖ¾ºÀ", "½ªÃ÷öï"};
        String[] aimbloggername = {"³ÂöÎ", "³Â²¨", "·ëÖ¾ºÀ", "½ªÃ÷öï","Áõ¼ÑÎ°","³Â²¨"};
        String[] bloggername={"Áõ¼ÑÎ°", "³ÂöÎ", "³Â²¨", "·ëÖ¾ºÀ", "½ªÃ÷öï","³ÂöÎ"};
        int[] articlenumber={1,2,3,4,5,6};
        Comment comment = null;  
        List<Comment> comments = null;  
              
        System.out.println("---------add comment-------------");  
        for(int i=0; i<number.length; i++){  
            comment = new Comment(number[i],content[i],time[i],sendbloggername[i],aimbloggername[i],bloggername[i],articlenumber[i]);  
            commentDaoImp.addcomment(comment);            
        }  
        commentDaoImp.displayall();
        System.out.println("---------update comment-------------");  
        comment = new Comment(1,"²»ºÃ","2017/5/13","³ÂöÎ","½ªÃ÷öï","Áõ¼ÑÎ°",1); 
        
        commentDaoImp.updcomment(comment);  
        commentDaoImp.displayall();  
        System.out.println("---------search comment by number-------------");  
        comments = commentDaoImp.seacomment(1);  
        for(Comment s : comments){  
            s.display();  
        }
        System.out.println("---------search comment by articlenumber-------------");  
        comments = commentDaoImp.seacomment2(1);  
        for(Comment s : comments){  
            s.display();  
        }
        System.out.println("---------delete comment by number-------------");  
        commentDaoImp.delcomment(1);  
        commentDaoImp.displayall(); 
        
    }  
}
