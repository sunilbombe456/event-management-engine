package com.webwork.event.management.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webwork.event.management.dto.VenueDTO;

@Component
public class AdminValidator implements Validator {
	
//	@InitBinder("venueDTO")
//	public void initMerchantOnlyBinder(WebDataBinder binder) {
//		binder.addValidators(adminValidator);
//	}


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return VenueDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		if(errors.getErrorCount() == 0){
			VenueDTO param = (VenueDTO) target;
			
			if(param.getName() == null) {
				errors.reject("100", "Venue Name Can't be Null..!");
			}else if( param.getPeopleCapacity()  < 0 ) {
				errors.reject("100", "People Capacity must be Greater than 0..!");
			}
		}
	}

}
