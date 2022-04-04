import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Time {
  public static void main(String[] args) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    System.out.println(dtf.format(now));
  }
}