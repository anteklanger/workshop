package pl.coderslab.team2.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbService {

    private static String dbName = "workshop";
    private static String dbUser = "root";
<<<<<<< HEAD
    private static String dbPass = "";

=======
    private static String dbPass = "coderslab"; //TODO enter password
>>>>>>> 3e3f6e2be0da6cdf094e1e387cb6d3a16635f293

    private static Connection createConn() throws SQLException {
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&characterEncoding=utf8&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        return DriverManager.getConnection(connUrl, dbUser, dbPass);
    }

    /**
     * Execute insert query and return id of created element, if not then null
     * @param query
     * @param params
     * @return id or null
     * @throws SQLException
     */
    public static Integer insertIntoDatabase(String query, List<String> params) throws SQLException {

        try(Connection conn = createConn()){

            String[] generatedColumns = {"id"};
            PreparedStatement pst = conn.prepareStatement(query, generatedColumns);
            if(params != null) {
                int i = 1;
                for (String p : params) {
                    pst.setString(i++, p);
                }
            }
            pst.executeUpdate();

            ResultSet res = pst.getGeneratedKeys();

            if(res.next())
                return res.getInt(1);
            else
                return null;
        }catch (SQLException e ){
            throw e;
        }

    }

    public static List<String[]> getData(String query, List<String> params) throws SQLException{

        try(Connection conn = createConn()){

            //prepare query
            PreparedStatement st = getPreparedStatement(query, params, conn);

            //execute and get results
            ResultSet rs = st.executeQuery();

            //get columns from query
            ResultSetMetaData columns = rs.getMetaData();

            //prepare list of results
            List<String[]> result = new ArrayList<>();

            while(rs.next()){

                //New String array for row data
                String[] row = new String[columns.getColumnCount()];

                for(int j=1; j<=columns.getColumnCount(); j++){
                    row[j-1] = rs.getString( columns.getColumnName(j) );
                }

                result.add(row);
            }

            return result;

        }catch (SQLException e){
            throw e;
        }

    }

    public static int executeQuery(String query, List<String> params) throws SQLException{
        try(Connection conn = createConn()) {
            PreparedStatement st = getPreparedStatement(query, params, conn);
            return st.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }

    private static PreparedStatement getPreparedStatement(String query, List<String> params, Connection conn) throws SQLException {
        //prepare query
        PreparedStatement st = conn.prepareStatement(query);
        if (params != null) {
            int i = 1;
            for (String p : params) {
                st.setString(i++, p);
            }
        }
        return st;
    }
}