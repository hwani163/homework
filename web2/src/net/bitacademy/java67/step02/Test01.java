package net.bitacademy.java67.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * 실습목표 : ServletRequest의 사용
 
 *               
 *               */
@WebServlet (urlPatterns="/step02/Test01")


public class Test01 extends GenericServlet{  
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
    
    out.println("클라이언트 주소"+req.getRemoteAddr());
    out.println("클라이언트 포트"+req.getRemotePort());
      ServletContext ctx = req.getServletContext();
      out.println(ctx.getContextPath());
      out.println(ctx.getRealPath("/step02/index.html"));
    out.println("</body>");
    out.println("</html>");
    
  
  }

  
}
