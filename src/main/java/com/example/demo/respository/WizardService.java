package com.example.demo.respository;


import com.example.demo.pojo.Wizard;
import com.example.demo.pojo.Wizards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WizardService {
    @Autowired
    private WizardRepository repository;

    public WizardService(WizardRepository repository) {
        this.repository = repository;
    }
    public Wizards getAll(){
        /*Wizards wizards = new Wizards();
        wizards.setModel((ArrayList<Wizard>) repository.findAll());*/
        return new Wizards((ArrayList<Wizard>) repository.findAll());
    }

    /*public List<Wizard> retrieveWizards(){
        return repository.findAll();
    }*/
   /* public Wizard retrieveWizardByName(String name){
         repository.findById(String name);

    }*/
    public Wizard createWizard(Wizard wizard){
        return repository.save(wizard);
    }
    /*public boolean deleteWizard(Wizard wizard){
        try{ repository.delete(wizard); return true;}
        catch (Exception e){return false;}
    }*/
    public int countBook() {
        return (int)repository.count();
    }
    /*public Wizard updateWizard(Wizard wizard){
        return repository.save(wizard);
    }*/
    public boolean updateWizard(Wizard wizard){
        try {
            repository.save(wizard);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean insertWizard(Wizard wizard){
        try {
            repository.insert(wizard);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean deleteWizard(Wizard wizard){
        try{ repository.delete(wizard);
            return true;}
        catch (Exception e){return false;}
    }
}
