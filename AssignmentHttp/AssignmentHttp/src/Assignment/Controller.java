package Assignment;

public class Controller {
		public static void main(String[] args){
			FilmDAO dao = new FilmDAO();
			dao.openConnection();
			//dao.getFilm("Attack");
			dao.getAllFilms();
			dao.closeConnection();
		 }
}
