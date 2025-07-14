package vg.roberto.espinoza.hackathon.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "FichasBibliograficas", schema = "dbo")


public class FichaBibliografica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFicha")
    private Integer idFicha;
    
    @Column(name = "TipoDocumento")
    private String tipoDocumento;
    
    @Column(name = "Autor")
    private String autor;
    
    @Column(name = "Titulo")
    
    private String titulo;
    
    @Column(name = "AnioPublicacion")
    private Integer anioPublicacion;
    
    @Column(name = "Editorial")
    private String editorial;
    
    @Column(name = "NumeroEdicion")
    private String numeroEdicion;
    
    @Column(name = "NumeroPaginas")
    private Integer numeroPaginas;
    
    @Column(name = "Tema")
    private String tema;
    
    @Column(name = "FechaAgregada")
    @CreationTimestamp
    private LocalDate fechaAgregada;
    
    @Column(name = "Estado")
    private Boolean estado = true;
}
