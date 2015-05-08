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

@WebServlet (urlPatterns="/step01/Test05")


public class Test05 extends GenericServlet{  
  private static final long serialVersionUID = 1L;
  
  
  
  

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    System.out.println("Test02");
    
    
    
    /*파라메터 값 꺼내기
     * 1) GET 요청 파메터 값.
     * 2) POST 요청 파라미터 값
     *      POST요청으로 넘어오는 파라미터 값을 꺼내기 전에 어떤 문자 집합으로 
     *       인코딩 했는지 알려줘야 한다.
     *       알려주지 않으면 , 영어 라고 간주하고 유니코드로 바꾼다.
     *       => AB가각(EUC-KR) ---> 4142B0A1B0A2(EUC-KR)  -> 영어라고 판단하고
     *           각 바이트 앞에 00을 붙여서 유니코드로 만든다.
     *           -> 0041 0042 0ㅠ0 00ㅁ1 00ㅠ0 00ㅁ2
     *           
     *           해결책 :  클라이언트가 POST로 보낸 데이터가 어떤 문자 집합인지 getParameter()를 최.초.로. 호출하기 전에 알려줘라
     *                        getParameter()를 단 한번이라도 호출한 후에는 알려줘봐야 무시된다.
     *                        requsst.setCharacterEncoding("문자집합명");
     *           
     *       */
    
    res.setContentType("text/html;charset=UTF-8");
    req.setCharacterEncoding("UTF-8");    //POST 요청에 대해서만 적용된다. GET요청에서는 SERVER.XML에서 바꾸어 주어야 한다.
    //자바는 내부에서 문자열을 다룰때는 유니코드로 다룬다.
    PrintWriter out = res.getWriter();
    String name = req.getParameter("name");
    int age = Integer.parseInt(req.getParameter("age"));
    System.out.println(name+age);
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>하하하 반갑네"+name+age+"</p>");
    out.println("</body>");
    out.println("</html>");
    
  
  }

  
}
