package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.repository.EtudiantRepository;
import sn.supinfo.projetexamen.service.DTO.EtudiantDTO;
import sn.supinfo.projetexamen.service.Mapper.EtudiantMapper;


@Service
public class EtudiantService {

    @Autowired
    private EtudiantMapper etudiantMapper;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Transactional
    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        return etudiantMapper.toDto(etudiantRepository.save(etudiant));
    }

    public EtudiantDTO findById(Long id) {
        return etudiantRepository.findById(id)
                .map(etudiantMapper::toDto)
                .orElse(null);
    }


}
