/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.StkDTO;
import cz.unicorn.tga.tractor.model.StkFilter;

/**
 * @author DZCJS9F
 *
 */
public interface StkManagerService {
    List<StkDTO> findStksByFilter(StkFilter lendingFilter);
    List<StkDTO> getAllStks();

}