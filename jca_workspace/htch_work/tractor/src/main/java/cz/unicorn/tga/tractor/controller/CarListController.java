/**
 * 
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

		// final CarFilter filter = new CarFilter(id, type, vin, state, priceFrom, priceTo, acquiredFrom, acquiredTo,
		// lastTechnicalCheckFrom, lastTechnicalCheckTo);
		final List<CarDTO> result = carService.findCarsByFilter(carFilter);

		return result.toArray(new CarDTO[result.size()]);
	}

//    @RequestMapping(value = "/overview", method = RequestMethod.GET)
//    public CarOverview[] carOverview() {
//        final List<CarOverview> cars = carService.getOverview();
//
//        return cars.toArray(new CarOverview[cars.size()]);
//    }

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
