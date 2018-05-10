<%@ page import="java.util.List" %>
<%@ page import="javax.xml.bind.JAXBContext" %>
<%@ page import="javax.xml.bind.JAXBException" %>
<%@ page import="javax.xml.bind.Marshaller" %>
<%@ page import="Assignment.Film" %>
<%@ page import="Assignment.FilmList" %>
<%@ page import="Assignment.FilmDAO" %>
<%@ page trimDirectiveWhitespaces = "true" %>

<%
FilmList films = new FilmList((List<Film>) request.getAttribute("films"));

try {
	JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	// output pretty printed
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	jaxbMarshaller.marshal(films, out);

    } catch (JAXBException e) {
	e.printStackTrace();
    }


%>



