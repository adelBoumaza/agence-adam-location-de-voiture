package dz.agenceadam.locationvoiture.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ParametrageRevisionDto;


public interface IParametrageRevisionService {

   List<ParametrageRevisionDto>	findAllParametrageRevision();
   
   ParametrageRevisionDto updateParametrageRevision(ParametrageRevisionDto dto,Integer idvoiture);
}
