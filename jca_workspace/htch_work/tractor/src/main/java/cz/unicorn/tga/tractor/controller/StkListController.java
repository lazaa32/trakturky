/**
 *
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.*;
import cz.unicorn.tga.tractor.service.StkManagerService;
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
@RequestMapping(value = StkListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class StkListController {

    public static final String BASE_URL = CommonConstants.SLASH + "stk";

    @Autowired
    private StkManagerService stkService;

    @RequestMapping(method = RequestMethod.GET)
    public StkDTO[] getAllStks() {
        final List<StkDTO> stks = stkService.getAllStks();

        return stks.toArray(new StkDTO[stks.size()]);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public StkDTO[] findByFilter(final StkFilter stkFilter) {

        final List<StkDTO> result = stkService.findStksByFilter(stkFilter);

        return result.toArray(new StkDTO[result.size()]);
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
