package Assignment;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "filmlist")
@XmlAccessorType(XmlAccessType.FIELD)

public class FilmList {

 public FilmList() {

 }

 @XmlElement(name = "film")
 private List < Film > films;
 public FilmList(List < Film > inFilms) {
  films = inFilms;
 }
 public List < Film > getFilmList() {
  return films;
 }
 public void setFilmList(List < Film > inFilms) {
  films = inFilms;
 }

}
