package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRegist
 */
@WebServlet("/ServletRegist")
public class ServletRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		
		//注册一个用户
		//获取路径
		
		String blogTempletePath = getServletContext().getRealPath("/WebContent/");
	
		System.out.println(blogTempletePath);
		
		File src=new File(blogTempletePath+"/blogTemplete/blogTemplete");
		
		File dest=new File(blogTempletePath+"/allbloggers/");
		
		//dest.getParentFile().mkdirs();
		copyFolder(src,dest);
	}
	
    /** 
     * 复制一个目录及其子目录、文件到另外一个目录 
     * @param src 
     * @param dest 
     * @throws IOException 
     */  
    private void copyFolder(File src, File dest) throws IOException {  
        if (src.isDirectory()) {  
            if (!dest.exists()) {  
                dest.mkdir();  
            }  
            String files[] = src.list();  
            for (String file : files) {  
                File srcFile = new File(src, file);  
                File destFile = new File(dest, file);  
                // 递归复制  
                copyFolder(srcFile, destFile);  
            }  
        } else {  
            InputStream in = new FileInputStream(src);  
            OutputStream out = new FileOutputStream(dest);  
      
            byte[] buffer = new byte[1024];  
      
            int length;  
              
            while ((length = in.read(buffer)) > 0) {  
                out.write(buffer, 0, length);  
            }  
            in.close();  
            out.close();  
        }  
    }  
	
}
