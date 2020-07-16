package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class UserDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;





    public UserDAO() {

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

    //로그인 시도 함수

    public int login(String userID, String userPassword) {

        String SQL = "SELECT userpassword FROM user WHERE userid = ?";

        try {
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, userID);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                if (rs.getString(1).equals(userPassword)) {

                    return 1;

                } else

                    return 0; // 비번 맞지않을때
            }

            return -1; //아이디없음 오류

        } catch (Exception e) {

            e.printStackTrace();
        }
        return -2;

    }

    public int join(String userID, String userPassword, String userEmail) {

        String SQL = "INSERT INTO user VALUES(?,?,?,?)";
        int userNum = userNumber() + 1;
        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, userNum);
            pstmt.setString(2, userID);
            pstmt.setString(3, userPassword);
            pstmt.setString(4, userEmail);

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // DB 오류

    }

    public int userNumber() {

        String SQL = "SELECT usernum FROM user ORDER BY usernum DESC LIMIT 1";

        try {

            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

        }

        return -1;
    }


    public int sessionNumber(String userID) {

        String SQL = "SELECT usernum FROM user WHERE userid = ?";

        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

        }

        return -1;
    }


    public String writerID(int usernum) {

        String SQL = "SELECT userid FROM user WHERE usernum = ?";

        try {

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, usernum);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}

