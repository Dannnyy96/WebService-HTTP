package Servlets;

import java.io.IOException;
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
 * Servlet implementation class getFilm
 */
@WebServlet("/getFilm")
public class getFilm extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public getFilm() {
  super();

 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  FilmDAO dao = new FilmDAO();
  ArrayList < Film > filmList;
  //get the parameter from the text field entered on index.html
  String filmname = request.getParameter("filmname");
  //call the method getFilm from the FilmDAO and pass the String to it(got above), add the results into an ArrayList(created above)
  filmList = dao.getFilm(filmname);
  System.out.println(filmList);

  request.setAttribute("films", filmList);
  //select a format to display the results in
  String format = request.getParameter("format");
  String outputPage;

  if (request.getParameter("getfilmxml") != null) {
   format = "xml";
  } else if (request.getParameter("getfilmjson") != null) {
   format = "json";
  } else if (request.getParameter("getfilmtext") != null) {
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