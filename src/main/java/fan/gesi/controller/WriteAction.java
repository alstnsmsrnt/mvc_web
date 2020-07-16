package fan.gesi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.UserDAO;
import fan.gesi.model.WriterDAO;

/**
 * Servlet implementation class WriteAction
 */
@WebServlet("/writeAction")
public class WriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String usernum_str = request.getParameter("usernum"); 
		int usernum = Integer.parseInt(usernum_str);

		WriterDAO writerDAO = new WriterDAO();

		int result = writerDAO.writer(title, content, usernum);

		if (result == 1) {
			response.sendRedirect("/main");
		} else if (result == 0) {
			response.sendRedirect("/write");
		}

	}

}

