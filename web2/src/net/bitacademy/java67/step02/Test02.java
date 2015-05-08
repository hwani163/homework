package net.bitacademy.java67.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 실습목표 : HttpServletRequest 사용
 *              HttpServletRequest 는 ServletRequest의 하위 인터페이스 이다.
 
 *               
 *               */
@WebServlet (urlPatterns="/step02/Test02")


public class Test02 extends GenericServlet{  
  private static final long serialVersionUID = 1L;
  
  
  
  

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    
    res.setContentType("text/html;charset=UTF-8");
    req.setCharacterEncoding("UTF-8"); 
  
    PrintWriter out = res.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    
      ServletContext ctx = req.getServletContext();
      out.println(ctx.getContextPath());
      out.println(ctx.getRealPath("/step02/index.html<br>"));
      out.println(res instanceof HttpServletResponse);
      out.println(req instanceof HttpServletRequest);
      out.println("<br>");
      
      HttpServletResponse response2 = (HttpServletResponse) res;
      HttpServletRequest request2 = (HttpServletRequest) req;
      out.println(request2.getHeader("User-agent"));
      //브라우져의 종류를 아ㄹ아보기
     String userAgent =  request2.getHeader("User-agent");
     String browser = null;
     if (userAgent.contains("Chrome")) {
       browser = "Chrome";    }
     else if(userAgent.contains("Safari")){
       browser="Safari";
     }
     else if(userAgent.contains("FireFox")){
       browser="FireFox";
     }
     else{
       browser="InternetExplorer";
     }
     
     
      out.println("웹 브라우져의 정보 : "+browser);
      out.println("요청 Method : "+request2.getMethod());
      out.println("QueryString"+request2.getQueryString());
      out.println("<br> URI정보"+request2.getRequestURI());
      out.println("<br> 스키마"+request2.getScheme());
      
      out.println("</body>");
    
    
    out.println("</html>");
    
  
  }

  
}
