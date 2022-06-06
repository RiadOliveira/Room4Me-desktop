package utils;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;

public class FilterChecker {
	private static boolean checkString(
		String comparativeString, String searchedString
	) {
		String parsedComparativeString = DataConverter.normalizeTextToCompare(
			comparativeString
		);
		String parsedSearchedString = DataConverter.normalizeTextToCompare(
			searchedString
		);

		return parsedComparativeString.contains(parsedSearchedString);
	}

	public static boolean verifyApartmentSatisfyRequirements(
		ApartmentVO apartment, SearchApartmentData searchData
	) {
		int searchedRent = searchData.getSearchedRent();
		boolean bothGenders = searchData.getBothGenders();
		AddressVO searchedAddress = searchData.getSearchedAddress();
		AspectsVO searchedAspects = searchData.getSearchedAspects();

		//RENT
		if(
			searchedRent != 0 && 
			apartment.getRent().doubleValue() > searchedRent
		) {
			return false;
		}

		//ASPECTS
		AspectsVO comparativeAspects = apartment.getAspects();
		boolean verifyBothGenders = bothGenders && 
			comparativeAspects.getAllowedGender() != AllowedGender.both;

		if (
			verifyBothGenders &&
			comparativeAspects.getAllowedGender() != searchedAspects.getAllowedGender()
		) {
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

		//ADDRESS
		AddressVO comparativeAddress = apartment.getAddress();

		if(!checkString(comparativeAddress.getCity(), searchedAddress.getCity())) {
			return false;
		}

		if(!checkString(comparativeAddress.getState(), searchedAddress.getState())) {
			return false;
		}

		if(!checkString(comparativeAddress.getDistrict(), searchedAddress.getDistrict())) {
			return false;
		}

		if(!checkString(comparativeAddress.getStreet(), searchedAddress.getStreet())) {
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
