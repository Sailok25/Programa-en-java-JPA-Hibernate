package com.mycompany.hibernatejpaproject;

import java.util.Scanner;

public class HibernateJPAProject {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcio;
            
            do {
                System.out.println("=== Menú Principal ===");
                System.out.println("1. Menu per gestionar Discografiques");
                System.out.println("2. Menu per gestionar Artistes");
                System.out.println("3. Tancar programa");
                System.out.print("Selecciona una opció: ");
                opcio = scanner.nextInt();
                scanner.nextLine();
                
                
                // El switch esta montat amb la nova clausula de Java
                switch (opcio) {
                    case 1 -> gestionarDiscografies(scanner);
                    case 2 -> gestionarArtistes(scanner);
                    case 3 -> System.out.println("Sortint del programa...");
                    default -> System.out.println("Opció no vàlida.");
                }
            } while (opcio != 3);
        }
    }

    
    // Funció per mostrar menu de gestion de Discografies
    private static void gestionarDiscografies(Scanner scanner) {
        DiscografiaCRUD discografiaCRUD = new DiscografiaCRUD();
        int subOpcio;

        do {
            System.out.println("\n--- Menú de Discografiques ---");
            System.out.println("1. Crear Discografica");
            System.out.println("2. Llegir Discografiques");
            System.out.println("3. Actualitzar Discografica");
            System.out.println("4. Eliminar Discografica");
            System.out.println("5. Tornar al menú principal");
            System.out.print("Selecciona una opció: ");
            subOpcio = scanner.nextInt();
            scanner.nextLine();

            // El switch esta montat amb la nova clausula de Java
            switch (subOpcio) {
                case 1 -> discografiaCRUD.crear(scanner);
                case 2 -> discografiaCRUD.llegir();
                case 3 -> discografiaCRUD.actualitzar(scanner);
                case 4 -> discografiaCRUD.eliminar(scanner);
                case 5 -> System.out.println("Tornant al menú principal...");
                default -> System.out.println("Opció no vàlida.");
            }
        } while (subOpcio != 5);
    }

    
    // Funció per mostrar menu de gestion de Artistes
    private static void gestionarArtistes(Scanner scanner) {
        ArtistaCRUD artistaCRUD = new ArtistaCRUD();
        int subOpcio;

        do {
            System.out.println("\n--- Menú d'Artistes ---");
            System.out.println("1. Crear Artista");
            System.out.println("2. Llegir Artistes");
            System.out.println("3. Actualitzar Artista");
            System.out.println("4. Eliminar Artista");
            System.out.println("5. Tornar al menú principal");
            System.out.print("Selecciona una opció: ");
            subOpcio = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcio) {
                case 1 -> artistaCRUD.crear(scanner);
                case 2 -> artistaCRUD.llegir();
                case 3 -> artistaCRUD.actualitzar(scanner);
                case 4 -> artistaCRUD.eliminar(scanner);
                case 5 -> System.out.println("Tornant al menú principal...");
                default -> System.out.println("Opció no vàlida.");
            }
        } while (subOpcio != 5);
    }
}
