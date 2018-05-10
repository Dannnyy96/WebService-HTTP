package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Assignment.Film;
import Assignment.FilmDAO;

/**
 * Servlet implementation class ControlServ
 */
@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * Default constructor. 
  */
 public getAllFilms() {

 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //response.getWriter().append("Served at: ").append(request.getContextPath());


  ArrayList < Film > allFilms = new ArrayList < Film > ();
  FilmDAO dao = new FilmDAO();
  //call the method getAllFilms from the FilmDAO, add the results to an ArrayList(created above)
  allFilms = dao.getAllFilms();
  for (Film i: allFilms) {
   System.out.println(i.toString());
  }
  
//select a format to display the results in
  request.setAttribute("films", allFilms);
  String format = request.getParameter("format");
  String outputPage;

  if (request.getParameter("getallxml") != null) {
   format = "xml";
  } else if (request.getParameter("getalljson") != null) {
   format = "json";
  } else if (request.getParameter("getalltext") != null) {
   format = "text";
  } else {

  }

  if ("xml".equals(format)) {
   response.setContentType("text/xml");
   outputPage = "/WEB-INF/results/films-xml.jsp";
  } else if ("text".equals(format)) {
   response.setContentType("text/plain");
   outputPage = "/WEB-INF/results/films-string.jsp";
  } else {
   response.setContentType("application/json");
   outputPage = "/WEB-INF/results/films-json.jsp";
  }
  RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
  dispatcher.include(request, response);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  doGet(request, response);


 }
}