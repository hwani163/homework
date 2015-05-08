package net.bitacademy.java67.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*
 *  실습목표 : Servlet 실행 과정
 *  1) 웹 브라우저에서 서블릿을 요청한다.
 *      => http://localhost:9999/web02/step01/Test01
 * 2) 톰캣 서버는 서블릿 경로와 연결된 객체를 찾는다. (web.xml을 뒤진다.)
 *      => 웹 애플리케이션 경로(Context Root) : /web02
 *      
 * 3.1) 만약 인스턴스가 없담녀 , web.xml을 뒤져서 클래스 정보를 알아낸다음,
 * => 클래스의 인스턴스를 생성한다.
 * => init()을 호출한다.
 * => service()를 호출한다.
 *  3.2) 만약 인스턴스가 있다면 , 
 *         service()를 호출 한다.
 *  즉 서블릿 컨테이너 (ex : Tomcat)는 서블릿 클래스의 인스턴스를 한 개 만 생성하여 사용 한다.
 * 
 *    참고!
 *    web.xml을 변경하면 , 서블릿 컨테이너를 재 시작해야만 변경된 내용이 적용 된다.
 *    
 *    javax.servlet.Servlet 인터페이스 메서드
 *    1) init()
 *          => 최초 요청시 호출됨.
 *          => 서비스에 필요한 자원을 준비하는 작업.
 *   2) service()
 *          => 클라이언트가 요청을 
 *          
 *    5) getServletConfig()
 *          => 서블릿 설정 정보를 참고할 때 이용.
 *          서블릿 컨테이너가 호출 되는 메서드는 init() , service() , destroy()이다.
 *          
 *          
 *      lifeCyclel Method 라과 부른다.
 *      
 * */
public class Test01 implements Servlet{
  public Test01(){
    System.out.println("Test01 Constructor");
  }

  @Override
  public void destroy() {
    System.out.println("destroy() 호출됨");
    
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig() 호출됨");
    return null;
  }
  

  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo() 호출됨");
    
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    System.out.println("init() called");
  }

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
System.out.println("service() called;");    
  }

}
