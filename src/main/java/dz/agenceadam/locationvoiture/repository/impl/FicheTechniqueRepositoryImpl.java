package dz.agenceadam.locationvoiture.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Parameter;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dz.agenceadam.locationvoiture.dao.util.PersistenceUtil;
import dz.agenceadam.locationvoiture.repository.custom.FicheTechniqueRepositoryCustom;
import dz.agenceadam.locationvoiture.search.FicheTechniqueObjectSearch;
public class FicheTechniqueRepositoryImpl extends PersistenceUtil implements FicheTechniqueRepositoryCustom {

	@Override
	public List<Object[]> findAllFicheTechniqueByVoiture(FicheTechniqueObjectSearch objectSearch) {
		StringBuilder sb = new StringBuilder();
		//Map<String, Object> params = new HashMap<String, Object>();
		final String req = "Select ft.pk_id as idFT,ft.km_revision,ft.prix_intervention,ft.type_revision," + 
				"ft.date_intervention,v.pk_id as idV,v.marque,v.modele,v.km_actuel," + 
				"( CASE " + 
				"  WHEN ft.type_revision = 'Vidange' THEN (ft.km_revision+ tbp.vidange ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Filtre à air' THEN (ft.km_revision+ tbp.filtre_aair ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Kit de distribution' THEN (ft.km_revision+ tbp.kit_distribution ) -  v.km_actuel " + 
				"  WHEN ft.type_revision = 'Kit d\\'embrayage' THEN (ft.km_revision+ tbp.kit_dembrayage ) -  v.km_actuel " + 
				"  WHEN ft.type_revision = 'Suspensions' THEN (ft.km_revision+ tbp.suspensions ) -  v.km_actuel " + 
				"  WHEN ft.type_revision = 'Plaquettes' THEN (ft.km_revision+ tbp.plaquettes ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Pneus' THEN (ft.km_revision+ tbp.pneus ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Roulements' THEN (ft.km_revision+ tbp.roulements ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Rotules' THEN (ft.km_revision+ tbp.rotules ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Filtre à gasoil' THEN (ft.km_revision+ tbp.filtre_agasoil ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Bougies allumage' THEN (ft.km_revision+ tbp.bougies_allumage ) -  v.km_actuel" + 
				"  WHEN ft.type_revision = 'Filtre à huile' THEN (ft.km_revision+ tbp.filtre_ahuile ) -  v.km_actuel END" + 
				") AS REST_A_ROULER " + 
				"FROM tb_fiche_technique ft " + 
				"JOIN tb_voiture v ON v.pk_id = ft.fk_voiture " + 
				"JOIN tb_parametrage_revision tbp on tbp.fk_voiture = v.pk_id ";
		sb.append(req);
		if (objectSearch != null) {
			if (objectSearch.getTypeRevision() != null
					&& !objectSearch.getTypeRevision().isEmpty()) 
			{
				sb.append(" AND ft.type_revision ='"+objectSearch.getTypeRevision()+"'");
				//params.put("typeRevision", dto.getTypeRevision());
			}
			if (objectSearch.getIdVoiture() != null
					&& objectSearch.getIdVoiture() != 0) 
			{
				sb.append(" AND v.pk_id ="+objectSearch.getIdVoiture());
			}
			
			if (objectSearch.getMarque() != null
					&& ! objectSearch.getMarque().isEmpty()) 
			{
				sb.append(" AND v.marque ='"+objectSearch.getMarque()+"'");
			}
		}
		sb.append(" order by ft.date_intervention desc");
		Query query = entityManager.createNativeQuery(sb.toString());
		
/*		System.out.println(query.getParameters().size());
		System.out.println(query.getParameterValue(1));
		for (Parameter<?> c : query.getParameters()) {
			query.setParameter(c.getName(), params.get(c.getName()));
		}*/
		
		return query.getResultList();
	}

	
}
