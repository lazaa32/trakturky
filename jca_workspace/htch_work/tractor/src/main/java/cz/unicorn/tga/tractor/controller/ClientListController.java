/**
 *
 */
package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.ClientDTO;
import cz.unicorn.tga.tractor.service.ClientManagerService;
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
@RequestMapping(value = ClientListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientListController {

    public static final String BASE_URL = CommonConstants.SLASH + "clients";

    @Autowired
    private ClientManagerService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ClientDTO[] getAllClients() {
        final List<ClientDTO> clients = clientService.getAllClients();

        return clients.toArray(new ClientDTO[clients.size()]);
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
