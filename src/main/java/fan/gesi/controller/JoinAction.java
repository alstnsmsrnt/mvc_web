package fan.gesi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.User;
import User.UserDAO;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
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
        String userEmail = request.getParameter("userEmail");

        UserDAO userDAO = new UserDAO();

        //userDAO.resoureReturn();

        int result = userDAO.join(userID, userPassword, userEmail);

        if (result == 1) {
            response.sendRedirect("/login");
        } else if (result == -1) {
            response.sendRedirect("/join");
        }


    }

}