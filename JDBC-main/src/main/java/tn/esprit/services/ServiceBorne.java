package tn.esprit.services;

import tn.esprit.models.Borne_Pompe;
import tn.esprit.interfaces.IService;
import tn.esprit.models.Station;
import tn.esprit.models.Utilisateur;
import tn.esprit.models.tarifs;
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
        borne.calculerCout();
        // Création de la requête SQL
        String qry = "INSERT INTO `bornes`(`type`, `etat`, `puissance_kW`, `connecteur_type`, `disponibilite`, `energie_consommee`, `dernier_utilisateur`, `id_station`, `id_tarif`, `cout`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, borne.getType().getValue());
            pstm.setString(2, borne.getEtat().getValue());
            pstm.setDouble(3, borne.getPuissance_kW());
            pstm.setString(4, borne.getConnecteur_type());
            pstm.setBoolean(5, borne.isDisponible());
            pstm.setDouble(6, borne.getEnergie_consommee());
            pstm.setInt(7, borne.getDernier_utilisateur().getId_user());
            pstm.setInt(8, borne.getStation().getId_station());
            pstm.setInt(9, borne.getTarif().getId_tarif());
            pstm.setDouble(10, borne.getCout());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Borne_Pompe> getAll() {
        List<Borne_Pompe> bornes = new ArrayList<>();
        String qry = "SELECT * FROM `bornes`";  // Correction du nom de la table

        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                Borne_Pompe p = new Borne_Pompe();
                p.setType(Borne_Pompe.Type.fromString(rs.getString("type")));
                p.setEtat(Borne_Pompe.Etat.fromString(rs.getString("etat")));
                p.setPuissance_kW(rs.getDouble("puissance_kW"));
                p.setConnecteur_type(rs.getString("connecteur_type"));
                p.setDisponibilile(rs.getBoolean("disponibilite"));
                p.setEnergie_consommee(rs.getDouble("energie_consommee"));
                p.setCout(rs.getDouble("cout"));
                Utilisateur u = new Utilisateur();
                u.setId_user(rs.getInt("id_user"));
                p.setUser(u);
                Station station = new Station();
                station.setId_station(rs.getInt("id_station"));
                p.setStation(station);
                tarifs t = new tarifs();
                t.setId_tarif(rs.getInt("id_tarif"));
                p.setTarif(t);

                bornes.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bornes;
    }
    @Override
    public void update(Borne_Pompe borne) {
        borne.calculerCout();
        String qry = "UPDATE `bornes` SET `type`=?, `etat`=?, `puissance_kW`=?, `connecteur_type`=?, `disponibilite`=?, `energie_consommee`=?, `dernier_utilisateur`=?, `id_station`=?, `id_tarif`=?, `cout`=? WHERE `id_borne`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, borne.getType().getValue());
            pstm.setString(2, borne.getEtat().getValue());
            pstm.setDouble(3, borne.getPuissance_kW());
            pstm.setString(4, borne.getConnecteur_type());
            pstm.setBoolean(5, borne.isDisponible());
            pstm.setDouble(6, borne.getEnergie_consommee());
            pstm.setInt(7, borne.getDernier_utilisateur().getId_user());
            pstm.setInt(8, borne.getStation().getId_station());
            pstm.setInt(9, borne.getTarif().getId_tarif());
            pstm.setDouble(10, borne.getCout());
            pstm.setInt(11, borne.getId_borne());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Borne_Pompe borne) {
        String qry = "DELETE FROM `bornes` WHERE `id_borne` = ?";
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
        String qry = "DELETE FROM `` WHERE `id_borne` = ?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1,id_borne);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public tarifs getTarifById(int idTarif) {
        tarifs tarif = null;
        String qry = "SELECT * FROM tarifs WHERE id_tarif = ?";

        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, idTarif);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                tarif = new tarifs();
                tarif.setId_tarif(rs.getInt("id_tarif"));
                tarif.setTarif_par_kwh(rs.getDouble("tarif_par_kwh"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tarif;
    }

}
