
package aiwa.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aiwa.Entity.Kyoto;

public class KyotoModel {

    public ArrayList<Kyoto> findBykeyword(String word) {

        ArrayList<Kyoto> kyoto = new ArrayList<Kyoto>();

        try {

            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:Teamwork.db"
            );

            String sql = "select * from Travel1 "
                       + "where PlaceName like ? "
                       + "or Address like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%" + word + "%");
            stmt.setString(2, "%" + word + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Kyoto k = new Kyoto();

                k.setPlaceId(rs.getInt("PlaceId"));
                k.setPlaceName(rs.getString("PlaceName"));
                k.setAddress(rs.getString("Address"));
                k.setImage(rs.getString("Image"));
                k.setDetails(rs.getString("Details"));
                k.setFamousFood(rs.getString("FamousFood"));
                k.setFoodImage(rs.getString("FoodImage"));

                kyoto.add(k);
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return kyoto;
    }


    public ArrayList<Kyoto> findAll() {

        ArrayList<Kyoto> kyoto = new ArrayList<Kyoto>();

        try {

            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:Teamwork.db"
            );

            String sql = "select * from Travel1";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Kyoto k = new Kyoto();

                k.setPlaceId(rs.getInt("PlaceId"));
                k.setPlaceName(rs.getString("PlaceName"));
                k.setAddress(rs.getString("Address"));
                k.setImage(rs.getString("Image"));
                k.setDetails(rs.getString("Details"));
                k.setFamousFood(rs.getString("FamousFood"));
                k.setFoodImage(rs.getString("FoodImage"));

                kyoto.add(k);
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return kyoto;
    }

}