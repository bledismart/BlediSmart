package tn.esprit.models;

public class Station {

    private int id_station;
    private String nom_station;
    private String emplacement;
    private Status status; // Utilisation d'une enum
    private int id_user;

    // Enum interne pour Status
    public enum Status {
        OPEN("ouverte"),
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

    // Constructeurs
    public Station() {
    }

    public Station(String nom_station, String emplacement, Status status,int id_user, int id_station) {
        this.nom_station = nom_station;
        this.emplacement = emplacement;
        this.status = status;
        this.id_user = id_user;
        this.id_station = id_station;
    }

    public Station(String nom_station, String emplacement, Status status,int id_user) {
        this.nom_station = nom_station;
        this.emplacement = emplacement;
        this.status = status;
        this.id_user = id_user;
    }

    // Getters et Setters
    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_station = id_user;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Si vous devez définir le status à partir d'une String (ex: depuis la base de données)
    public void setStatus(String status) {
        this.status = Status.fromString(status);
    }

    @Override
    public String toString() {
        return "Station{" +
                "id_station=" + id_station +
                ", emplacement='" + emplacement + '\'' +
                ", nom_station='" + nom_station + '\'' +
                ", status='" + status.getValue() + '\'' +
                ", id_utilisateur='" + id_user+ '\'' +

                "}\n";
    }
}
