import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String PopulateDbFilename = "sql/populate_db.sql";
            String insertSql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(PopulateDbFilename))
            );
            try(Connection connection = Database.getInstanse().getConnection();
                Statement st = connection.createStatement()) {
                st.executeUpdate(insertSql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
