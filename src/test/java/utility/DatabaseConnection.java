    package utility;
    import java.sql.*;
    import java.util.Properties;

    public class DatabaseConnection {





        public static String getLocatorName(String locReference ) throws Throwable {

            String getLocatorName = null;
            PreparedStatement pstmt = null;
            ResultSet locResultSet = null ;
            try{

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

                String query = "SELECT MODULE_NAME, LOCATOR_REFERENCE, LOCATOR_REFERENCE_VALUE FROM LOCATORS WHERE MODULE_NAME = ? AND LOCATOR_REFERENCE = ?";

                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "GoIbibo");
                pstmt.setString(2, locReference);

                locResultSet = pstmt.executeQuery();

                while (locResultSet.next()) {
                    System.out.println("MODULE_NAME: " + locResultSet.getString("MODULE_NAME"));
                    System.out.println("LOCATOR_REFERENCE: " + locResultSet.getString("LOCATOR_REFERENCE"));
                    System.out.println("LOCATOR_REFERENCE_VALUE: " + locResultSet.getString("LOCATOR_REFERENCE_VALUE"));

                    getLocatorName = locResultSet.getString("LOCATOR_REFERENCE_VALUE");

//                    if (getLocatorName.equals(locReference)) {
//                        System.out.println("Works Fine");
//                    } else {
//                        throw new RuntimeException();
//                    }

                    System.out.println();
                }

            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                try {
                    if(pstmt != null)
                        pstmt.close();

                    if (locResultSet != null)
                        locResultSet.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("***** Locator Reference " + locReference + " : " + "Locator Reference Value : " + getLocatorName + "*****");
            return getLocatorName;

        }


    }



//        public class DatabaseConnection {
//
//        public static String locatorReference = null;
//        public static String locatorReferenceValue = null;
//        public static String getLocatorReference(String locator) {
//            try {
//
//                Properties prop = PropertyFileReader.loadProperties();
//                String url = prop.getProperty("databaseUrl");
//                String db = prop.getProperty("db");
//                String username = prop.getProperty("username");
//                String password = prop.getProperty("password");
//
//                System.out.println(url + "----");
//                System.out.println(db + "----");
//                System.out.println(username + "----");
//                System.out.println(password + "----");
//
//                String val = url + db;
//                System.out.println(val);
//
//                Connection conn = DriverManager.getConnection(url + db, username, password);
//
//                String query = "SELECT MODULE_NAME, LOCATOR_REFERENCE, LOCATOR_REFERENCE_VALUE FROM LOCATORS WHERE MODULE_NAME = ? AND LOCATOR_REFERENCE = ?";
//
//                PreparedStatement pstmt = conn.prepareStatement(query);
//                pstmt.setString(1, "GoIbibo");
//                pstmt.setString(2, locator);
//
//                ResultSet rs = pstmt.executeQuery();
//
/// /                String locatorReferenceValue = "";
//                while (rs.next()) {
//                    System.out.println("MODULE_NAME: " + rs.getString("MODULE_NAME"));
//                    System.out.println("LOCATOR_REFERENCE: " + rs.getString("LOCATOR_REFERENCE"));
//                    System.out.println("LOCATOR_REFERENCE_VALUE: " + rs.getString("LOCATOR_REFERENCE_VALUE"));
//
//
//                    locatorReference = rs.getString("LOCATOR_REFERENCE");
//
//                    if (locatorReference.equals(locator)) {
//                        System.out.println("Works Fine");
//                    } else {
//                        throw new RuntimeException();
//                    }
//                    return locatorReferenceValue = rs.getString("LOCATOR_REFERENCE_VALUE");
//                    System.out.println();
//                }
//
//                System.out.println("Data Retrieved Successfully");
//
//                pstmt.close();
//                conn.close();
//
////                return locatorReferenceValue;
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//
//    }
//
//
