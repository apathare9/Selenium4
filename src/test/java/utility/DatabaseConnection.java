    package utility;

    import java.sql.*;
    import java.util.Properties;

    public class DatabaseConnection {

        public static String locatorReferenceValue = null;
        public static String getLocatorReference(String locator) {
            try {

                Properties prop = PropertyFileReader.loadProperties();
                String url = prop.getProperty("databaseUrl");
                String db = prop.getProperty("db");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password");

                System.out.println(url + "----");
                System.out.println(db + "----");
                System.out.println(username + "----");
                System.out.println(password + "----");

                String val = url + db;
                System.out.println(val);

                Connection conn = DriverManager.getConnection(url + db, username, password);

                String query = "SELECT MODULE_NAME, LOCATOR_REFERENCE_VALUE FROM LOCATORS WHERE MODULE_NAME = ? AND LOCATOR_REFERENCE = ?";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "GoIbibo");
                pstmt.setString(2, locator);

                ResultSet rs = pstmt.executeQuery();

//                String locatorReferenceValue = "";
                while (rs.next()) {
                    System.out.println("MODULE_NAME: " + rs.getString("MODULE_NAME"));
                    System.out.println("LOCATOR_REFERENCE_VALUE: " + rs.getString("LOCATOR_REFERENCE_VALUE"));
                    locatorReferenceValue = rs.getString("LOCATOR_REFERENCE_VALUE");
                    System.out.println();
                }

                System.out.println("Data Retrieved Successfully");

                pstmt.close();
                conn.close();

                return locatorReferenceValue;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


    }


