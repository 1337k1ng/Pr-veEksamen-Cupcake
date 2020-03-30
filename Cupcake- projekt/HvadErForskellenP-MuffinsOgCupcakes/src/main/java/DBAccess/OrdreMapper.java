package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;

public class OrdreMapper {


    private static ArrayList<Ordre> ordreListe;
    public static ArrayList<Ordre> HentOrdre() throws LoginSampleException  {

        if (ordreListe == null) {
            ordreListe = new ArrayList<Ordre>();
        } else
            ordreListe.clear();

        try {
            Connection con = Connector.connection();
            String SQL = "select Bruger.email, Tidspunkt.dato, Cupcake.top, Cupcake.bund, Cupcake.pris from Bruger, Cupcake, Tidspunkt";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                ordreListe.add(new Ordre(rs.getString("dato"), rs.getString("email"), rs.getString("bund"),rs.getString("top"), rs.getString("pris")));

            }

            for (int i = 0; i < ordreListe.size(); i++) {
                System.out.println((ordreListe.get(i).getEmail()));
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        } finally {
            return ordreListe;
        }
    }
}
