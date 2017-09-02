/**
 * 
 */
package cz.unicorn.tga.tractor.util;

import java.util.List;

import cz.unicorn.tga.tractor.entity.*;
import cz.unicorn.tga.tractor.model.*;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

@Mapper
public interface DTOMapper {

	CarDTO convert(final Car car);
	List<CarDTO> convert(final List<Car> cars);

	ClientDTO convertClient(final Client client);
	List<ClientDTO> convertClient(final List<Client> clients);

	@Mapping(target = "car", source = "car.id")
    @Mapping(target = "client", source = "client.id")
    LendingDTO convertLending(final Lending lending);
    List<LendingDTO> convertLending(final List<Lending> lendings);

    @Mapping(target = "car", source = "car.id")
    RepairDTO convertRepair(final Repair repairs);
    List<RepairDTO> convertRepair(final List<Repair> repairs);

    @Mapping(target = "car", source = "car.id")
	StkDTO convertStk(final Stk stk);
    List<StkDTO> convertStk(final List<Stk> stks);

}
