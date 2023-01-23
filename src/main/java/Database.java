import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static final Database INSTANSE = new Database();

    private Connection connection;

    private Database() {
        try {
            String connectionUrl = "jdbc:h2:./MegaSoft";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstanse() {
        return INSTANSE;
    }

    public void executeUpdate(String sql) {
        try(Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
