/**
 *
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.LendingDTO;
import cz.unicorn.tga.tractor.model.LendingFilter;
import cz.unicorn.tga.tractor.service.LendingManagerService;
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
@RequestMapping(value = LendingListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LendingListController {

    public static final String BASE_URL = CommonConstants.SLASH + "lendings";

    @Autowired
    private LendingManagerService lendingService;

    @RequestMapping(method = RequestMethod.GET)
    public LendingDTO[] getAllLendings() {
        final List<LendingDTO> lendings = lendingService.getAllLendings();

        return lendings.toArray(new LendingDTO[lendings.size()]);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public LendingDTO[] findByFilter(final LendingFilter lendingFilter) {

        final List<LendingDTO> result = lendingService.findLendingsByFilter(lendingFilter);

        return result.toArray(new LendingDTO[result.size()]);
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
