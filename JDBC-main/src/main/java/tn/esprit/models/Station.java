package tn.esprit.models;
import java.util.List;

public class Station {

    private int id_station;
    private String nom_station;
    private String emplacement;
    private Status status; // Utilisation d'une enum
    private Utilisateur user;
    private int capacite_max;
    private String heures_ouverture;
    private String contact;
    private double latitude;
    private double longitude;

    private List<Borne_Pompe> bornes;

    public List<Borne_Pompe> getBornes() {
        return bornes;
    }

    public void setBornes(List<Borne_Pompe> bornes) {
        this.bornes = bornes;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getHeuresOuverture() {
        return heures_ouverture;
    }

    public void setHeuresOuverture(String heures_ouverture) {
        this.heures_ouverture = heures_ouverture;
    }
    public int getCapaciteMax() {
        return capacite_max;
    }

    public void setCapaciteMax(int capacite_max) {
        this.capacite_max = capacite_max;
    }

    // Enum interne pour Status
    public enum Status {
        OPEN("active"),
        CLOSED("fermé");
        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        // Convertir une String en Status
        public static Status fromString(String status) {
            for (Status s : Status.values()) {
                if (s.value.equalsIgnoreCase(status)) {
                    return s;
                }
            }
            throw new IllegalArgumentException("Statut invalide : " + status);
        }
    }
    public Status getStatus() {
        return status;
    }
    // Si vous devez définir le status à partir d'une String (ex: depuis la base de données)
    public void setStatus(String status) {
        this.status = Status.fromString(status);
    }
    // Constructeurs
    public Station() {
    }

    public Station(String nom_station, String emplacement, Status status,Utilisateur user, int capacite_max,
                   String heures_ouverture, String contact, double latitude, double longitude,int id_station) {
        this.nom_station = nom_station;
        this.emplacement = emplacement;
        this.status = status;
        this.user = user;
        this.capacite_max = capacite_max;
        this.heures_ouverture = heures_ouverture;
        this.contact = contact;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id_station = id_station;
    }

    public Station(String nom_station, String emplacement, Status status,Utilisateur user, int capacite_max,
                   String heures_ouverture, String contact, double latitude, double longitude) {
        this.nom_station = nom_station;
        this.emplacement = emplacement;
        this.status = status;
        this.user = user;
        this.capacite_max = capacite_max;
        this.heures_ouverture = heures_ouverture;
        this.contact = contact;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters et Setters
    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public Utilisateur getUser() {

        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    public String getNom_station() {
        return nom_station;
    }

    public void setNom_station(String nom_station) {
        this.nom_station = nom_station;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) { // Correction ici
        this.emplacement = emplacement;
    }



    @Override
    public String toString() {
        return "Station{" +
                "id_station=" + id_station +
                ", emplacement='" + emplacement + '\'' +
                ", nom_station='" + nom_station + '\'' +
                ", status='" + status.getValue() + '\'' +
                ", id_utilisateur='" + (user != null ? user.getId_user() : "Non assigné") + '\'' +

                "}\n";
    }
}
