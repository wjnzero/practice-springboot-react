package com.example.hug.repository;

import com.example.hug.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeaponRepository extends JpaRepository<Weapon,Long> {
    @Query(value = "select * from  weapon w where w.name like %:name%", nativeQuery = true)
    Iterable<Weapon> findByNameContaining(@Param("name") String name);
}
