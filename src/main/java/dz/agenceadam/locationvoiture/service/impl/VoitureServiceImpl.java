package dz.agenceadam.locationvoiture.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Service;
import dz.agenceadam.locationvoiture.dto.VoitureDto;
import dz.agenceadam.locationvoiture.entities.Assurance;
import dz.agenceadam.locationvoiture.entities.ParametrageRevision;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.repository.AssuranceRepository;
import dz.agenceadam.locationvoiture.repository.ParametrageRevisionRepository;
import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private AssuranceRepository assuranceRepository;
	
	@Autowired
	private ParametrageRevisionRepository parametrageRevisionRepository;

	@Override
	public VoitureDto saveOrUpdate(VoitureDto voitureDto,Integer idUser,Boolean save) throws DataFoundedException 
	{
		
		User user = GenericBuilder.of(User::new)
	    		   .with(User::setId, idUser).build();
		
		Voiture voiture = GenericBuilder.of(Voiture::new)
				.with(Voiture::setActived, Boolean.TRUE)
				.with(Voiture::setAnneeFabrication, voitureDto.getAnneeFabrication())
				.with(Voiture::setCarburantActuel, voitureDto.getCarburantActuel())
				.with(Voiture::setCouleur,voitureDto.getCouleur())
				.with(Voiture::setEnergie, voitureDto.getEnergie())
				.with(Voiture::setImmatricule,voitureDto.getImmatricule())
				.with(Voiture::setKilommetrage,voitureDto.getKilommetrage())
				.with(Voiture::setMarque, voitureDto.getMarque())
				.with(Voiture::setModele,voitureDto.getModele())
				.with(Voiture::setObservation, voitureDto.getObservation())
				.with(Voiture::setPrixAchat,voitureDto.getPrixAchat())
				.with(Voiture::setPrixLocation, voitureDto.getPrixLocation())
				.with(Voiture::setRoueDeSecours, voitureDto.getRoueDeSecours())
				.with(Voiture::setTypeVehicule, voitureDto.getTypeVehicule())
				.build();
		
		voiture.setUser(user);
		Voiture voitureExiste = voitureRepository.findVoitureByImmatricule(voitureDto.getImmatricule());
		if(voitureExiste != null && save)
		{
		    	throw new DataFoundedException("la voiture existe dans la base de données");
		}
		if(!save)
		{
		    	voiture.setId(voitureDto.getId());
		    	List<Assurance> listeAssurance = assuranceRepository.findListeAssuranceByVoiture(voitureDto.getId());
		    	if(!listeAssurance.isEmpty())
		    	{
		    		listeAssurance.forEach(assurance ->{
			    		assuranceRepository.delete(assurance);
			    	});
		    	}	
		}
		voitureRepository.save(voiture);
		if( ! voitureDto.getListeAssuranceDto().isEmpty())
		{
			voitureDto.getListeAssuranceDto().forEach(dto->{
				Assurance assurance;
				try {
					assurance = GenericBuilder.of(Assurance::new)
							.with(Assurance::setDateExpiration,IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateExpiration()))
							.with(Assurance::setTypeAssurance, dto.getTypeAssurance())
							.build();
					assurance.setPrixAchat(dto.getPrixAchat());
					assurance.setVoiture(voiture);
					
					assuranceRepository.save(assurance);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				
			});
		}
		if(save)
		{
			addParametrageRevision(voiture);
		}
		return voitureDto;
	}

	private void addParametrageRevision(Voiture voiture) {
		ParametrageRevision parametrageRevision = GenericBuilder.of(ParametrageRevision::new)
				.with(ParametrageRevision::setVidange, 10000)
				.with(ParametrageRevision::setBougiesAllumage, 100000)
				.with(ParametrageRevision::setFiltreAair, 20000)
				.with(ParametrageRevision::setFiltreAgasoil, 60000)
				.with(ParametrageRevision::setFiltreAhuile, 20000)
				.with(ParametrageRevision::setKitDembrayage, 100000)
				.with(ParametrageRevision::setKitDistribution, 60000)
				.with(ParametrageRevision::setPlaquettes, 40000)
				.with(ParametrageRevision::setPneus, 60000)
				.with(ParametrageRevision::setRotules, 40000)
				.with(ParametrageRevision::setRoulements, 100000)
				.with(ParametrageRevision::setSuspensions, 100000)
				.with(ParametrageRevision::setVoiture, voiture)
				.build();
		parametrageRevisionRepository.save(parametrageRevision);
	}

	@Override
	public List<Voiture> findAll() {

		return voitureRepository.findAllVoitureActived();
	}

	@Override
	public List<Voiture> findVoitureByMarque(String marque) {
		return voitureRepository.findVoitureByMarque(marque);
	}

	@Override
	public List<Object[]> findLastAssuranceVoiture(Integer id) throws DataFoundedException {
		
		List<Object[]>  data = voitureRepository.findLastAssuranceVoiture(id);
		if(data.get(0)[0] == null)
		{
			throw new DataFoundedException("l'assurance n'existe pas dans la base de données");
		}else
		{
			Date date = (Date) data.get(0)[0];
			if(date.before(new Date()))
			{
				throw new DataFoundedException("La date de l'assurance est Expirée : "+date);
			}
			
		}
		
		return voitureRepository.findLastAssuranceVoiture(id);
	}


}
