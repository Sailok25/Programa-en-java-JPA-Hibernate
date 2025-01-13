package com.mycompany.hibernatejpaproject;

// Importació de classes necessàries per a JPA
import jakarta.persistence.*;

@Entity // Indica que aquesta classe és una entitat de la base de dades.
@Table(name = "artista") // Defineix el nom de la taula a la base de dades.
public class Artista {

    @Id // Defineix la clau primària.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // L'ID es generarà automàticament.
    private Long idArtista; 

    @Column(unique = true, nullable = false) // Defineix que aquest camp és únic i no pot ser nul.
    private String nomArtista; 

    @Column(nullable = false) // El camp no pot ser null.
    private int edatArtista; 

    @Column(nullable = false) // El camp no pot ser null.
    private String genereMusical;

    @Column(nullable = false) // El camp no pot ser null.
    private int quantitatCancons; 

    @ManyToOne // Tipus de relació
    @JoinColumn(name = "idDiscografia")
    private Discografia discografia; 

    // Getters i Setters
    public Long getIdArtista() {
        return idArtista; 
    }

    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }

    public String getNomArtista() {
        return nomArtista;
    }

    public void setNomArtista(String nomArtista) {
        this.nomArtista = nomArtista; 
    }

    public int getEdatArtista() {
        return edatArtista; 
    }

    public void setEdatArtista(int edatArtista) {
        this.edatArtista = edatArtista; 
    }

    public String getGenereMusical() {
        return genereMusical; 
    }

    public void setGenereMusical(String genereMusical) {
        this.genereMusical = genereMusical; 
    }

    public int getQuantitatCancons() {
        return quantitatCancons; 
    }

    public void setQuantitatCancons(int quantitatCancons) {
        this.quantitatCancons = quantitatCancons; 
    }

    public Discografia getDiscografia() {
        return discografia;
    }

    public void setDiscografia(Discografia discografia) {
        this.discografia = discografia; 
    }
}
