package tn.esprit.test;

import tn.esprit.models.Borne_Pompe;
import tn.esprit.models.Station;

import tn.esprit.services.ServiceStation;
import tn.esprit.services.ServiceBorne;

public class Main1 {
    public static void main(String[] args) {
        ServiceStation s = new ServiceStation();
       s.add(new Station("Agil", "Ariana", Station.Status.CLOSED,1));
       // Station station =new Station("shell", "bizerte", Station.Status.DISPO,1);
        //s.update(new Station("shell", "Tunisie", Station.Status.NON_DISPO,1));
        //s.delete(station);
        ServiceBorne sb = new ServiceBorne();
        //sb.add(new Borne_Pompe(Borne_Pompe.Type.BORNE, Borne_Pompe.Etat.DISPO,1));
        //Borne_Pompe borne =new Borne_Pompe(Borne_Pompe.Type.POMPE, Borne_Pompe.Etat.DISPO,1,4);
        //sb.update(new Borne_Pompe(Borne_Pompe.Type.POMPE, Borne_Pompe.Etat.NON_DISPO,1,5));
      // sb.deleteID(2);


        System.out.println(sb.getAll());

    }
}
