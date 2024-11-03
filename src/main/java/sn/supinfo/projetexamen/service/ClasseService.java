package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.repository.ClasseRepository;
import sn.supinfo.projetexamen.service.DTO.ClasseDTO;
import sn.supinfo.projetexamen.service.Mapper.ClasseMapper;


@Service
public class ClasseService {

    @Autowired
    private ClasseMapper classeMapper;

    @Autowired
    private ClasseRepository classeRepository;

    @Transactional
    public ClasseDTO save(ClasseDTO classeDTO) {
        Classe classe = classeMapper.toEntity(classeDTO);
        return classeMapper.toDto(classeRepository.save(classe));
    }

    public ClasseDTO findById(Long id) {
        return classeRepository.findById(id)
                .map(classeMapper::toDto)
                .orElse(null);
    }

}
