<%@ page import="java.util.List" %>
<%@ page import="Assignment.Film" %>
<%@ page import="Assignment.FilmDAO" %>
<%@ page trimDirectiveWhitespaces = "true" %>

<%

List<Film> films = (List<Film>) request.getAttribute("films");
Film oneFilm = null;
for (int i=0; i<films.size();i++){
	oneFilm = films.get(i);
	out.println(oneFilm.getId() + "#" + oneFilm.getTitle() + "#" +oneFilm.getYear() + "#" +oneFilm.getDirector() + "#" +oneFilm.getStars()+ "#" +oneFilm.getReview());	
}

%>

