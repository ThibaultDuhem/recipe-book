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

    public List<Utensil> createUtensil(List<Utensil> utensil) {
        log.info("create utensil in DB");
        return utensilRepository.saveAll(utensil);
    }

    public void deleteUtensilById(List<Integer> id) {
        utensilRepository.deleteAllById(id);
        log.info("Deleting utensil list with {} in id", id);
    }

    public List<Utensil> updateUtensil(List<Utensil> utensil) {
        log.info("update utensil in DB");
        return utensilRepository.saveAll(utensil);
    }

}
