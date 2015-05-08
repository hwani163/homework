package net.bitacademy.java67.step01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 *      WindowListner 인터페이스 구현하는 방법과 같다
 *      Window Listener 를 직접 구현하기 보다는 WindowsAdapter를 상속받아서
 *      간접적으로 구현하듯이 서블릿도 간접적으로 Servlet인터 페이스를 구현 할 수 있다.
 *      
 *      GernericServlet 추상 클래스
 *      Servlet인터페이스를 미리 구현한 추상 클래스이다.
 *      단 service() 메서드는 구현 하지 않았다.
 *      즉 GenericServlet을 상속 받는 하위 클래스에서 구현 해야 한다.
 *      
 *      
 *         * 서블릿 정보에 웹 애플리 케이션에 등록하기
   * 1) web.xml에 등록하기
   * 2) 자바소스에 애노테이션을 사용하여 web.xml에 등록할 수 있다.
 *  @WebServlet() 애노테이션
 *  -web.xml에 서블릿 배치 정보를 작성하는 대신에 자바 소스에 배치 정보를 작성 할 때 싸용
 *  애노테이션으로 배치 정보를 작성 하려면 , Web.xml파일에서 
 *  <web-app> 태그의 metadata-complete 속성의 값을 false로 설정 하여야 한다.
 *  만약 true로 설정한다면 ,  배치정보를 기술 하는 애노테이션은 무시 된다.
 *  metadata-complete 속성의 기본 값은 false이다.
 *  곧 속성을 지정 하지 않으면 애노테이션 정보를 인지한다는 의미이다
 * */
@WebServlet (name="step01/Test02" , urlPatterns="/step01/Test02")


public class Test02 extends GenericServlet{
  /*
   * GenericServlet 을 상속한 후 경고가 뜬다. 이유?
   * GenericServlet은 java.io.Serializable인터페이스를 구현했다.
   * 이 인터페이스를 구현한 클래스는 반드시 직렬화 버전을 명시하여야 한다.
   * Test02클래스는 GenericServlet을 상속 받았기 때문에 직렬화 버전을 명ㅇ시 해야 한다.
   * 다음과 같이 static변수를 선언하여 직렬화 버전을 명시하라!
   *             
   * 직렬화 했을때의 클래스와 복구 했을 때의 클래스가 같은지를 판별하기위하여 직렬화버전 UID를 통하여 판별한다.
   *  
   * 
   * */
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("Test02");
  }

  
}
