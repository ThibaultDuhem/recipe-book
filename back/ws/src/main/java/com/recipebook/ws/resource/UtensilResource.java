package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Utensil;
import com.recipebook.ws.service.UtensilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(ResourceUrlConst.UTENSIL_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class UtensilResource {

    private final UtensilService utensilService;

    @GetMapping
    public List<Utensil> retrieveAllUtensils(){
        log.info("WS called");
        return utensilService.retrieveAllUtensil();
    }
    @GetMapping("/{id}")
    public Utensil retrieveUtensil(@PathVariable int id){
        return utensilService.retrieveUtensil(id);
    }
}
