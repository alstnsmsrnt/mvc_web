package fan.gesi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fan.gesi.model.WriterDAO;
import fan.gesi.model.WriterVO;

/**
 * Servlet implementation class Update
 */

@WebServlet("/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    WriterDAO writerDAO = new WriterDAO();
    WriterVO writerVO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String boardID_str = request.getParameter("boardID");
        int boardID = Integer.parseInt(boardID_str);



        writerVO = writerDAO.updateView(boardID);

        //writerDAO.resoureReturn();

        request.setAttribute("boardID", boardID);
        request.setAttribute("update", writerVO);


        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/update.jsp");
        rs.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String boardID_str = request.getParameter("boardID");
        int boardID = Integer.parseInt(boardID_str);

        int result = writerDAO.Update(title, content, boardID);

        if (result == 1) {

            response.sendRedirect("/main");

        } else {

            PrintWriter pw = response.getWriter();
            pw.println("<script>");
            pw.println("alert('invaild update')");
            pw.println("</script>");

            response.sendRedirect("/main");
        }

    }

}