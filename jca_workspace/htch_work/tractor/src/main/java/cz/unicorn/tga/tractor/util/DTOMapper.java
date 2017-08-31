/**
 * 
 */
package cz.unicorn.tga.tractor.util;

import java.util.List;

import org.mapstruct.Mapper;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarDTO;

@Mapper
public interface DTOMapper {

	CarDTO convert(final Car car);

	List<CarDTO> convert(final List<Car> cars);
}
