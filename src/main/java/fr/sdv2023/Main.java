package fr.sdv2023;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Main {
    public static void main(String[] args) {
        // Créer une instance d'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        // Créer une instance d'EntityManager
        EntityManager em = emf.createEntityManager();

        // Vérifier la connexion à la base de données
        if (em.isOpen()) {
            System.out.println("Connecté à la bdd");
        } else {
            System.out.println("Erreur de connexion à la bdd");
        }

        // Fermer la connexion
        em.close();
        emf.close();
    }
}