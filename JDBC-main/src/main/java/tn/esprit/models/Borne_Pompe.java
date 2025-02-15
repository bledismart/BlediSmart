package tn.esprit.models;

public class Borne_Pompe {

    private int id_borne;
    private Type type;
    private double puissance_kW;
    private Etat etat;
    private String connecteur_type;
    private boolean disponibilite;
    private double energie_consommee;
    private Utilisateur dernier_utilisateur;
    private Station station;
    private tarifs tarif;
    private double cout;

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public double getPuissance_kW() {
        return puissance_kW;
    }

    public void setPuissance_kW(double puissanceKW) {
        this.puissance_kW = puissanceKW;
    }

    public String getConnecteur_type() {
        return connecteur_type;
    }

    public void setConnecteur_type(String connecteurType) {
        this.connecteur_type = connecteurType;
    }

    public boolean isDisponible() {
        return disponibilite;
    }

    public void setDisponibilile(boolean disponible) {
        this.disponibilite = disponible;
    }

    public double getEnergie_consommee() {
        return energie_consommee;
    }

    public void setEnergie_consommee(double energie_consommee) {
        this.energie_consommee = energie_consommee;
        calculerCout();
    }

    public Station getStation() {
        return station;
    }
    public void setStation(Station station) {
        this.station = station;
    }
    public void setDernier_utilisateur(Utilisateur user) {
        this.dernier_utilisateur = user;
    }
    public Utilisateur getDernier_utilisateur() {
        return dernier_utilisateur;
    }
    public tarifs getTarif() {
        return tarif;
    }
    public void setTarif(tarifs tarif) {
        this.tarif = tarif;
        calculerCout();
    }

    // Enum pour Type
    public enum Type {
        STAN("standard"),
        FAST("rapide"),
        UFAST("ulta-rapide");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Type fromString(String type) {
            for (Type t : Type.values()) {
                if (t.value.equalsIgnoreCase(type)) {
                    return t;
                }
            }
            throw new IllegalArgumentException("Type invalide : " + type);
        }
    }

    // Enum pour Etat
    public enum Etat {
        ACTV("active"),
        NO_ACTV("hors service");

        private final String value;

        Etat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Etat fromString(String etat) {
            for (Etat e : Etat.values()) {
                if (e.value.equalsIgnoreCase(etat)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Etat invalide : " + etat);
        }
    }

    // Constructeurs
    public Borne_Pompe() {
    }
    public Borne_Pompe( Type type,double puissance_kW, Etat etat,String connecteur_type,boolean disponibilite,double energie_consommee,
                        Utilisateur user,Station station,tarifs tarif ,double cout) {
        this.type = type;
        this.cout=cout;
        this.etat = etat;
        this.puissance_kW = puissance_kW;
        this.connecteur_type = connecteur_type;
        this.disponibilite = disponibilite;
        this.energie_consommee = energie_consommee;
        this.dernier_utilisateur = user;
        this.station = station;
        this.tarif = tarif;

    }
    public Borne_Pompe(Type type,double puissance_kW, Etat etat,String connecteur_type,boolean disponibilite,double energie_consommee,
                       Utilisateur user,Station station,tarifs tarif ,double cout, int id_borne) {
        this.id_borne = id_borne;
        this.type = type;
        this.cout=cout;
        this.etat = etat;
        this.puissance_kW = puissance_kW;
        this.connecteur_type = connecteur_type;
        this.disponibilite = disponibilite;
        this.energie_consommee = energie_consommee;
        this.dernier_utilisateur = user;
        this.station = station;
        this.tarif = tarif;


    }

    // Getters et Setters
    public int getId_borne() {
        return id_borne;
    }

    public void setId_borne(int id_borne) {
        this.id_borne = id_borne;
    }


    public Utilisateur getUser() {

        return dernier_utilisateur;
    }

    public void setUser(Utilisateur user) {
        this.dernier_utilisateur = user;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    // Si vous voulez définir l'état à partir d'une String (ex: depuis la base de données)
    public void setEtat(String etat) {
        this.etat = Etat.fromString(etat);
    }

    @Override
    public String toString() {
        return "Borne_Pompe{" +
                "id_borne=" + id_borne +
                ", type=" + type.getValue() +
                ", etat=" + etat.getValue() +
                "station=" + station +
                ", tarif=" + (tarif != null ? tarif.toString() : "null") +

                '}';
    }
    public void calculerCout() {
        if (tarif != null) {
            this.cout = this.energie_consommee * this.tarif.getTarif_par_kwh();
        } else {
            this.cout = 0; // Valeur par défaut si aucun tarif n'est défini
        }
    }

}
