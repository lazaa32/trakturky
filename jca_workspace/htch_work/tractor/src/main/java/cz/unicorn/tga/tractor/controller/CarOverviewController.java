/**
 *
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.CarOvFilter;
import cz.unicorn.tga.tractor.model.CarOverviewDTO;
import cz.unicorn.tga.tractor.service.CarOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.unicorn.tga.tractor.web.CommonConstants;

/**
 * @author DZCJS9F
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarOverviewController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarOverviewController {

    public static final String BASE_URL = CommonConstants.SLASH + "case2";

    @Autowired
    private CarOverviewService carOverviewService;

    @RequestMapping(method = RequestMethod.GET)
    public CarOverviewDTO[] carOverview() {
        final List<CarOverviewDTO> cars = carOverviewService.getOverview();

        return cars.toArray(new CarOverviewDTO[cars.size()]);
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
