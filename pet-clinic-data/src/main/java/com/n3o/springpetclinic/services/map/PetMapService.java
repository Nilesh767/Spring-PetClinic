package com.n3o.springpetclinic.services.map;

import com.n3o.springpetclinic.model.Pet;
import com.n3o.springpetclinic.services.CrudService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet,Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
