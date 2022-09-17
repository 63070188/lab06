package com.example.demo.controller;

import com.example.demo.pojo.Wizard;
import com.example.demo.pojo.Wizards;
import com.example.demo.respository.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WizardController {
    @Autowired
    private WizardService service;
    private Wizards wizards;

    public WizardController(WizardService service) {
        this.service = service;
    }

    @RequestMapping(value ="/wizards", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWizards() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value ="/addWizard", method = RequestMethod.POST)
    public ResponseEntity<?> addWizard(@RequestBody Wizard wizard) {
        return ResponseEntity.ok(service.insertWizard(wizard));
    }

    /*@RequestMapping(value ="/updateWizard", method = RequestMethod.POST)
    public boolean updateWizard(@RequestBody MultiValueMap<String, String> n) {
        //Wizard n = wizards.getModel().get(Integer.parseInt(wizard.get_id()));
        Map<String, String> d = n.toSingleValueMap();
        Wizard wizard = service.retrieveWizardByName(d.get("oldname"));
        int num = Integer.parseInt(d.get("money"));
        if(wizard != null){
            service.updateWizard(new Wizard(wizard.get_id(), d.get("sex"), d.get("name"), d.get("school"), d.get("house"), num, d.get("position") ));
            return true;
        }else {
            return false;
        }
    }*/

    @RequestMapping(value ="/updateWizard", method = RequestMethod.POST)
    public boolean updateWizard(@RequestBody Wizard wizard) {
       return service.updateWizard(wizard);
    }

    @RequestMapping(value ="/deleteWizard", method = RequestMethod.POST)
    public boolean deleteWizard(@RequestBody Wizard wizard) {
        return service.deleteWizard(wizard);
    }
}