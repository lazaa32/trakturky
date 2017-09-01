package cz.unicorn.tga.tractor.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarFilter;
import cz.unicorn.tga.tractor.util.QueryBuilder;

@Repository
public class CarFilterDAOImpl extends GenericHibernateDAO<Car,Long> implements CarFilterDAO {

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public List<Car> findByFilter(final CarFilter filter) {
		final Query query = createQueryFromCarFilter(filter);

		return query.list();
	}

	private Query createQueryFromCarFilter(final CarFilter filter) {
		final QueryBuilder builder = new QueryBuilder(getSession(), "SELECT c FROM Car c WHERE 1 = 1");

		builder.appendIfNotNull("AND c.id = :id", "id", filter.getId());
		builder.appendIfNotNull("AND c.vin = :vin", "vin", filter.getVin());
		builder.appendIfNotNull("AND c.type = :type", "type", filter.getType());
		builder.appendIfNotNull("AND c.state = :state", "state", filter.getState());
		builder.appendIfNotNull("AND c.dateOfAcquisition >= :acquiredFrom", "acquiredFrom", filter.getAcquiredFrom());
		builder.appendIfNotNull("AND c.dateOfAcquisition <= :acquiredTo", "acquiredTo", filter.getAcquiredTo());
		builder.appendIfNotNull("AND c.dateOfLastTechnicalCheck >= :checkFrom", "checkFrom",
				filter.getLastTechnicalCheckFrom());
		builder.appendIfNotNull("AND c.dateOfLastTechnicalCheck <= :checkTo", "checkTo",
				filter.getLastTechnicalCheckTo());
		builder.appendIfNotNull("AND c.price >= :priceFrom", "priceFrom", filter.getPriceFrom());
		builder.appendIfNotNull("AND c.price <= :priceTo", "priceTo", filter.getPriceTo());
		builder.appendIfNotNull("AND c.nickname = :nickname", "nickname", filter.getNickname());

		return builder.build();
	}

}
