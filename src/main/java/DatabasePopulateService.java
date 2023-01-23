import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String PopulateDbFilename = "sql/populate_db.sql";
            String insertSql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(PopulateDbFilename))
            );
            Database.getInstanse().executeUpdate(insertSql);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
