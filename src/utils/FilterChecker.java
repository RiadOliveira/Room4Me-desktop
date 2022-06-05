package utils;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;

public class FilterChecker {
	public static boolean verifyApartmentSatisfyRequirements(
		ApartmentVO apartment, AddressVO searchedAddress,
		AspectsVO searchedAspects, int searchedRent
	) {
		//RENT
		if(
			searchedRent != 0 && 
			apartment.getRent().doubleValue() > searchedRent
		) {
			return false;
		}

		//ASPECTS
		AspectsVO comparativeAspects = apartment.getAspects();

		if (comparativeAspects.getAllowedGender() != searchedAspects.getAllowedGender()) {
			return false;
		}

		if (
			searchedAspects.getBedroomsQuantity() != 0 && 
			comparativeAspects.getBedroomsQuantity() < searchedAspects.getBedroomsQuantity()
		) {
			return false;
		}

		if (
			searchedAspects.getCapacity() != 0 && 
			comparativeAspects.getCapacity() < searchedAspects.getCapacity()
		) {
			return false;
		}

		if (
			searchedAspects.getAvailableToDivide() && 
			!comparativeAspects.getAvailableToDivide()
		) {
			return false;
		}

		//ADRESS
		AddressVO comparativeAddress = apartment.getAddress();

		if (!comparativeAddress.getCity().contains(searchedAddress.getCity())) {
			return false;
		}

		if (!comparativeAddress.getState().contains(searchedAddress.getState())) {
			return false;
		}

		if (!comparativeAddress.getDistrict().contains(searchedAddress.getDistrict())) {
			return false;
		}

		if (!comparativeAddress.getStreet().contains(searchedAddress.getStreet())) {
			return false;
		}

		if (
			searchedAddress.getZipCode() != 0 && 
			comparativeAddress.getZipCode() != searchedAddress.getZipCode()
		) {
			return false;
		}

		return true;
	}
}
