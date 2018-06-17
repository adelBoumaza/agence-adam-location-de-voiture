package dz.agenceadam.locationvoiture.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class PersistenceUtil {

	@PersistenceContext
	protected EntityManager entityManager;
}
