package com.sei.capstone.service;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService {

    private WineRepository wineRepository;

    @Autowired
    public WineService(WineRepository wineRepository){
        this.wineRepository = wineRepository;
    }

    public List<Wine> getAllWines(){
        if (wineRepository.findAll().size() > 0) {
            return wineRepository.findAll();
        } else {
            throw new InformationNotFoundException("This wine list is empty");
        }
    }

    public Wine getOneWine(Long wineId){
        Optional<Wine> wine = wineRepository.findById(wineId);
        if (wine.isEmpty()) {
            throw new InformationNotFoundException("No wine with id of " + wineId + "exists! Please check your search and try again");
        } else {
            return wine.get();
        }
    }


}
