package com.recipebook.ws.service;

import com.recipebook.ws.entity.Stock;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.entity.Utensil;
import com.recipebook.ws.repository.UtensilRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtensilService {

    @Autowired
    private final UtensilRepository utensilRepository;

    public List<Utensil> retrieveAllUtensil(){
        log.info("Retrieving all utensils in DB");
        List<Utensil> utensils = utensilRepository.findAll();
        log.info("{} elements retrieved", utensils.size());
        return utensils;
    }

    public Utensil retrieveUtensil(int id){
        log.info("Retrieving one utensil with {} in id", id);
        Utensil utensil = utensilRepository.findById(id);
        log.info("{} retrieved", utensil.getName());
        return utensil;
    }

    public Utensil createUtensil(Utensil utensil) {
        log.info("create one utensil in DB");
        return utensilRepository.save(utensil);
    }

    public void deleteUtensilById(int id) {
        utensilRepository.deleteById(id);
        log.info("Deleting one utensil list with {} in id", id);
    }

    public Utensil updateUtensil(Utensil utensil) {
        log.info("update one utensil in DB");
        return utensilRepository.save(utensil);
    }

}
