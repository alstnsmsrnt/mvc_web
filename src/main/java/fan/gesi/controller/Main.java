package fan.gesi.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.UserDAO;
import fan.gesi.model.TestDAO;

import fan.gesi.model.WriterDAO;
import fan.gesi.model.WriterVO;


@WebServlet("/main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        WriterDAO writerDAO = new WriterDAO();
        int count = writerDAO.countTable();
        int pageCount = (count / 10) + 1; //

        //writerDAO.resoureReturn();


        request.setAttribute("pageNumber", 1);
        request.setAttribute("pageCount", pageCount);

        int test = (int) request.getAttribute("pageNumber");

        int pageNumber = test;

        if (request.getParameter("pageNumber") != null) {
            String pageNumber_str = request.getParameter("pageNumber");
            pageNumber = Integer.parseInt(pageNumber_str);
            request.setAttribute("pageNumber", pageNumber);
        }



        ArrayList < WriterVO > arrayList = writerDAO.select(pageNumber);
        System.out.println(writerDAO.getLastBoardNumber());


        request.setAttribute("arrayList", arrayList);



        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/gesifan.jsp");
        rs.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}