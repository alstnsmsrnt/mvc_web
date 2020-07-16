package fan.gesi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WriterDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public WriterDAO() {

        String url = "jdbc:mysql://localhost:3306/wawa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String id = "root";
        String pw = "Alstnsmsrnt!32";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB연결 성공~!!");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 제목이랑 작성자등 적는것 틀을 만든다
    public int writer(String title, String content, int usernum) {

        String sql = "INSERT INTO writer VALUES(?,?,?,?,?)";
        String date = getDate();
        int number = writerNumber() + 1; //

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.setString(4, date);
            pstmt.setInt(5, usernum);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    // 글을 적을수록 1씩 추가해간다
    public int writerNumber() {
        String sql = "select boardid from writer order by boardid desc limit 1";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;

    }

    // 셋인풋의 값을 받아 한줄씩 추가하는것
    public ArrayList < WriterVO > select(int pageNumber) {

        String sql = "SELECT * FROM writer WHERE boardid <= ? ORDER BY boardid DESC LIMIT 10";
        ArrayList < WriterVO > arrayList = new ArrayList < WriterVO > ();

        int lastNumber = getLastBoardNumber();


        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lastNumber - (pageNumber - 1) * 10);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                WriterVO writerVO = new WriterVO();

                writerVO.setBoardID(rs.getInt(1));
                writerVO.setTitle(rs.getString(2));
                writerVO.setContent(rs.getString(3));
                writerVO.setDate(rs.getString(4));
                writerVO.setUsernum(rs.getInt(5));

                arrayList.add(writerVO);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrayList;

    }

    public ArrayList < WriterVO > selectTest(int pageNumber) { //

        String sql = "SELECT * FROM writer WHERE boardid < ? ORDER BY boardid DESC";
        ArrayList < WriterVO > arrayList = new ArrayList < WriterVO > ();

        try {

            pstmt = conn.prepareStatement(sql);
            int lastNumber = getLastBoardNumber();
            pstmt.setInt(1, 13);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                WriterVO writerVO = new WriterVO();

                writerVO.setBoardID(rs.getInt(1));
                writerVO.setTitle(rs.getString(2));
                writerVO.setContent(rs.getString(3));
                writerVO.setDate(rs.getString(4));
                writerVO.setUsernum(rs.getInt(5));

                arrayList.add(writerVO);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrayList;

    }

    public String getDate() {

        String query = "SELECT NOW()";
        String date;

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                date = rs.getString(1);

                date = date.substring(0, 10);
                return date;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public WriterVO getView(int boardid) {

        String SQL = "SELECT * FROM writer WHERE boardid = ?";
        WriterVO writerVO = new WriterVO();

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, boardid);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                writerVO.setBoardID(rs.getInt(1));
                writerVO.setTitle(rs.getString(2));
                writerVO.setContent(rs.getString(3));
                writerVO.setDate(rs.getString(4));
            }

            return writerVO;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int Delete(int boardID) {

        String SQL = "DELETE FROM writer WHERE boardid = ?";

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, boardID);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    public int sortBoardID(int boardID) {

        String SQL = "UPDATE writer SET boardid = boardid - 1 WHERE boardid > ?";

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, boardID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    public int Update(String title, String content, int boardID) {

        String SQL = "update writer set title = ?, content = ? WHERE boardid = ?;";

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, boardID);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    public WriterVO updateView(int boardID) {

        WriterVO writerVO = new WriterVO();

        String SQL = "SELECT title,content FROM writer WHERE boardid = ?";

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, boardID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                writerVO.setTitle(rs.getString(1));
                writerVO.setContent(rs.getString(2));
            }

            return writerVO;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;

    }

    public int getLastBoardNumber() {

        String sql = "SELECT boardid FROM writer ORDER BY boardid DESC";
        int result = 0;

        try {

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);
            }

            rs = null;
            return result;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    public int countTable() {

        String SQL = "SELECT COUNT(*) FROM writer";

        try {
            pstmt = conn.prepareStatement(SQL);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}