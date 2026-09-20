import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() throws Exception {

        Properties properties = new Properties();

        FileInputStream file =
                new FileInputStream("db.properties");

        properties.load(file);
        file.close();

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}