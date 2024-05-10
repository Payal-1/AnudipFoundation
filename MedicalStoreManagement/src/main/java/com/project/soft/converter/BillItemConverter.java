package com.project.soft.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.project.soft.entity.BillItem;
import com.project.soft.model.BillItemDto;

@Component
public class BillItemConverter {



	
	//converting teacher Entity to teacher DTo
		public BillItemDto convertToBillItemDto(BillItem billItem) {
			BillItemDto billItemDto=new BillItemDto();
		
			if(billItem!=null) {
				BeanUtils.copyProperties(billItem, billItemDto);
			}
			
			return billItemDto;
		}
		
		//converting teacher dto to teacher
		
		public BillItem convertToBillItem(BillItemDto billItemDto) {
			BillItem billItem=new BillItem();
			
			if(billItemDto!=null) {
				BeanUtils.copyProperties(billItemDto, billItem);
			}
			
			return billItem;
		}

	
	
	
	
}
