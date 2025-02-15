package tn.esprit.test;

import tn.esprit.models.Borne_Pompe;
import tn.esprit.models.Station;
import tn.esprit.models.tarifs;
import tn.esprit.models.Utilisateur;
import tn.esprit.services.ServiceStation;
import tn.esprit.services.ServiceBorne;

public class Main1 {
    public static void main(String[] args) {
        ServiceStation s = new ServiceStation();
        Utilisateur user = new Utilisateur( 1,"raouen","maknine ", "raouen@gmail.com", "125478");

        s.add(new Station("Agil", "Ariana", Station.Status.CLOSED,user,100,"8h","55680729",36.258,10.182));
     //   Station station =new Station("shell", "bizerte", Station.Status.CLOSED,user,10,"4h","65.22",32.255,22.023,3);
    //s.update(new Station("shell", "Tunisie", Station.Status.OPEN,user,500,"7h","589647",25.2,23.5,3));
     //   s.delete(station);
       // ServiceBorne sb = new ServiceBorne();
        //sb.add(new Borne_Pompe(Borne_Pompe.Type.BORNE, Borne_Pompe.Etat.DISPO,1));
        //Borne_Pompe borne =new Borne_Pompe(Borne_Pompe.Type.POMPE, Borne_Pompe.Etat.DISPO,1,4);
        //sb.update(new Borne_Pompe(Borne_Pompe.Type.POMPE, Borne_Pompe.Etat.NON_DISPO,1,5));
       //s.deleteID();

        // Create a Station instance
        Station station = new Station();
        station.setId_station(9);  // Assuming the station ID is 1, make sure it's correct

        // Fetch the tarif from the database
        ServiceBorne serviceBorne= new ServiceBorne();
        tarifs tarifStandard = serviceBorne.getTarifById(3);
        // Create the Borne_Pompe instance
        Borne_Pompe borne = new Borne_Pompe();
        borne.setType(Borne_Pompe.Type.FAST); // Choose appropriate type
        borne.setEtat(Borne_Pompe.Etat.ACTV); // Set the state to available (or any other state)
        borne.setPuissance_kW(22.5);  // Example power, adjust as needed
        borne.setConnecteur_type("Type1"); // Example connector type
        borne.setDisponibilile(true);  // Set availability
        borne.setEnergie_consommee(30.0); // Example energy consumption
        borne.setDernier_utilisateur(user); // Set the user
        borne.setStation(station); // Set the station
        borne.setTarif(tarifStandard); // Set the tariff

        // Calculate the cost based on energy consumed
        borne.calculerCout();

        // Add the Borne_Pompe to the database
        serviceBorne.add(borne);

        // Output the calculated cost to the console
        System.out.println("Coût total : " + borne.getCout() + " TND");


    }}
