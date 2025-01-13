package com.mycompany.hibernatejpaproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ArtistaCRUD {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAProjectPU");

        // Funció per crear un nou artista.
    public void crear(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.print("Introdueix el nom de l'artista: ");
            String nom = scanner.nextLine();

            System.out.print("Introdueix l'edat de l'artista: ");
            int edat = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Introdueix el gènere musical: ");
            String genere = scanner.nextLine();

            System.out.print("Introdueix la quantitat de cançons: ");
            int quantitatCancons = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Introdueix l'ID de la discografia associada: ");
            int idDiscografia = scanner.nextInt();
            scanner.nextLine();

            // Busca la discografica amb l'ID proporcionat. Si no existeix petará.
            Discografia discografia = em.find(Discografia.class, idDiscografia);
            if (discografia == null) {
                System.out.println("No s'ha trobat cap discografica amb aquest ID.");
                return;
            }
            
            // Crea un nou Artista amb les dades donades
            Artista artista = new Artista();
            artista.setNomArtista(nom);
            artista.setEdatArtista(edat);
            artista.setGenereMusical(genere);
            artista.setQuantitatCancons(quantitatCancons);
            artista.setDiscografia(discografia);

            em.getTransaction().begin();
            em.persist(artista);
            em.getTransaction().commit();

            System.out.println("Artista creat!");
        } catch (Exception e) {
            // En cas que falli, es fa rollback.
            em.getTransaction().rollback();
            System.out.println("Error al crear l'artista: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Funció per llegir un nou artista.
    public void llegir() {
        EntityManager em = emf.createEntityManager();

        try {
            // Consulta per obtenir tots els artistes
            List<Artista> artistes = em.createQuery("FROM Artista", Artista.class).getResultList();

            // Mostra la informació de tots els artistes.
            System.out.println("\n--- Llista d'Artistes ---");
            for (Artista artista : artistes) {
                System.out.println("ID: " + artista.getIdArtista()
                        + ", Nom: " + artista.getNomArtista()
                        + ", Edat: " + artista.getEdatArtista()
                        + ", Gènere: " + artista.getGenereMusical()
                        + ", Cançons: " + artista.getQuantitatCancons()
                        + ", Discografia: " + artista.getDiscografia().getNomDiscografia());
            }
        } catch (Exception e) {
            System.out.println("Error al llegir els artistes: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Funció per actualitzar un nou artista.
    public void actualitzar(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            // Busca si el artista existeix amb el id passat
            System.out.print("Introdueix l'ID de l'artista a actualitzar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Artista artista = em.find(Artista.class, id);

            // Si no existeix peta
            if (artista == null) {
                System.out.println("No s'ha trobat cap artista amb aquest ID.");
                return;
            }
            
            // Entrada de les noves dades per a l'artista seleccionat.
            System.out.print("Introdueix el nou nom de l'artista: ");
            String nouNom = scanner.nextLine();
            System.out.print("Introdueix la nova edat de l'artista: ");
            int novaEdat = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Introdueix el nou gènere musical: ");
            String nouGenere = scanner.nextLine();
            System.out.print("Introdueix la nova quantitat de cançons: ");
            int novaQuantitatCancons = scanner.nextInt();
            scanner.nextLine();

            // Actualitza els camps de l'artista.
            em.getTransaction().begin();
            artista.setNomArtista(nouNom);
            artista.setEdatArtista(novaEdat);
            artista.setGenereMusical(nouGenere);
            artista.setQuantitatCancons(novaQuantitatCancons);
            em.getTransaction().commit();

            System.out.println("Artista actualitzat!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al actualitzar l'artista: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Funció per eliminar un nou artista.
    public void eliminar(Scanner scanner) {
        EntityManager em = emf.createEntityManager();

        try {
            // Busca si el ID passat coinxideix amb algun artista de la bd
            System.out.print("Introdueix l'ID de l'artista a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            Artista artista = em.find(Artista.class, id);
            
            // Si no existeix peta
            if (artista == null) {
                System.out.println("No s'ha trobat cap artista amb aquest ID.");
                return;
            }

            // Parametres per eliminar el artista
            em.getTransaction().begin();
            em.remove(artista);
            em.getTransaction().commit();

            System.out.println("Artista eliminat");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al eliminar l'artista: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
