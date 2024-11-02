package sn.supinfo.projetexamen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.service.DTO.EtudiantDTO;
import sn.supinfo.projetexamen.service.EtudiantService;
import sn.supinfo.projetexamen.service.Mapper.EtudiantMapper;
import sn.supinfo.projetexamen.web.rest.EtudiantResource;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private EtudiantMapper etudiantMapper;

    @PostMapping
    public ResponseEntity<EtudiantDTO> createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);
        return ResponseEntity.ok(etudiantMapper.toDTO(savedEtudiant));
    }

    @GetMapping
    public List<EtudiantDTO> listEtudiants() {
        return etudiantService.listEtudiants()
                .stream()
                .map(etudiantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiantMapper.toDTO(etudiant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDTO> updateEtudiant(@PathVariable Long id, @RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiant);
        return ResponseEntity.ok(etudiantMapper.toDTO(updatedEtudiant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok(EtudiantResource.ETUDIANT_NOT_FOUND);
    }


}
