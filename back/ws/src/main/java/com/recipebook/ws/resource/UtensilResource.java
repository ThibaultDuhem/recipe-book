package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Utensil;
import com.recipebook.ws.service.UtensilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.UTENSIL_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class UtensilResource {

    private final UtensilService utensilService;

    @GetMapping
    public List<Utensil> retrieveAllUtensil(){
        log.info("WS called");
        return utensilService.retrieveAllUtensil();
    }
    @GetMapping("/{id}")
    public Utensil retrieveUtensil(@PathVariable int id){
        return utensilService.retrieveUtensil(id);
    }

    @PostMapping
    public List<Utensil> createUtensils(@RequestBody List<Utensil> utensils){
        log.info("WS called");
        return utensilService.createUtensils(utensils);
    }

    @DeleteMapping
    public void deleteUtensilsById(@RequestBody List<Integer> ids) {
        utensilService.deleteUtensilsById(ids);
    }

    @PatchMapping
    public List<Utensil> updateUtensils(@RequestBody List<Utensil> utensils) {
        return utensilService.updateUtensils(utensils);
    }

}
