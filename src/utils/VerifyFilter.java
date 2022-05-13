package utils;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;

public class VerifyFilter {
	public static boolean satisfyRequirements(ApartmentVO apartment, AddressVO adress, AspectsVO aspects) {
		//ASPECTS
		if (apartment.getAspects().getAllowedGender() != aspects.getAllowedGender()) {
			return false;
		}

		if (apartment.getAspects().getBedroomsQuantity() != aspects.getBedroomsQuantity()) {
			return false;
		}

		if (apartment.getAspects().getCapacity() != aspects.getCapacity()) {
			return false;
		}

		if (apartment.getAspects().getAvailableToDivide() != aspects.getAvailableToDivide()) {
			return false;
		}
		//ADRESS
		if (apartment.getAddress().getCity() != adress.getCity()) {
			return false;
		}

		if (apartment.getAddress().getDistrict() != adress.getDistrict()) {
			return false;
		}

		if (apartment.getAddress().getZipCode() != adress.getZipCode()) {
			return false;
		}

		if (apartment.getAddress().getStreet() != adress.getStreet()) {
			return false;
		}
		return true;
	}
}
