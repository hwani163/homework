package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/step03/Detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	  // TODO Auto-generated method stub
	  super.doGet(req, resp);
	}
  
   @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
     response.setContentType("text/html;charset=UTF-8");
     BoardDao boardDao = new BoardDao();     
     boardDao.setDBConnectionPool(new DBConnectionPool());
     
     BoardVo board  = new BoardVo();
     board= boardDao.select(Integer.parseInt(request.getParameter("no")));
     //출력 스트림을 준비하기전에 미리 컨텐트 타입을 정해 주어야 한다.
     PrintWriter out = response.getWriter();
     out.println("<!DOCTYPE html>");
     out.println("<html>");
     out.println("<head>");
     out.println("<meta charset='UTF-8'>");
     out.println("<title>게시판</title>");
     out.println("</head>");
     out.println("<body>");
     out.println(" <h1>게시물 상세정보</h1>");
     if (request.getMethod().equals("POST")) {
      out.println("<p>요청 메쏘드를 지원하지 않습니다.</p>");
    }else{
     out.println("<form action='Update' method='POST'>");
     out.println("번호 : <p name='no'>"+board.getNo()+"</p>");
     out.println("제목 : <input name='title' value="+board.getTitle()+"></p>");
     out.println("내용 : <textarea rows='10' cols='50' name='content'>"+board.getContent()+"</textarea>");
     out.println("조회수 : <p name='views'>"+board.getViews()+"</p>");
     out.println("생성날짜 : <p name='views'>"+board.getCreateDate()+"</p>");
     out.println("<input type='submit' value='변경'>");
     out.println("<button type='button' onclick='location.href=\"Delete\"'>삭제</button>");
     out.println("<button type='button' onclick='location.href=\"List\"'>취소</button>");         
     out.println("</form>");
    }
     
     
     out.println("</body>");
     out.println("</html>");

     
     
  }

	
}
