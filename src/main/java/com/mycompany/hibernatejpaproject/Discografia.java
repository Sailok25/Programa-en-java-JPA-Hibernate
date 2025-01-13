package com.mycompany.hibernatejpaproject;

// Importació de classes necessàries per a JPA
import jakarta.persistence.*;
import java.util.List;

@Entity // Indica que aquesta classe és una entitat de la base de dades.
@Table(name = "discografia") // Defineix el nom de la taula a la base de dades.
public class Discografia {

    @Id // Defineix la clau primària.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // L'ID es generarà automàticament.
    private int idDiscografia;

    @Column(unique = true, nullable = false) //El camp es unic y no pot ser null
    private String nomDiscografia;

    @OneToMany(mappedBy = "discografia") // Tipus de relació
    private List<Artista> artistes; 

    // Getters i Setters
    public int getIdDiscografia() {
        return idDiscografia; 
    }

    public void setIdDiscografia(int idDiscografia) {
        this.idDiscografia = idDiscografia; 
    }

    public String getNomDiscografia() {
        return nomDiscografia;
    }

    public void setNomDiscografia(String nomDiscografia) {
        this.nomDiscografia = nomDiscografia;
    }

    public List<Artista> getArtistes() {
        return artistes; 
    }

    public void setArtistes(List<Artista> artistes) {
        this.artistes = artistes;
    }
}
