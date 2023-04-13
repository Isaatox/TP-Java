package banque.entite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", clients=" + clients +
                ", operations=" + operations +
                '}';
    }

    private Double solde;
    @OneToMany(mappedBy = "compte")
    private List<Client> clients;
    @OneToMany(mappedBy = "compte")
    private List<Operation> operations = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Compte(String numero, Double solde, List<Client> clients, List<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    public Compte() {
    }
}
