package tn.esprit.models;

public class Borne_Pompe {

    private int id_borne;
    private Type type;
    private Etat etat;
    private int id_station;

    // Enum pour Type
    public enum Type {
        BORNE("borne"),
        POMPE("pompe");

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
        DISPO("disponible"),
        NON_DISPO("indisponible");

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
    public Borne_Pompe( Type type, Etat etat,int id_station) {
        this.type = type;
        this.etat = etat;
        this.id_station = id_station;

    }
    public Borne_Pompe(Type type, Etat etat,int id_station,int id_borne) {

        this.type = type;
        this.etat = etat;
        this.id_station = id_station;
        this.id_borne = id_borne;


    }

    // Getters et Setters
    public int getId_borne() {
        return id_borne;
    }

    public void setId_borne(int id_borne) {
        this.id_borne = id_borne;
    }

    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
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
                "id_station=" + id_station +

                '}';
    }
}
