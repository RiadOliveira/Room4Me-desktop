package utils;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;

public class VerifyFilter {
	public static boolean satisfyRequirements(ApartmentVO apartment, AddressVO adress, AspectsVO aspects) {
		//ASPECTS
		AspectsVO comparativeAspects = apartment.getAspects();

		if (comparativeAspects.getAllowedGender() != aspects.getAllowedGender()) {
			return false;
		}

		if (comparativeAspects.getBedroomsQuantity() != aspects.getBedroomsQuantity()) {
			return false;
		}

		if (comparativeAspects.getCapacity() != aspects.getCapacity()) {
			return false;
		}

		if (comparativeAspects.getAvailableToDivide() != aspects.getAvailableToDivide()) {
			return false;
		}

		//ADRESS
		AddressVO comparativeAddress = apartment.getAddress();

		if (!comparativeAddress.getCity().equals(adress.getCity())) {
			return false;
		}

		if (!comparativeAddress.getDistrict().equals(adress.getDistrict())) {
			return false;
		}

		if (comparativeAddress.getZipCode() != adress.getZipCode()) {
			return false;
		}

		if (!comparativeAddress.getStreet().equals(adress.getStreet())) {
			return false;
		}

		return true;
	}
}
