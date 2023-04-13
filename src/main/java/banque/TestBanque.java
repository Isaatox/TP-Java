package banque;

import banque.entite.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); // Start a transaction
        if(em.isOpen()){
            System.out.println("Open");
        } else {
            System.out.println("non open");
        }
        em.close(); // Close the EntityManager
        emf.close();
    }
}
