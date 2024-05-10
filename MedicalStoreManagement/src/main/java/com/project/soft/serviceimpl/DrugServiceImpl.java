package com.project.soft.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.converter.DrugConverter;
import com.project.soft.entity.Drug;
import com.project.soft.exception.DrugNotFoundException;
import com.project.soft.model.DrugDto;
import com.project.soft.repository.DrugRepository;
import com.project.soft.services.DrugService;


@Service
public class DrugServiceImpl implements DrugService {

	
	
	@Autowired
	DrugRepository dRepo;
	
	
	@Autowired
	private DrugConverter dConverter;
	
	@Override
	public List<DrugDto> getAllDrugs() {
		
		List<Drug> allDrugs = this.dRepo.findAll();
		 List<DrugDto> collect = allDrugs.stream().map((drug)->this.dConverter.convertToDrugDto(drug)).collect(Collectors.toList());
		return collect;
	}


	
	@Override
	public DrugDto getDrugById(int id) {
		Drug drug = dRepo.findById(id).orElseThrow(()-> new DrugNotFoundException("Teacher with ID "+id+" is not found"));
		return this.dConverter.convertToDrugDto(drug);
	}
	@Override
	public DrugDto addDrug(DrugDto drugDto) {
		// TODO Auto-generated method stub
		Drug drug = this.dConverter.convertToDrug(drugDto);
		Drug saveDrug = this.dRepo.save(drug);
		return this.dConverter.convertToDrugDto(saveDrug);
}
	@Override
	public DrugDto updateDrug(int id, DrugDto drugDto) {
		Drug drug1 = dRepo.findById(id).orElseThrow(()-> new DrugNotFoundException("Teacher with ID "+id+" is not found"));
		
		drug1.setId(id);
		drug1.setName(drugDto.getName());
		drug1.setDescription(drugDto.getDescription());
		drug1.setQuantity(drugDto.getQuantity());
		drug1.setPrice(drugDto.getPrice());
		drug1.setExpirationDate(drugDto.getExpirationDate());
		
		
		Drug saveDrug=dRepo.save(drug1);
		return dConverter.convertToDrugDto(saveDrug);
		
	}

	@Override
	public void deleteDrug(int id) {
		dRepo.findById(id).orElseThrow(()-> new DrugNotFoundException("Teacher with ID "+id+" is not found"));
		dRepo.deleteById(id);
		
	}

}

