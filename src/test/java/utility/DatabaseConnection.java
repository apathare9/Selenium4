    package utility;

    import java.sql.*;

    public class DatabaseConnection {

//        public static void readData() {
//
//            try {
//
//    //          Driver Manager : import java.util.DriverManager;
//
//    //          Connection Establishment :
//                String url = "jdbc:mysql://localhost:3306/";
//                String db = "Selenium4Xpaths";
//                String username = "root";
//                String password = "";
//
//    //            import java.util.Connection;
//
//                Connection conn = DriverManager.getConnection(url+db, username, password);
//                Statement st = conn.createStatement();
//
//    //            Statement Execution - query
//    //            String query = "SELECT * FROM Selenium4Xpaths.LOCATORS";
//
//                String query = "SELECT MODULE_NAME, LOCATOR_REFERENCE_VALUE" +
//                        "FROM LOCATORS" +
//                        "WHERE MODULE_NAME = 'GoIbibo' AND TYPE_OF_SELECTOR = 'xpath' AND LOCATOR_REFERENCE = 'PopupCloseButton';";
//                ResultSet rs = st.executeQuery(query);
//
//
//                while (rs.next()) {
//    //                System.out.println("1 = " + rs.getString(1));
//    //                System.out.println("2 = " + rs.getString(2));
//    //                System.out.println("3 = " + rs.getString(3));
//    //                System.out.println("4 = " + rs.getString(4));
//    //                System.out.println("5 = " + rs.getString(5));
//
//                    System.out.println("1 = " + rs.getString(1));
//                }
//
//                System.out.println("Data Retrieved Successfully" );
//
//    //            Close Connection
//                conn.close();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        public static void readData() {
            try {
                String url = "jdbc:mysql://localhost:3306/";
                String db = "Selenium4Xpaths";
                String username = "root";
                String password = "";

                Connection conn = DriverManager.getConnection(url + db, username, password);

                String query = "SELECT MODULE_NAME, LOCATOR_REFERENCE_VALUE FROM LOCATORS WHERE MODULE_NAME = ? AND TYPE_OF_SELECTOR = ? AND LOCATOR_REFERENCE = ?";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "GoIbibo");
                pstmt.setString(2, "xpath");
                pstmt.setString(3, "PopupCloseButton");

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    System.out.println("MODULE_NAME: " + rs.getString("MODULE_NAME"));
                    System.out.println("LOCATOR_REFERENCE_VALUE: " + rs.getString("LOCATOR_REFERENCE_VALUE"));
                    System.out.println();
                }

                System.out.println("Data Retrieved Successfully");

                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            readData();
        }
    }


