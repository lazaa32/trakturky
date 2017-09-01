/**
 * 
 */
package cz.unicorn.tga.tractor.util;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkDTO;
import org.mapstruct.Mapper;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarDTO;
import org.mapstruct.Mapping;

@Mapper
public interface DTOMapper {

	CarDTO convert(final Car car);
	List<CarDTO> convert(final List<Car> cars);

	@Mapping(target = "car", source = "car.id")
	StkDTO convertStk(final Stk stk);
    List<StkDTO> convertStk(final List<Stk> stks);

}
