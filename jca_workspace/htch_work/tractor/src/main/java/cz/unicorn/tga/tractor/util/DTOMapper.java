/**
 * 
 */
package cz.unicorn.tga.tractor.util;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.CarOverview;
import cz.unicorn.tga.tractor.model.StkDTO;
import cz.unicorn.tga.tractor.model.StkOverview;
import org.mapstruct.Mapper;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarDTO;

@Mapper
public interface DTOMapper {

	CarDTO convert(final Car car);

	List<CarDTO> convert(final List<Car> cars);
	List<CarOverview> convertToOverview(final List<Car> cars);
	List<StkOverview> convertToStkOverview(final List<Car> cars);

	StkDTO convertStk(final Stk stk);

    List<StkDTO> convertStk(final List<Stk> stks);

}
