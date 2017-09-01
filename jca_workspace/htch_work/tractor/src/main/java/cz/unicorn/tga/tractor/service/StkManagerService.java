/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.StkDTO;
import cz.unicorn.tga.tractor.model.StkOverview;

/**
 * @author DZCJS9F
 *
 */
public interface StkManagerService {

    List<StkDTO> getAllStks();

}