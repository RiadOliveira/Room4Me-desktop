package model.BO;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.UUID;

import filter.FilterList;
import model.DAO.ApartmentDAO;
import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import model.VO.UserVO;
import utils.ApartmentDataToFilter;
import utils.FilterChecker;

public class ApartmentBO extends BaseBO<ApartmentVO> {
	private static ApartmentDAO apartmentDAO = new ApartmentDAO();

	public void insert(ApartmentVO apartment) throws Exception {
		verifyIsNull(apartment);
		apartmentDAO.insert(apartment);
	}

	public void update(ApartmentVO apartment) throws Exception {
		verifyIsNull(apartment);
		if (findById(apartment) == null) {
			throw new Exception("Requested apartment do not exist.");
		}

		apartmentDAO.update(apartment);
	}

	public void delete(ApartmentVO apartment) throws Exception {
		verifyIsNull(apartment);
		if (findById(apartment) == null) {
			throw new Exception("Requested apartment do not exist.");
		}

		AddressBO addressBO = new AddressBO();
		addressBO.delete(apartment.getAddress());

		AspectsBO aspectsBO = new AspectsBO();
		aspectsBO.delete(apartment.getAspects());

		apartmentDAO.delete(apartment);
	}

	public ApartmentVO getEntityFromResultSet(ResultSet findedApartmentDB) throws Exception {
		UserBO userBO = new UserBO();
		UserVO findedUser = new UserVO();
		findedUser.setId(UUID.fromString(findedApartmentDB.getString("owner")));
		findedUser = userBO.findById(findedUser);

		AddressVO findedAddress = new AddressBO().getEntityFromResultSet(findedApartmentDB);
		findedAddress.setId(UUID.fromString(findedApartmentDB.getString("address")));

		AspectsVO findedAspects = new AspectsBO().getEntityFromResultSet(findedApartmentDB);
		findedAspects.setId(UUID.fromString(findedApartmentDB.getString("aspects")));

		ApartmentVO findedApartment = new ApartmentVO();
		findedApartment.setId(UUID.fromString(findedApartmentDB.getString("id")));
		findedApartment.setImage(findedApartmentDB.getString("image"));
		findedApartment.setRent(findedApartmentDB.getDouble("rent"));
		
		findedApartment.setAspects(findedAspects);
		findedApartment.setAddress(findedAddress);
		findedApartment.setOwner(findedUser);

		return findedApartment;
	}

	public FilterList<ApartmentVO> findAll() {
		FilterList<ApartmentVO> apartmentsList = new FilterList<ApartmentVO>();
		try {
			ResultSet findedApartmentDB = apartmentDAO.findAll();

			while (findedApartmentDB.next()) {
				ApartmentVO findedApartment = getEntityFromResultSet(findedApartmentDB);
				apartmentsList.add(findedApartment);
			}

			return apartmentsList;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}

	public ApartmentVO findById(ApartmentVO apartment) {
		try {
			verifyIsNull(apartment);

			ResultSet findedApartmentDB = apartmentDAO.findById(apartment);
			ApartmentVO findedApartment = getEntityFromResultSet(findedApartmentDB);

			return findedApartment;
		} catch (Exception exception) {
			return null;
		}
	}

	public FilterList<ApartmentVO> getFilteredApartmentByRequirements(
		FilterList<ApartmentVO> apartmentsList, AddressVO searchedAddress,
		AspectsVO searchedAspects, int searchedRent
	) {
		Iterator<ApartmentVO> iterator = apartmentsList.iterator();
		FilterList<ApartmentVO> filteredList = new FilterList<ApartmentVO>();
		
		while(iterator.hasNext()) {
			ApartmentVO apartment = iterator.next();
			boolean satisfyRequirements = FilterChecker.verifyApartmentSatisfyRequirements(
				apartment, searchedAddress, searchedAspects, searchedRent
			);

			if (satisfyRequirements) filteredList.add(apartment);
		}

		return filteredList;
	}

	private boolean verifyBubbleSortNeedsToExchangePositions(
		ApartmentDataToFilter apartmentDataToFilter,
		ApartmentVO previousApartment,
		ApartmentVO currentApartment
	) {
		switch(apartmentDataToFilter) {
			case ByRent: return previousApartment.getRent() > currentApartment.getRent();
			case ByCity: {
				String previousCity = previousApartment.getAddress().getCity();
				String currentCity = currentApartment.getAddress().getCity();

				return previousCity.compareTo(currentCity) >= 1;
			}
			case ByState: {
				String previousState = previousApartment.getAddress().getState();
				String currentState = currentApartment.getAddress().getState();

				return previousState.compareTo(currentState) >= 1;
			}
			default: return false;
		}
	}

	public FilterList<ApartmentVO> getSortedApartmentsList(
		FilterList<ApartmentVO> apartmentsList,
		ApartmentDataToFilter apartmentDataToFilter
	) {
		FilterList<ApartmentVO> sortedList = new FilterList<ApartmentVO>();
		for(ApartmentVO apartment : apartmentsList) sortedList.add(apartment);

		Iterator<ApartmentVO> iterator = sortedList.iterator();
		int size = sortedList.getSize();

		for(int ind=0 ; ind<size-1 ; ind++) {
			ApartmentVO previousApartment = iterator.next();

			while(iterator.hasNext()) {
				ApartmentVO currentApartment = iterator.next();
	
				boolean bubbleSortNeedsToExchangePositions = 
					verifyBubbleSortNeedsToExchangePositions(
						apartmentDataToFilter, previousApartment,
						currentApartment
					);
				
				if(bubbleSortNeedsToExchangePositions) {
					sortedList.exchangePositionWithPrevious(
						currentApartment
					);
				}

				previousApartment = currentApartment;
			}
		}

		return sortedList;
	}
}
