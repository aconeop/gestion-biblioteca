package com.biblioteca.gestion_biblioteca.model;

import jakarta.persistence.*;
import java.util.List; // Importación necesaria
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "anio_publicacion", nullable = false)
    private int anioPublicacion;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String estado; // disponible, prestado, reservado, deteriorado

    // 🔹 CORRECCIÓN: Relación bidireccional con Prestamo para mapeo completo (mappedBy="libro")
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;

    // 🔹 Constructor vacío (obligatorio para JPA)
    public Libro() {}

    // 🔹 Constructor con parámetros
    public Libro(String titulo, String autor, int anioPublicacion, String categoria, String estado) {
        setTitulo(titulo);
        setAutor(autor);
        setAnioPublicacion(anioPublicacion);
        setCategoria(categoria);
        setEstado(estado);
    }

    // ===== Getters y Setters con validaciones =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        this.titulo = titulo;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        this.autor = autor;
    }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicación debe ser mayor que 0");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
        this.categoria = categoria;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        if (estado == null ||
                !(estado.equalsIgnoreCase("disponible") ||
                        estado.equalsIgnoreCase("prestado") ||
                        estado.equalsIgnoreCase("reservado") ||
                        estado.equalsIgnoreCase("deteriorado"))) {
            throw new IllegalArgumentException("El estado debe ser disponible, prestado, reservado o deteriorado");
        }
        this.estado = estado.toLowerCase();
    }

    // 🔹 GETTER/SETTER AGREGADO para la relación
    public List<Prestamo> getPrestamos() { return prestamos; }
    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }
}