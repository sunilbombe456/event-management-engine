package com.webwork.event.management.service;

import java.util.List;

import com.webwork.event.management.entity.Decoration;

public interface DecorationService {

	public Decoration save(Decoration decoration);

	public boolean delete(String decorationId);
	
	public List<Decoration> getAll();
	
	public Decoration get(String id);

}
