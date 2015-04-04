
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class NewClass {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void readData() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/<dbname>?"
                    + "user=<username>&password=<password>");

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from <dbname>.<table>");
            writeResultSet(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            close();
        }
    }

    private HashMap<Integer, String> writeResultSet(ResultSet resultSet) throws SQLException, IOException {
        HashMap<Integer, String> map = new HashMap<>();
        while (resultSet.next()) {
            int issueID = resultSet.getInt(1);
            String comment = resultSet.getString(2);
            File file = new File("" + issueID);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(comment);
            bw.close();
        }
        return map;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }
}
