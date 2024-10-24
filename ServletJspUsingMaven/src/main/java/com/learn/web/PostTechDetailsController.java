package com.learn.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.learn.Dao.TechDetailsDao;
import com.learn.model.TechDetails;

@WebServlet("/PostTechDetails")
public class PostTechDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String technology = request.getParameter("name");
		TechDetailsDao dao = new TechDetailsDao();
		int count = dao.saveTechDetails(id, name, technology);
		request.setAttribute("count", "count");
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println(count + " record inserted successfully");
		} else {
			out.println("records inserted failed");
		}
		// doGet(request, response);
	}

}
