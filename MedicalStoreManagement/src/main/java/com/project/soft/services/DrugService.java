package com.project.soft.services;

import com.project.soft.model.DrugDto;

import java.util.List;


public interface DrugService {

   

    public List<DrugDto> getAllDrugs();

    public DrugDto getDrugById(int id);

    public DrugDto addDrug(DrugDto drug);

    public DrugDto updateDrug(int id, DrugDto updatedDrug);

    public void deleteDrug(int id);


	
}
