package fr.sdv2023.bibliotheque;

import fr.sdv2023.bibliotheque.entities.Emprunt;
import fr.sdv2023.bibliotheque.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Emprunt> query1 = em.createQuery(
                "SELECT e FROM Emprunt e JOIN FETCH e.livres WHERE e.id = :id", Emprunt.class);
        query1.setParameter("id", 1);
        Emprunt emprunt = query1.getSingleResult();
        System.out.println("Emprunt n°" + emprunt.getId() + " :");
        for (Livre livre : emprunt.getLivres()) {
            System.out.println("- " + livre.getTitre() + " (" + livre.getAuteur() + ")");
        }

        TypedQuery<Emprunt> query2 = em.createQuery(
                "SELECT e FROM Emprunt e WHERE e.client.id = :id", Emprunt.class);
        query2.setParameter("id", 1);
        List<Emprunt> emprunts = query2.getResultList();
        System.out.println("Les emprunts du client :");
        for (Emprunt emp : emprunts) {
            System.out.println("- Emprunt n°" + emp.getId() + " :");
            for (Livre livre : emp.getLivres()) {
                System.out.println("  - " + livre.getTitre() + " (" + livre.getAuteur() + ")");
            }
        }

        em.close();

        emf.close();
    }
}
