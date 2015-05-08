package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/Add")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  
	  
	  BoardVo board = new BoardVo();	  
	  board.setTitle(request.getParameter("title"));
	  board.setContent(request.getParameter("content"));
	  
	  BoardDao boardDao = new BoardDao();
	  DBConnectionPool dbPool = new DBConnectionPool();
	  boardDao.setDBConnectionPool(dbPool);
	  boardDao.insert(board);
	  
	  
	  
	  response.sendRedirect("List");
	  //Redirect는 서버에서 클라이언트로 응답할 때 본문을 보내지 않는다.
	  
	  
	  
	  
	  // response.getWriter()가 리턴한 출력 스트림에는 8KB 버퍼가 내장 되어 있다.
	  // 출력하면 이 버퍼에 임시 보관된다.
	  // 버퍼가 모두 차거나 service() 호출이 끝날 때 버퍼의 내용을 웹 브라우저로 보낸다.
	  // out.println() 을 호출 한다고 해서 즉시 웹 브라우져로 보내는 것이 아니다.
	  // 그래서 Redirect는 버퍼에 보관된 출력 내용을 버린다.
	  // 그리고 본문을 웹 브라우저로 보내지 않는다.
	  
	  
	  /*
	   * Redirect란?
	   * 1) 응답 코드 값이 200이 아니라 302이다.
	   * 2) Location 헤더에 리다이렉트 할 주소가 있다.
	   * 웹 브라우져는 이 응답을 받는 즉시 Location헤더에 정의한 주소로 다시 요청한다.
	   * 
	   * 결론 : Redirect 할 경우에는 웹 브라우저로 출력할 필요가 없다.( INSERT DELETE)
	   *           다음 출력을 없애주세요
	   *           
	   *           
	   * */
	  /*
	  PrintWriter out = response.getWriter();
	  out.println("<html>");
    out.println("<head>");
//    out.println("<meta http-equiv='refresh' content='5; url=List'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시판</h1>");
    out.println("<p>등록 성공 입니다.<p>");
    out.println("</body>");
    out.println("</html>");*/
	  
	  
	}

}
