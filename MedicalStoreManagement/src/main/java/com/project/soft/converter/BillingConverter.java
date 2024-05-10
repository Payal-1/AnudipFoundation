package com.project.soft.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.project.soft.entity.Billing;
import com.project.soft.model.BillingDto;


@Component
public class BillingConverter {

		
	//converting teacher Entity to teacher DTo
		public BillingDto convertToBillingDto(Billing billing) {
			BillingDto billingDto=new BillingDto();
		
			if(billing!=null) {
				BeanUtils.copyProperties(billing, billingDto);
			}
			
			return billingDto;
		}
		
		//converting teacher dto to teacher
		
		public Billing convertToBilling(BillingDto billingDto) {
			Billing billing = new Billing();
			
			if(billingDto!=null) {
				BeanUtils.copyProperties(billingDto, billing);
			}
			
			return billing;
		}

}
