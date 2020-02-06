package com.n3o.springpetclinic.services.map;

import com.n3o.springpetclinic.model.Vet;
import com.n3o.springpetclinic.services.CrudService;

import java.util.Set;

public class VetMapService  extends AbstractMapService<Vet,Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }
}
