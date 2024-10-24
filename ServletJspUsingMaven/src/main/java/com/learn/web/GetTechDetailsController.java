package com.learn.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.learn.Dao.TechDetailsDao;
import com.learn.model.TechDetails;

@WebServlet("/GetTechDetails")
public class GetTechDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TechDetailsDao dao = new TechDetailsDao();
		TechDetails a1 = dao.getTechDetails(id);
		System.out.println(a1);
		request.setAttribute("techDetails", a1);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
	}

}
