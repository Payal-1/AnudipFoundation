package com.project.soft.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.project.soft.entity.Drug;
import com.project.soft.model.DrugDto;

@Component
public class DrugConverter {

	
	
	
	//converting teacher Entity to teacher DTo
		public DrugDto convertToDrugDto(Drug drug) {
			DrugDto drugDto=new DrugDto();
		
			if(drug!=null) {
				BeanUtils.copyProperties(drug, drugDto);
			}
			
			return drugDto;
		}
		
		//converting teacher dto to teacher
		
		public Drug convertToDrug(DrugDto drugDto) {
			Drug drug=new Drug();
			
			if(drugDto!=null) {
				BeanUtils.copyProperties(drugDto, drug);
			}
			
			return drug;
		}

}
