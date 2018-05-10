package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Assignment.Film;
import Assignment.FilmDAO;

/**
 * Servlet implementation class insertFilm
 */
@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public insertFilm() {
  super();
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  PrintWriter out = response.getWriter();
  //get each parameter and add to a new Film Object
  FilmDAO dao = new FilmDAO();
  String idStr = request.getParameter("id");
  int id = Integer.parseInt(idStr);
  String title = request.getParameter("title");
  String yearStr = request.getParameter("year");
  int year = Integer.parseInt(yearStr);
  String director = request.getParameter("director");
  String stars = request.getParameter("stars");
  String review = request.getParameter("review");
  Film f = new Film(id, title, year, director, stars, review);

  try {
	  //insert the film object by calling the insertFilm method form FilmDAO
   dao.insertFilm(f);
  } catch (SQLException e) {
   e.printStackTrace();
  }

  request.setAttribute("films", f);
  out.println("Insert successful" + f);
  System.out.println("Insert successful" + f);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
 }

}