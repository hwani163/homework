package net.bitacademy.java67;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*
 * 3. 서블릿 실행을 테스트 하자
 *  -  웹 브라우저 주소창에 URL 을 입력한다.
 *      이클립스에서 실행하면안뎀!! 왜냐하면 이클립스는 자체적으로 참고하는 폴더가 다르기 때문
 *      우리는 톰캣밑에 넣었기 때문이다.]
 *      
 *  -> htpp://localhost:9999/myapp/test00/hello
 *  
 *  
 *  
 *  
 *    * javax.servlet.Servlet 인터페이스
 *      - 서블릿 컨테이너와 서블릿 프로그램 사이의 호출 규칙 이다.
 *      - 클라이언트에서 요청이 들어오면 , 서블릿 컨테이너는 규칙에 따라
 *      Servlet 인터페이스의 메서드를 호출 한다.
 *      
 *      웹 애플리케이션 배치 폴더 $tomcat_home/webapps
 *      - 톰캣 서버의 경우 웹 애플리 케이션은 webapps 라는 디렉토리에 배치 하여야 한다.
 *      
 *      웹애플리케이션 폴더 구조
 *      myapp/WEB-INF/classes  <--- 자바클래스 파일(.class) 또는 프로퍼티 파일(.properties)를 둔다.
 *      myapp/WEB-INF/lib
 *            => 자바 라이브러리파일(.jar)를 둔다.
 *      myapp/WEB-INF/web.xml
 *            => 웹 애플리 케이션의 설정 정보를 둔다.
 *      
 *      myapp/
 *            => HTML , CSS , JavaScript , JSP , 그림파일 등을 둔다.
 *            
 *     주의@    => WEB-INF 폴더 밑에있는 파일은 웹브라우저에서 요청 할 수 없다.
 *                      따라서 WEB-INF폴더에 HTML , JSP , CSS , JavaScript 등을 두지 말라.
 *    
 *    임시 배치 폴더 : .meta/.plugins/.....server.core/tmp0/wtpwebapps
 *    => 개발하는 동안 웹 어플리캐이션 을 테스트 할 목적으로 사용하는 임시 폴더.
 *    이클립스의 플러그 인을 사용하여 톰캣을 실행 할 때 이 임시 폴더에 배치 해야 한다.
 *    위에서 한 것과 같이 개발자가 따로 배치를 수행 할 필요는 없다.
 *    이클립스 웹 개발 플러그인 (Web Tools Platform )이 자동으로 임시 폴더에 배치한다.
 *    개발 하는 동안 직접 파일 탐색기나 명령창에서 톰캣 서버를 실행 하지 말라!
 *    
 *    자동 배치 방법  : 
 *    1) Servers 뷰에 톰캣 개발 환경을 생성한다. 예) BIT Server , Study server
 *    2) 톰캣 실행 환경에 웹 프로젝트를 추가하라.
 *          Servers View -> study Server -> Context Menu -> add and remove ....  -> 웹프로젝트 추가!
 *    3) 톰캣 서버 실행
 *        Servers View -> Study Server 선택 -> 플레이 버튼 클릭      
 *          
 *          
 *    톰캣 서버 실행 확인
 *    Console 뷰 -> 출력 내용 확인 (내용중에 오류가 없는지 주의 깊게 확인하라)
 *    
 *    
 *    웹 프로젝트 폴더 구조
 *    1) src : 자바 소스파일 및 프로퍼티 파일을 둔다.
 *    2) WebContent :  톰캣 서버에 배치할 HTML , CSS , JavaScript , 그림 파일 등을 둔다.
 *                               WEB-INF 폴더도 이 디렉토리에 둔다.
 *    3) WebContent/WEB-INF/classes : 따로 만들 필요가 없다.
 *                                                        톰캣 서버에 배치할 때 자동으로 만든다.
 *                                                        build/classes 폴더에 있는 파일을 자동으로 만든다.
 *                                                        
 *                                                        
 *    자동 배치 과정
 *    톰캣 서버를 실행하면 다음과 같이 웹 애플리케이션이 자동으로 배치한다.
 *    1) Web app폴더 생성
 *      ==> workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/
 *      웹프로젝트의 컨텍스트이름(default : 웹프로젝트명) 으로 하위폴더를 만든다.
 *      
 *    ====> 프로젝트 폴더에 있는 webContent/폴더의 모든 파일 및 디렉토리를 복사한다.
 *    1)workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps
 *    
 *    2) 프로젝트 폴더/WebContent/폴더의 모든 파일 및 디렉토리
 *    ===> 워크스페이스폴더 /.metadata/.plugins/....server.core/temp/wtpwebapps/웹 애플리케이션 폴더에 그대로 복사한다.
 *   
 *   3) 프로젝트폴더 /build/classes/* 자바클래스 파일(.class)
 *        => 웹 애플리케이션폴더 / WEB-INF/classes / 폴더에 그대로 복사한다.
 *        
 *      주의! 가끔 자동으로 복사되지 않는 경우가 있다. WTP 플러그인의 버그이다.
 *      해결방법 : 
 *      1) 톰캣 서버에서 해당 프로젝트를 제거한후.
 *          웹애플리케이션이 없는 상태에서 톰캣 서버를 다시 실행하라.
 *      2) 임시폴더에서 정확하게 제거되었는지 확인하라.
 *      분명히 제거 했는데도. 폴ㄷ더가 삭제되지 않는경우가 있다.
 *      3) 다시 톰캣 서버에 프로젝트를 추가 한다음, 다시 시작시켜라
 *      개발 PC가 느린경우  복사하는데 시간이 걸린다. => 프로젝트를 추가 한 후 바로 시작 시키지 말고 , 천천히 서버를 시작시켜라!
 *     
 *    
 *      
 *      
 * */
public class Hello implements Servlet{

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
