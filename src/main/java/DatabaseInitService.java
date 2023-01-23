import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String InitDbFilename = "sql/init_db.sql";
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(InitDbFilename))
            );
            Database.getInstanse().executeUpdate(sql);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
