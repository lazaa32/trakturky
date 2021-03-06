/**
 * 
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.*;

/**
 * @author DZCJS9F
 *
 */
public interface CarManagerService {

	void createNewCar(CarNewForm carNewForm);

	List<CarDTO> getAllCars();
	List<CarDTO> findAvailableCars(FreeCar freeCar);

	List<CarDTO> findCarsByFilter(CarFilter filter);

}
