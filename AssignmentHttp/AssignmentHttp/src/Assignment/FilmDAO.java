package Assignment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;


public class FilmDAO {

 Film oneFilm = null;
 Connection conn = null;
 Statement stmt = null;

 public FilmDAO() {}

 //open connection
 public void openConnection() {

   try {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
   } catch (Exception e) {
    System.out.println(e);
   }

   // connecting to database
   try {
    // connection string including user and pass
    conn = DriverManager.getConnection("jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/mcnamard?user=mcnamard&password=Rimsdarl3");
    stmt = conn.createStatement();
   } catch (SQLException se) {
    System.out.println(se);
   }
  }
  //close connection
 public void closeConnection() {
  try {
   conn.close();
  } catch (SQLException e) {

   e.printStackTrace();
  }
 }
//get next film, this is used in getAllFilms method
 private Film getNextFilm(ResultSet rs) {
  Film thisFilm = null;
  try {
   thisFilm = new Film(
    rs.getInt("id"),
    rs.getString("title"),
    rs.getInt("year"),
    rs.getString("director"),
    rs.getString("stars"),
    rs.getString("review"));
  } catch (SQLException e) {

   e.printStackTrace();
  }
  return thisFilm;
 }

//get all the films from the database
 public ArrayList < Film > getAllFilms() {

  ArrayList < Film > allFilms = new ArrayList < Film > ();
  openConnection();

  // Create select statement and execute it
  try {
   String selectSQL = "select * from films";
   ResultSet rs1 = stmt.executeQuery(selectSQL);
   // Retrieve the results
   while (rs1.next()) {
    oneFilm = getNextFilm(rs1);
    allFilms.add(oneFilm);
   }

   stmt.close();
   closeConnection();

   System.out.println("Select was successful -");
  } catch (SQLException se) {
   System.out.println(se);
  }

  return allFilms;
 }

 //get a film using the parameter(title) supplied by the user
 public ArrayList < Film > getFilm(String title) {

  openConnection();
  ArrayList < Film > aFilm = new ArrayList < Film > ();

  // Create select statement and execute it
  try {
   String selectSQL = "select * from films where title LIKE '%" + title + "%'";
   ResultSet rs1 = stmt.executeQuery(selectSQL);
   // Retrieve the results
   while (rs1.next()) {
    oneFilm = getNextFilm(rs1);
    aFilm.add(oneFilm);
   }

   stmt.close();
   closeConnection();
   System.out.println("Select was successful - " + aFilm);
  } catch (SQLException se) {
   System.out.println(se);
  }

  return aFilm;
 }

 //insert a film into the database(passed a film object)
 public boolean insertFilm(Film f) throws SQLException {

  try {
   openConnection(); // 
   System.out.println("Create operation -database successfully opened");
   //use get methods from film class to get data from the film object supplied
   String sql = "INSERT INTO films(id, title, year, director, stars, review)  " + "VALUES ('" + f.getId() + "','" + f.getTitle() 
   + "','" + f.getYear() + "', '" + f.getDirector() + "', '" + f.getStars() + "', '" + f.getReview() + "')";
   System.out.println(sql);
   stmt.executeUpdate(sql);
   stmt.close();
   closeConnection();
   System.out.println("Insert was successful");
   return true;
  } catch (Exception ex) {
   System.out.println(ex);
   System.exit(0);
  }

  return false;

 }}
