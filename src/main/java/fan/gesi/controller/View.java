package fan.gesi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fan.gesi.model.WriterDAO;
import fan.gesi.model.WriterVO;

/**
 * Servlet implementation class View
 */
@WebServlet("/view")
public class View extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    	
    	
        String boardid_str = request.getParameter("boardid");

        int boardid = Integer.parseInt(boardid_str);

        WriterDAO writerDAO = new WriterDAO();


        WriterVO writerVO = writerDAO.getView(boardid);

        request.setAttribute("writerVO", writerVO);

        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/view.jsp");
        rs.forward(request, response);
    }

}
