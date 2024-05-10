
  package com.project.soft.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.converter.BillItemConverter;
import com.project.soft.entity.BillItem;

import com.project.soft.exception.BillItemNotFoundException;
import com.project.soft.model.BillItemDto;
import com.project.soft.repository.BillItemRepository;
import com.project.soft.services.BillItemService;

@Service
public class BillItemServiceImpl implements BillItemService{

	@Autowired
	BillItemRepository bRepo;
	@Autowired
	private BillItemConverter bConverter;
	
	@Override
	public BillItemDto createBillItem(BillItemDto billItemDto) {
		BillItem billItem= this.bConverter.convertToBillItem(billItemDto);
		BillItem saveBillItem = this.bRepo.save(billItem);
		return this.bConverter.convertToBillItemDto(saveBillItem);
	}

	@Override
	public List<BillItemDto> getAllBillItems() {
		List<BillItem> allDrugs = this.bRepo.findAll();
		 List<BillItemDto> collect = allDrugs.stream().map((billItem)->this.bConverter.convertToBillItemDto(billItem)).collect(Collectors.toList());
		return collect;	}

	@Override
	public BillItemDto getBillItemById(int id) {
		BillItem billItem = bRepo.findById(id).orElseThrow(()-> new BillItemNotFoundException("BillItem with ID "+id+" is not found"));
		return this.bConverter.convertToBillItemDto(billItem);
		
	}

	
	
	public BillItemDto updateBillItem(int id, BillItemDto billItemDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBillItem(int id) {
		bRepo.findById(id).orElseThrow(()-> new BillItemNotFoundException("BillItem with ID "+id+" is not found"));
		bRepo.deleteById(id);
	}

  }
 