/**
 * 
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.model.CarFilter;
import cz.unicorn.tga.tractor.model.CarNewForm;

/**
 * @author DZCJS9F
 *
 */
public interface CarManagerService {

	void createNewCar(CarNewForm carNewForm);

	List<CarDTO> getAllCars();

	List<CarDTO> findCarsByFilter(CarFilter filter);

}
