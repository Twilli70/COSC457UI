import java.sql.*;
import java.util.ArrayList;

public class TritonDB {
    public static final String host = "triton";
    public static final int port = 3360;
    public static final String dbName = "twilli70db";
    public static final String dbUser = "twilli70";
    public static final String dbPassword = "COSC*3acm9";

    public static TritonDB instance;

    Connection connection;
    Statement statement;

    private TritonDB(){
        try{
            var url = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static TritonDB getInstance(){
        if (instance == null){
            instance = new TritonDB();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        if (connection != null){
            return statement.executeQuery(sql);
        }
        return null;
    }

    public void printResult(ResultSet result){
        if (result != null){
            try {
                var resultMeta = result.getMetaData();
                var columns = resultMeta.getColumnCount();
                var rows = new ArrayList<String>();
                var format = new StringBuilder();

                result.beforeFirst();

                for (int i = 1; i <= columns; i++){
                    rows.add("[ " + resultMeta.getColumnName(i) + " ]");
                    format.append("%").append(i).append("$-35s");
                }

                System.out.format(format + "\n", rows.toArray());

                rows.clear();
                while(result.next()){
                    for (int i = 1; i <= columns; i++){
                        var columnValue = result.getString(i);
                        rows.add("| " + columnValue + " |");
                    }
                    System.out.format(format + "\n", rows.toArray());
                }

                // May be unnecessary, intended show sql errors in console
                var warning = result.getWarnings();
                while (warning != null) {
                    System.out.println(warning.getMessage());
                    warning = warning.getNextWarning();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}