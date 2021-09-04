package com.webwork.event.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.entity.Decoration;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.exception.EntityNotFoundException;
import com.webwork.event.management.repository.DecorationRepository;
import com.webwork.event.management.service.DecorationService;

@Service
public class DecorationServiceImpl implements DecorationService {

	@Autowired
	private DecorationRepository decorationRepo;

	@Override
	public Decoration save(Decoration decoration) {
		if (null != decoration.getId()) {
			return decorationRepo.save(decoration);
		} else if (null != decorationRepo.findByName(decoration.getName())) {
			throw new DuplicateEntityException("Already Exists..!");
		}
		return decorationRepo.save(decoration);
	}

	@Override
	public boolean delete(String decorationId) {
		Optional<Decoration> result = decorationRepo.findById(decorationId);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("decoration not found..!");
		} else {
			Decoration decoration = result.get();
			decorationRepo.delete(decoration);
			return true;
		}
	}

	@Override
	public List<Decoration> getAll() {
		List<Decoration> decorationList = decorationRepo.findAll();
		if (null == decorationList) {
			throw new EntityNotFoundException("Decoration List Not Found..!");
		}
		return decorationList;
	}

	@Override
	public Decoration get(String id) {
		Optional<Decoration> result = decorationRepo.findById(id);
		if(!result.isPresent()) {
			throw new EntityNotFoundException("Decoration not found..!");
		}else {
			return result.get();
		}
	}

}
