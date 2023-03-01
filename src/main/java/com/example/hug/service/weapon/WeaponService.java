package com.example.hug.service.weapon;

import com.example.hug.model.Weapon;
import com.example.hug.repository.IWeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeaponService implements IWeaponService {

    @Autowired
    private IWeaponRepository weaponRepository;

    @Override
    public Iterable<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    @Override
    public Optional<Weapon> findById(Long id) {
        return weaponRepository.findById(id);
    }

    @Override
    public Weapon save(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    @Override
    public void remove(Long id) {
        weaponRepository.deleteById(id);
    }

    @Override
    public Iterable<Weapon> findByNameContaining(String name) {
        return weaponRepository.findByNameContaining(name);
    }
}
