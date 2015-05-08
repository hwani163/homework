package net.bitacademy.java67.step04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.DaoException;
import net.bitacademy.java67.step04.vo.ManagerVo;


public class ManagerDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  // public void destroy() {}

//  public void insert(final ManagerVo board) {
//    Connection con = null;
//    PreparedStatement stmt = null;
//
//    try {
//      con = dbPool.getConnection();
//      stmt = con.prepareStatement("INSERT INTO BOARD2 (title,content,cre_date) VALUES (?,?,now())");
//
//      stmt.setString(1, board.getTitle());
//      stmt.setString(2, board.getContent());
//
//      stmt.executeUpdate();
//
//    } catch (SQLException e) {
//      throw new DaoException(e);
//
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dbPool.returnConnection(con);
//    }
//    }//다른 SQL 작업에서 사용할 수 있도록 반납한다. } }
//   
//   public ManagerVo select(int no) {
//     Connection con = null; 
//     PreparedStatement stmt = null; 
//     ResultSet rs = null;
//   
//   try {
//     con = dbPool.getConnection(); 
//     stmt = con.prepareStatement(
//   "SELECT bno,title,content,views,cre_date FROM board2 WHERE bno = ?");
//     
//   stmt.setInt(1, no);
//   rs = stmt.executeQuery();
//   
//    if (rs.next()) { 
//      ManagerVo board = new ManagerVo();
//      board.setNo(rs.getInt("bno"));
//      board.setTitle(rs.getString("title"));
//      board.setContent(rs.getString("content"));
//      board.setCreateDate(rs.getDate("cre_date"));
//      board.setViews(rs.getInt("views"));
//    return board;
//    
//    } else { return null; }
//    
//    } catch (SQLException e) { throw new DaoException(e);
//    
//    } finally { try {rs.close();} catch (Exception e) {} try {stmt.close();}
//    catch (Exception e) {} dbPool.returnConnection(con); } }
//   
//
//
// public int delete(int no) { 
//   Connection con = null; 
//   PreparedStatement stmt =
// null;
// 
// try { con = dbPool.getConnection(); stmt = con.prepareStatement(
// "DELETE FROM USERS WHERE UNO = ?"); stmt.setInt(1, no); return
// stmt.executeUpdate();
// 
// }catch (SQLException e) { throw new DaoException(e);
// 
// } finally { try {stmt.close();} catch (Exception e) {}
// dbPool.returnConnection(con); } }
//
//
//
  public int update(ManagerVo manager) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
      stmt = con
          .prepareStatement("UPDATE managers SET name = ?, email = ?, pwd = ? , photo=? , tel=?"
              + " WHERE mno = ?");
      stmt.setString(1, manager.getName());
      stmt.setString(2, manager.getEmail());
      stmt.setString(3, manager.getPassword());
      stmt.setString(4, manager.getPhoto());
      stmt.setString(5, manager.getTel());
      stmt.setInt(6, manager.getMno());
      

      return stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
      dbPool.returnConnection(con);
    }

  }


  public List<ManagerVo> selectList() {
    List<ManagerVo> list = new ArrayList<ManagerVo>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();

      rs = stmt.executeQuery("SELECT mno,name,email,tel FROM managers");
      ManagerVo board;
      while (rs.next()) {
        board = new ManagerVo();
        board.setMno(rs.getInt("mno"));
        board.setName(rs.getString("name"));
        board.setEmail(rs.getString("email")); 
        board.setTel(rs.getString("tel"));

        list.add(board);
      }

      return list;

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
      dbPool.returnConnection(con);
    }

  }
}
