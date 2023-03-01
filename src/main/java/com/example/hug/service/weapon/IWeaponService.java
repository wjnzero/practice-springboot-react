package com.example.hug.service.weapon;

import com.example.hug.model.Weapon;
import com.example.hug.service.GenericService;

public interface IWeaponService extends GenericService<Weapon> {
    Iterable<Weapon> findByNameContaining(String name);
}
