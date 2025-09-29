package com.biblioteca.gestion_biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros") // nombre de la tabla en la base de datos
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "anio_publicacion")
    private int anioPublicacion;

    private String categoria;

    private String estado; // disponible, prestado, reservado, deteriorado

    // 🔹 Constructor vacío (obligatorio para JPA)
    public Libro() {}

    // 🔹 Constructor con parámetros
    public Libro(String titulo, String autor, int anioPublicacion, String categoria, String estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
        this.estado = estado;
    }

    // 🔹 Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
