package fan.gesi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;

import User.UserDAO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        HttpSession session = request.getSession();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        UserDAO userDAO = new UserDAO();
        int result = userDAO.login(userID, userPassword);

        //userDAO.resoureReturn();
        if (result == 1) {

            int usernum = userDAO.sessionNumber(userID);
            session.setAttribute("usernum", usernum);
            response.sendRedirect("/main");

        } else if (result == 0) {

            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('パスワードが一致していません.')");
            script.println("history.back()");
            script.println("</script>");



        } else if (result == -1) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('存在してないアカウントです.')");
            script.println("history.back()");
            script.println("</script>");

        }


    }

}