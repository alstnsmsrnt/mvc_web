
package fan.gesi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fan.gesi.model.WriterDAO;

/**
 * Servlet implementation class Delete
 */

@WebServlet("/delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String boardID_str = request.getParameter("boardID");
        int boardID = Integer.parseInt(boardID_str);

        WriterDAO writerDAO = new WriterDAO();
        writerDAO.Delete(boardID);


        int result = writerDAO.sortBoardID(boardID);

        if (result == 1) {
            response.sendRedirect("/main");
        } else {

            PrintWriter pw = response.getWriter();
            pw.println("<script>");
            pw.println("alert('invaild delete')");
            pw.println("</script>");

            response.sendRedirect("/main");
        }


    }

}