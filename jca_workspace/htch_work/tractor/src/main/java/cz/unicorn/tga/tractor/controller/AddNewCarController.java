package cz.unicorn.tga.tractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import cz.unicorn.tga.tractor.model.CarNewForm;
import cz.unicorn.tga.tractor.service.CarManagerService;
import cz.unicorn.tga.tractor.web.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = AddNewCarController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AddNewCarController {

	public static final String BASE_URL = CommonConstants.SLASH + "cars/new";
	public final static String FORM_ATTRIBUTE_NAME = "carNewForm";

	@Autowired
	private CarManagerService carManagerService;

	@Autowired
	private MessageSource messageSource;

	/*
	 * Provede ulozeni vozidla URI: /cars/new Method: POST
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void addNewCar(@RequestBody final CarNewForm carNewForm) {

		// TODO Validate model
		carManagerService.createNewCar(carNewForm);

		return;

	}

	/*
	 * **********************************************************************
	 * PRIVATE METHODS
	 * **********************************************************************
	 */

	@InitBinder(AddNewCarController.FORM_ATTRIBUTE_NAME)
	protected void initBinder(final WebDataBinder binder) {

		// BigDecimal custom binder
		ControllerUtils.setNumberCustomEditorToBinder(binder, CommonConstants.CZECH_LOCALE);

		// trim all string
		ControllerUtils.setStringTrimmerEditorToBinder(binder);
	}

}
