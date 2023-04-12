package fr.sdv2023;

import fr.sdv2023.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créer une instance d'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        // Créer une instance d'EntityManager
        EntityManager em = emf.createEntityManager();

        // Vérifier la connexion à la base de données
        if (em.isOpen()) {
            System.out.println("Connecté à la bdd");
//            String query = "SELECT b FROM Livre b WHERE b.id = :id";
//            Livre livre = em.createQuery(query, Livre.class)
//                    .setParameter("id", 4L)
//                    .getSingleResult();
//
//            System.out.println(livre.getTitre());
//            System.out.println(livre.getAuteur());

//            Livre livre = new Livre();
//            livre.setTitre("Le Petit Prince");
//            livre.setAuteur("Antoine de Saint-Exupéry");
//
//            em.getTransaction().begin();
//            em.persist(livre);
//            em.getTransaction().commit();

//            Livre livre = em.find(Livre.class, 5L);
//
//            livre.setTitre("Du plaisir dans la cuisine");
//
//            em.getTransaction().begin();
//            em.persist(livre);
//            em.getTransaction().commit();

//            String query = "SELECT b FROM Livre b WHERE b.titre = :titre";
//            List<Livre> livres = em.createQuery(query, Livre.class)
//                    .setParameter("titre", "Du plaisir dans la cuisine")
//                    .getResultList();
//
//            for (Livre livre : livres) {
//                System.out.println(livre.getTitre() + ", " + livre.getAuteur());
//            }

//            String query = "SELECT b FROM Livre b WHERE b.auteur = :auteur";
//            List<Livre> livres = em.createQuery(query, Livre.class)
//                    .setParameter("auteur", "Emile Zola")
//                    .getResultList();
//
//            for (Livre livre : livres) {
//                System.out.println(livre.getTitre() + ", " + livre.getAuteur());
//            }

//            Livre livre = em.find(Livre.class, 4L);
//
//            em.getTransaction().begin();
//            em.remove(livre);
//            em.getTransaction().commit();

            String query = "SELECT b FROM Livre b";
            List<Livre> livres = em.createQuery(query, Livre.class).getResultList();

            for (Livre livre : livres) {
                System.out.println(livre.getTitre() + ", " + livre.getAuteur());
            }
        } else {
            System.out.println("Erreur de connexion à la bdd");
        }

        // Fermer la connexion
        em.close();
        emf.close();
    }
}