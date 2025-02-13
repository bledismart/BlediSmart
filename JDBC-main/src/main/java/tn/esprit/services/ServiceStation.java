package tn.esprit.services;

import tn.esprit.interfaces.IService;

import tn.esprit.models.Station;
import tn.esprit.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceStation implements IService<Station>
{

    private Connection cnx ;

    public ServiceStation(){
        cnx = MyDatabase.getInstance().getCnx();
    }

    @Override
    public void add(Station station) {
        //create Qry SQL
        //execute Qry
        String qry ="INSERT INTO `stations`(`nom_station`, `emplacement`, `status`,`id_user`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1,station.getNom_station());
            pstm.setString(2, station.getEmplacement());
            pstm.setString(3,station.getStatus().getValue());
            pstm.setInt(4, station.getId_user());


            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<Station> getAll() {
        //create Qry sql
        //execution
        //Mapping data


        List<Station> stations = new ArrayList<>();
        String qry ="SELECT * FROM `stations`";

        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Station p = new Station();
                p.setId_station(rs.getInt("id_station"));
                p.setNom_station(rs.getString(2));
                p.setEmplacement(rs.getString("emplacement"));
                p.setStatus(rs.getString("status"));
                p.setId_station(rs.getInt("id_user"));
                stations.add(p);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return stations;
    }

    @Override
    public void update(Station station) {

        String qry ="UPDATE `stations` SET `nom_station`=?, `emplacement`=?, `status`=? , `id_user`=? WHERE `id_station`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1,station.getNom_station());
            pstm.setString(2, station.getEmplacement());
            pstm.setString(3,station.getStatus().getValue());
            pstm.setInt(4,station.getId_user());
            pstm.setInt(5,station.getId_station());



            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Station station) {
        String qry = "DELETE FROM `stations` WHERE `id_station` = ?";
        try {

            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1,station.getId_station());


            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void deleteID(int  station) {}
}
