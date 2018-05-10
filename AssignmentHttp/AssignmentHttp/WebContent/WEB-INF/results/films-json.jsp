<%@ page import="java.util.List" %>
<%@ page import="Assignment.Film" %>
<%@ page import="Assignment.FilmDAO" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page trimDirectiveWhitespaces = "true" %>

<%
List<Film> films = (List<Film>) request.getAttribute("films");
Gson gson = new Gson();
String jsonInString = gson.toJson(films);

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(jsonInString);
%>
