package vg.roberto.espinoza.hackathon.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vg.roberto.espinoza.hackathon.model.FichaBibliografica;
import vg.roberto.espinoza.hackathon.service.FichasBibliograficasService;


@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/fichas") // Define el path base para todos los endpoints de este controlador
@RequiredArgsConstructor // Inyecta automáticamente el servicio FichasBibliograficasService

public class FichasBibliograficasRest {
    
     private final FichasBibliograficasService fichasService;

    @GetMapping
    public List<FichaBibliografica> getAll() {
        return fichasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaBibliografica> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(fichasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FichaBibliografica> create(@RequestBody FichaBibliografica ficha) {
        return ResponseEntity.ok(fichasService.save(ficha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaBibliografica> update(@PathVariable Integer id, @RequestBody FichaBibliografica ficha) {
        return ResponseEntity.ok(fichasService.update(id, ficha));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        fichasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<FichaBibliografica> restore(@PathVariable Integer id) {
        return ResponseEntity.ok(fichasService.restore(id));
    }

    @GetMapping("/estado/{estado}")
    public List<FichaBibliografica> getByEstado(@PathVariable Boolean estado) {
        return fichasService.findByEstado(estado);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getPdfReport() throws Exception {
        byte[] pdf = fichasService.generateJasperPdfReport();
        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename=fichas.pdf")
                .body(pdf);
    }
    
}
