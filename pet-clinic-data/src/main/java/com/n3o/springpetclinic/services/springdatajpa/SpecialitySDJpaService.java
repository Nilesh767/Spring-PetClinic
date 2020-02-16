package com.n3o.springpetclinic.services.springdatajpa;

import com.n3o.springpetclinic.model.Speciality;
import com.n3o.springpetclinic.repositories.SpecialityRepository;
import com.n3o.springpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

public class SpecialitySDJpaService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }
}
