package com.n3o.springpetclinic.services.map;

import com.n3o.springpetclinic.model.Visit;
import com.n3o.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet()==null || visit.getPet().getOwner()==null ||
                visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
