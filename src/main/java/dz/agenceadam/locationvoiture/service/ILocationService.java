package dz.agenceadam.locationvoiture.service;

import dz.agenceadam.locationvoiture.dto.LocationDto;

public interface ILocationService {

	LocationDto saveOrUpdate(LocationDto dto,boolean save);
}
