
package aiwa.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aiwa.Entity.Fukuoka;

public class FukuokaModel {

    public ArrayList<Fukuoka> findBykeyword(String word) {

        ArrayList<Fukuoka> fukuokas = new ArrayList<Fukuoka>();

        try {

            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:Teamwork.db"
            );

            String sql = "select * from Travel "
                       + "where PlaceName like ? "
                       + "or Details like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%" + word + "%");
            stmt.setString(2, "%" + word + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Fukuoka f = new Fukuoka();

                f.setPlaceId(rs.getInt("PlaceId"));
                f.setPlaceName(rs.getString("PlaceName"));
                f.setAddress(rs.getString("Address"));
                f.setImage(rs.getString("Image"));
                f.setDetails(rs.getString("Details"));
                f.setFamousFood(rs.getString("FamousFood"));
                f.setFoodImage(rs.getString("FoodImage"));

                fukuokas.add(f);
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return fukuokas;
    }


    public ArrayList<Fukuoka> findAll() {

        ArrayList<Fukuoka> fukuokas = new ArrayList<Fukuoka>();

        try {

            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:Teamwork.db"
            );

            String sql = "select * from Travel";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Fukuoka f = new Fukuoka();

                f.setPlaceId(rs.getInt("PlaceId"));
                f.setPlaceName(rs.getString("PlaceName"));
                f.setAddress(rs.getString("Address"));
                f.setImage(rs.getString("Image"));
                f.setDetails(rs.getString("Details"));
                f.setFamousFood(rs.getString("FamousFood"));
                f.setFoodImage(rs.getString("FoodImage"));

                fukuokas.add(f);
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return fukuokas;
    }

}
