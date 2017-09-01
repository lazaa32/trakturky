package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Stk;
import org.springframework.data.jpa.repository.JpaRepository;

import cz.unicorn.tga.tractor.entity.Car;


public interface StkDAO extends JpaRepository<Stk,Long> {

}
