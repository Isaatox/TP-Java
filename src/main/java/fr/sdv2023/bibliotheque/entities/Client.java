    package fr.sdv2023.bibliotheque.entities;

    import javax.persistence.*;
    import java.util.List;

    @Entity
    public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "NOM")
        private String nom;

        @Column(name = "PRENOM")
        private String prenom;

        @OneToMany(mappedBy = "client")
        private List<Emprunt> emprunts;

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", emprunts=" + emprunts +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public Client(String nom, String prenom, List<Emprunt> emprunts) {
            this.nom = nom;
            this.prenom = prenom;
            this.emprunts = emprunts;
        }

        public Client() {
        }

        public List<Emprunt> getEmprunts() {
            return emprunts;
        }

        public void setEmprunts(List<Emprunt> emprunts) {
            this.emprunts = emprunts;
        }
    }
