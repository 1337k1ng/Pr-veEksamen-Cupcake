package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    private static ArrayList<User> brugerListe;

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Bruger (email, password, saldo, rolle) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setInt(3,20);
            ps.setString( 4, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id,rolle FROM Bruger "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "rolle" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<User> HentBrugere() throws LoginSampleException  {

        if (brugerListe == null) {
            brugerListe = new ArrayList<User>();
        } else
            brugerListe.clear();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Bruger";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
               brugerListe.add(new User(rs.getString("email"),rs.getString("saldo") , rs.getString("rolle")));

            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        } finally {
            return brugerListe;
        }
    }


    public static boolean deleteUserFromDB(String email) {


        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM Bruger Where email = " + "'" +email+ "'" ;
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.executeUpdate();
        } catch ( ClassNotFoundException | SQLException ex ) {
         System.out.println(ex);
        }
        return true;
    }

    public static boolean checkIfEmailExists(String email) {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Bruger";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {

                if (rs.getString("email").equals(email)){
                    System.out.println("fandtes!");
                    return true;

                }
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
           // Error
        }

        // Email fandtes ikke
        return false;
    }

    public User getUserByEmail(String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from Bruger  WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                String role = rs.getString("rolle");
                int id = rs.getInt("brugerId");
                String password = rs.getString("password");
                int saldo = rs.getInt("saldo");

                User user = new User(email, password, role);
                user.setId(id);
                user.setSaldo(saldo);

                return user;

            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

        public void updateUserBalanceByEmail(String email, double opdateretSaldo) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE Bruger SET saldo = ? WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble( 1, opdateretSaldo);
            ps.setString( 2, email);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex ){
            //Error
        }
    }
        public int pushOrdreToDB(int brugerId) {
            /* Takes in a brugerID, Returns an OrderID. */
            try {
                Connection conn = Connector.connection();
                String SQL = "INSERT INTO Ordre(brugerId) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
                ps.setInt(1, brugerId);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt( 1 );
                return id;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return -1; // should never go here.
        }

        public int pushMuffinToDB(double price, String top, String bot) {
        /* Takes in a brugerID, Returns an OrderID. */
        try {
            Connection conn = Connector.connection();
            String SQL = "INSERT INTO Cupcake(bund, top, pris) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, bot);
            ps.setString(2, top);
            ps.setDouble(3, price);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            return id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1; // should never go here.
    }


        public void pushIndholdToDB(int ordreID, int muffinID) {
            try {
                Connection conn = Connector.connection();
                String SQL = "INSERT INTO Indhold(ordreId, cupcakeId) VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, ordreID);
                ps.setInt(2, muffinID);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public void pushDateToDB(int ordreID) {
            /* get date real quick */
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = formatter.format(date);

            try {
                Connection conn = Connector.connection();
                String SQL = "INSERT INTO Tidspunkt(ordreId, dato) VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, ordreID);
                ps.setString(2, strDate);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


        public void InsertMoneyToUser(String Bruger, int beløb){
            try {

                Connection conn = Connector.connection();
                String SQL = "UPDATE Bruger " +
                        "SET saldo = saldo + ? " +
                        "WHERE email = ?";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, beløb);
                ps.setString(2, Bruger);
                System.out.println(ps);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}
