package banque.entite;

import javax.persistence.*;
import java.util.List;

@Entity
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
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

    public Banque(String nom) {
        this.nom = nom;
    }

    public Banque() {
    }
}
