package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * 실습목표 : 계산기 서블릿 만들기
 *               파라메터 : a,b,op
 *               a = 정수값
 *               b = 정수값
 *               op = +,-,*,/,%
 *               요청 URL : http://localhost:9999/web2/step01/Test06?a=20&b=30&op=/
 *               출력결과 : 20 / 5 =4 입니다.
 *               
 *               작업파일 : WebContent/step01/Test06.html
 *               /src/net/bitacademy/java67/step01/Test06.java
 *               
 *               */
@WebServlet (urlPatterns="/step01/Test06")


public class Test06 extends GenericServlet{  
  private static final long serialVersionUID = 1L;
  
  
  
  

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    System.out.println("Test06");
    
    res.setContentType("text/html;charset=UTF-8");
    req.setCharacterEncoding("UTF-8"); 
  
    PrintWriter out = res.getWriter();
    int v1 = Integer.parseInt(req.getParameter("v1"));
    int v2 = Integer.parseInt(req.getParameter("v2"));
    String op = req.getParameter("op");
    int result=0;
    
    switch (op) {
    case "+":  result = v1+v2;  break;
    case "-":  result = v1-v2;  break;
    case "*":  result = v1*v2;  break;
    case "/":  result = v1/v2;  break;
    case "%":  result = v1%v2;  break;

    default:      break;
    }
    
    out.println("<html>");
    
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>"+v1+" "+op+" "+v2+"="+result+"</p>");
    out.println("</body>");
    out.println("</html>");
    
  
  }

  
}
