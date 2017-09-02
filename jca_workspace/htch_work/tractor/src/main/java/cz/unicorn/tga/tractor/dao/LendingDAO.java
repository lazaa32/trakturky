package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Lending;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LendingDAO extends JpaRepository<Lending,Long> {

}