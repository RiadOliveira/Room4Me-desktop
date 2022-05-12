package utils;

import model.VO.ApartmentVO;

public class VerifyFilter {
	public static boolean satisfyRequirements(ApartmentVO apartment, AllowedGender gender, int bedrooms_quantity, int capacity,
			boolean avaiable_to_divide) {
		boolean isAllowed = true;
		if (gender != null && apartment.getAspects().getAllowedGender() != gender) {
			isAllowed = false;
		}
		
		if(bedrooms_quantity != 0 && apartment.getAspects().getBedroomsQuantity() != bedrooms_quantity ) {
			isAllowed = false;
		}
		
		if(capacity != 0 && apartment.getAspects().getCapacity() != capacity ) {
			isAllowed = false;
		}
		
		if(apartment.getAspects().getAvailableToDivide() !=avaiable_to_divide) {
			isAllowed = false;
		}
		return isAllowed;
	}
}
