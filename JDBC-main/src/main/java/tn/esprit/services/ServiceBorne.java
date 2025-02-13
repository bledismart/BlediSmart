package tn.esprit.services;

import tn.esprit.models.Borne_Pompe;
import tn.esprit.interfaces.IService;
import tn.esprit.models.Station;
import tn.esprit.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceBorne implements IService<Borne_Pompe>{

    private Connection cnx;

    // Constructeur corrigé
    public ServiceBorne() {
        cnx = MyDatabase.getInstance().getCnx();
    }

    @Override
    public void add(Borne_Pompe borne) {
        // Création de la requête SQL
        String qry = "INSERT INTO `borne_pompe`(`type`, `etat`,`id_station`) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, borne.getType().getValue());  // Correction
            pstm.setString(2, borne.getEtat().getValue());  // Correction
            pstm.setInt(3, borne.getId_station());  // Correction

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Borne_Pompe> getAll() {
        List<Borne_Pompe> bornes = new ArrayList<>();
        String qry = "SELECT * FROM `borne_pompe`";  // Correction du nom de la table

        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                Borne_Pompe p = new Borne_Pompe();
                p.setId_borne(rs.getInt("id_borne"));
                p.setId_station(rs.getInt("id_station"));

                // Conversion des String en Enum
                p.setType(Borne_Pompe.Type.fromString(rs.getString("type")));
                p.setEtat(Borne_Pompe.Etat.fromString(rs.getString("etat")));


                bornes.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bornes;
    }
    @Override
    public void update(Borne_Pompe borne) {

        String qry = "UPDATE `borne_pompe` SET  `type`=?, `etat`=? ,`id_station`=?  WHERE `id_borne`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, borne.getType().getValue());
            pstm.setString(2, borne.getEtat().getValue());
            pstm.setInt(3, borne.getId_station());

            pstm.setInt(4, borne.getId_borne());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Borne_Pompe borne) {
        String qry = "DELETE FROM `borne_pompe` WHERE `id_borne` = ?";
        try {

            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1,borne.getId_borne());


            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void deleteID(int id_borne) {
        String qry = "DELETE FROM `borne_pompe` WHERE `id_borne` = ?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1,id_borne);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
