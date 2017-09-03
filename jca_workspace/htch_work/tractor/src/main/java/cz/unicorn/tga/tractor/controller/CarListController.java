/**
 * 
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.FreeCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.model.CarFilter;
import cz.unicorn.tga.tractor.service.CarManagerService;
import cz.unicorn.tga.tractor.web.CommonConstants;

/**
 * @author DZCJS9F
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarListController {

	public static final String BASE_URL = CommonConstants.SLASH + "cars";

	@Autowired
	private CarManagerService carService;

	@RequestMapping(method = RequestMethod.GET)
	public CarDTO[] getAllCars() {
		final List<CarDTO> cars = carService.getAllCars();

		return cars.toArray(new CarDTO[cars.size()]);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public CarDTO[] findByFilter(final CarFilter carFilter) {

		final List<CarDTO> result = carService.findCarsByFilter(carFilter);

		return result.toArray(new CarDTO[result.size()]);
	}

	@RequestMapping(value = "/available", method = RequestMethod.POST)
	public CarDTO[] findAvailable(@RequestBody FreeCar freeCar) {

		final List<CarDTO> result = carService.findAvailableCars(freeCar);

		return result.toArray(new CarDTO[result.size()]);
	}

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
