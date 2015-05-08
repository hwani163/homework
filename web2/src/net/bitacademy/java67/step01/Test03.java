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

/*클라이언트로 출력하기
 * 
 * 배치 정보를 설정할 때 URL 패턴만 지정한다면 , 다음과 같이 속성 이름을 생략할 수 있다
 * */

@WebServlet (urlPatterns="/step01/Test03")


public class Test03 extends GenericServlet{  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Test02");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Hello......^^");
    out.println("곤니찌와");
    out.println("呢下");
  }

  
}
