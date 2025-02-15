package tn.esprit.models;

public class tarifs {
    private int id_tarif;

    private String type_borne;
    private double tarif_par_Kwh;

    public tarifs() {}

    public tarifs(String type_borne, double tarif_par_kwh) {

        this.type_borne = type_borne;
        this.tarif_par_Kwh = tarif_par_kwh;
    }
    public tarifs(String type_borne, double tarif_par_kwh,int id_tarif) {
        this.id_tarif = id_tarif;
        this.type_borne = type_borne;
        this.tarif_par_Kwh = tarif_par_kwh;
    }
    public int getId_tarif() {
        return id_tarif;
    }

    public void setId_tarif(int id_tarif) {
        this.id_tarif = id_tarif;
    }

    public String getType_borne() {
        return type_borne;
    }

    public void setType_borne(String type_borne) {
        this.type_borne = type_borne;
    }

    public double getTarif_par_kwh() {
        return tarif_par_Kwh;
    }

    public void setTarif_par_kwh(double tarif_par_kwh) {
        this.tarif_par_Kwh = tarif_par_kwh;
    }

    @Override
    public String toString() {
        return "Tarifs{" +
                "id_tarif=" + id_tarif +
                ", type_borne='" + type_borne + '\'' +
                ", tarif_par_kwh=" + tarif_par_Kwh +
                '}';
    }

}
