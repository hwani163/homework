package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 클래스 계층도
 * 1) Servlet
 *     . init()
 *     . service()
 *     . destroy(0
 *     . getServletInfo()
 *     . getServletConfig(0
 *     
 * 2) GenericServlet(추상클래스
 *     . init()
 *     . destroy()
 *     . getServletInfo()
 *     . getService()
 *     
 * 3) HttpServlet(추상클래스)
 *      . service(ServletRequest , ServletResponse)
 *      . service(HttpServletRequest , HttpServletResponse)
 *     
 * */

@WebServlet (urlPatterns="/step03/List")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardDao boardDao = new BoardDao();
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    boardDao.setDBConnectionPool(dbConnectionPool);
    List<BoardVo> list = boardDao.selectList();
    
    
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 목록</h1>");
    out.println("<p><a href='form.html'> 새 글</a></p>");
    out.println("<table border='1'>");
    out.println("<tr>\n");
    out.println("<th>번호</th>");
    out.println("<th>제목</th>");
    out.println("<th>작성일</th>");
    out.println("<th>조회수</th>");
    out.println("</tr>");
    for (BoardVo board : list) {
      out.println("<tr>");
      out.println("<td>"+board.getNo()+"</td>");
      out.println("<td><a href='Detail?no="+board.getNo()+"'</a>"+board.getTitle()+"</a></td>");
      out.println("<td>"+board.getCreateDate()+"</td>");
      out.println("<td>"+board.getViews()+"</td>");
      out.println("</tr>");
    }
    out.println("</body>");
    out.println("</html>");





  }




}
