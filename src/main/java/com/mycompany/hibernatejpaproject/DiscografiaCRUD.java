package com.mycompany.hibernatejpaproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class DiscografiaCRUD {

private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAProjectPU");  // 

    // Funció per crear una nova Discografia
    public void crear(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.print("Introdueix el nom de la discografica: ");
            String nom = scanner.nextLine();

            Discografia discografia = new Discografia();
            discografia.setNomDiscografia(nom);

            em.getTransaction().begin();
            em.persist(discografia);
            em.getTransaction().commit();

            System.out.println("Discografia creada amb èxit!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al crear la discografia: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void llegir() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Discografia> discografies = em.createQuery("FROM Discografia", Discografia.class).getResultList();

            System.out.println("\n--- Llista de Discografiques ---");
            for (Discografia discografia : discografies) {
                System.out.println("ID: " + discografia.getIdDiscografia() + ", Nom: " + discografia.getNomDiscografia());
            }
        } catch (Exception e) {
            System.out.println("Error al llegir les discografiques: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void actualitzar(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.print("Introdueix l'ID de la discografica a actualitzar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Discografia discografia = em.find(Discografia.class, id);

            if (discografia == null) {
                System.out.println("No s'ha trobat cap discografica amb aquest ID.");
                return;
            }

            System.out.print("Introdueix el nou nom de la discografica: ");
            String nouNom = scanner.nextLine();

            em.getTransaction().begin();
            discografia.setNomDiscografia(nouNom);
            em.getTransaction().commit();

            System.out.println("Discografica actualitzada!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al actualitzar la discografica: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void eliminar(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.print("Introdueix l'ID de la discografica a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            Discografia discografia = em.find(Discografia.class, id);

            if (discografia == null) {
                System.out.println("No s'ha trobat cap discografia amb aquest ID.");
                return;
            }

            em.getTransaction().begin();
            em.remove(discografia);
            em.getTransaction().commit();

            System.out.println("Discografica eliminada!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al eliminar la discografica: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
