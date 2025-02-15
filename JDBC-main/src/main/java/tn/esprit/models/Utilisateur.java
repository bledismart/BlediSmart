package tn.esprit.models;


import java.util.List;


public class Utilisateur {

 private int id_user;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    private List<Station> stations;  // Liste des stations appartenant à l'utilisateur

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(int id_user,String nom,String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.id_user = id_user;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters et Setters
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return nom;
    }

    public void setPrenom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_user=" + id_user +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +

                ", email='" + email + '\'' +
                '}';
    }
}
