package sn.supinfo.projetexamen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.service.ClasseService;
import sn.supinfo.projetexamen.service.DTO.ClasseDTO;
import sn.supinfo.projetexamen.service.Mapper.ClasseMapper;
import sn.supinfo.projetexamen.web.rest.ClasseResource;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @Autowired
    private ClasseMapper classeMapper;

    @PostMapping
    public ResponseEntity<ClasseDTO> createClasse(@RequestBody ClasseDTO classeDTO) {
        Classe classe = classeMapper.toEntity(classeDTO);
        Classe savedClasse = classeService.addClasse(classe);
        return ResponseEntity.ok(classeMapper.toDTO(savedClasse));
    }

    @GetMapping
    public List<ClasseDTO> listClasses() {
        return classeService.listClasses()
                .stream()
                .map(classeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseDTO> updateClasse(@PathVariable Long id, @RequestBody ClasseDTO classeDTO) {
        Classe classe = classeMapper.toEntity(classeDTO);
        Classe updatedClasse = classeService.updateClasse(id, classe);
        return ResponseEntity.ok(classeMapper.toDTO(updatedClasse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.ok(ClasseResource.CLASSE_DELETED_SUCCESS);
    }


}
