package com.example.hug.controller;

import com.example.hug.model.Weapon;
import com.example.hug.service.weapon.IWeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/weapons")
public class WeaponController {
    @Autowired
    private IWeaponService weaponService;

    @GetMapping()
    public ResponseEntity<Iterable<Weapon>> findAllWeapon() {
        Iterable<Weapon> weapons = weaponService.findAll();
        return new ResponseEntity<>(weapons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> findWeaponById(@PathVariable Long id) {
        Weapon weapons = weaponService.findById(id).get();
        return new ResponseEntity<>(weapons, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon weapon) {
        weaponService.save(weapon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Weapon> updateWeapon(@PathVariable Long id, @RequestBody Weapon weapon1) {
        Optional<Weapon> weapon = weaponService.findById(id);
        if (!weapon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        weapon.get().setName(weapon1.getName());
        weapon.get().setColor(weapon1.getColor());
        weapon.get().setDmg(weapon1.getDmg());
        weaponService.save(weapon.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Weapon> deleteWeapon(@PathVariable Long id) {
        Optional<Weapon> weapon = weaponService.findById(id);
        if (!weapon.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        weaponService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Weapon>> findWeaponByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(weaponService.findByNameContaining(name), HttpStatus.OK);
    }
}
