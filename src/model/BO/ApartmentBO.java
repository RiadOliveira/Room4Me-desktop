package model.BO;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import utils.DataConverter;
import utils.FilterChecker;
import utils.SearchApartmentData;

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

	private String getApartmentDataAsText(ApartmentVO apartment) {
		String contentString = "";

		//Apartment Owner
		contentString += "Dono do apartamento: " + '\n';
		contentString += apartment.getOwner().dataToText();
		contentString += '\n';

		//Apartment Address
		contentString += "Endereço do apartamento: " + '\n';
		contentString += apartment.getAddress().dataToText();
		contentString += '\n';

		//Apartment Aspects
		contentString += "Aspectos do apartamento: " + '\n';
		contentString += apartment.getAspects().dataToText();
		contentString += '\n';

		//Apartment Rent
		String currencyValue = DataConverter.convertNumberToCurrencyValue(
			apartment.getRent()
		);
		contentString += "Aluguel: " + currencyValue + '\n';

		return contentString;
	}

	public void generateFileWithApartmentsList(
		FilterList<ApartmentVO> apartmentsList
	) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("tmp/searchedApartments.txt")
			);
	
			String fileContent = "";
			for(ApartmentVO apartment : apartmentsList) {
				fileContent += getApartmentDataAsText(apartment);

				fileContent += '\n';
				fileContent += "================================";
				fileContent += "\n\n";
			}
	
			bufferedWriter.append(fileContent);
			bufferedWriter.close();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public FilterList<ApartmentVO> getFilteredApartmentsByRequirements(
		FilterList<ApartmentVO> apartmentsList, SearchApartmentData searchData
	) {
		Iterator<ApartmentVO> iterator = apartmentsList.iterator();
		FilterList<ApartmentVO> filteredList = new FilterList<ApartmentVO>();
		
		while(iterator.hasNext()) {
			ApartmentVO apartment = iterator.next();
			boolean satisfyRequirements = FilterChecker.verifyApartmentSatisfyRequirements(
				apartment, searchData
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
			case byRent: return previousApartment.getRent() > currentApartment.getRent();
			case byCity: {
				String previousCity = previousApartment.getAddress().getCity();
				String currentCity = currentApartment.getAddress().getCity();

				return previousCity.compareTo(currentCity) >= 1;
			}
			case byState: {
				String previousState = previousApartment.getAddress().getState();
				String currentState = currentApartment.getAddress().getState();

				return previousState.compareTo(currentState) >= 1;
			}
			case byOwnerEmail: {
				String previousEmail = previousApartment.getOwner().getEmail();
				String currentEmail = currentApartment.getOwner().getEmail();

				return previousEmail.compareTo(currentEmail) >= 1;
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

	private static int getMiddleOfLength(int length) {
		if(length == 0) return -1;
		return length/2;
	}

	private static String getOwnerEmailFromApartment(ApartmentVO apartment) {
		if(apartment == null) return "";
		return apartment.getOwner().getEmail();
	}

	private int binarySearchByOwner(
		FilterList<ApartmentVO> apartmentsList, String searchedOwnerEmail
	) {
		int length = apartmentsList.getSize();

		int ind = getMiddleOfLength(length);
		ApartmentVO middlePosition = apartmentsList.search(ind);
		boolean middleIsHigher = getOwnerEmailFromApartment(
			middlePosition
		).compareTo(searchedOwnerEmail) >= 1;

		boolean needsCorrection = length % 2 == 0 && middleIsHigher;
		int middleLength = ind + (needsCorrection ? 1 : 0);

		while(
			middleLength != -1 &&
			!getOwnerEmailFromApartment(apartmentsList.search(ind)).equals(searchedOwnerEmail)
		) {
			middleLength = getMiddleOfLength(middleLength);
			int parsedValue = middleLength == 0 ? 1 : middleLength;

			String apartmentOwnerEmail = getOwnerEmailFromApartment(apartmentsList.search(ind));
			ind += (apartmentOwnerEmail.compareTo(searchedOwnerEmail) < 0 ? parsedValue : -parsedValue);
		}

		return middleLength == -1 ? -1 : ind;
	}

	public FilterList<ApartmentVO> filterByOwnerWithBinarySearch(
		FilterList<ApartmentVO> apartmentsList, UserVO searchedOwner
	) {
		FilterList<ApartmentVO> copyList = getSortedApartmentsList(
			apartmentsList, ApartmentDataToFilter.byOwnerEmail
		);

		FilterList<ApartmentVO> filteredList = new FilterList<ApartmentVO>();
		String searchedOwnerEmail = searchedOwner.getEmail();

		int binaryFindedIndex = binarySearchByOwner(copyList, searchedOwnerEmail);
		if(binaryFindedIndex == -1) return filteredList;

		boolean hasOneMoreApartment = false;
		do {
			ApartmentVO deletedApartment = copyList.remove(binaryFindedIndex);
			filteredList.add(deletedApartment);

			ApartmentVO currentApartment = copyList.search(binaryFindedIndex);
			ApartmentVO previousApartment = copyList.search(Math.abs(binaryFindedIndex - 1));

			boolean validCurrentApartment = getOwnerEmailFromApartment(
				currentApartment
			).equals(searchedOwnerEmail);

			boolean validPreviousApartment = getOwnerEmailFromApartment(
				previousApartment
			).equals(searchedOwnerEmail);
			if(validPreviousApartment) binaryFindedIndex = Math.abs(binaryFindedIndex - 1);

			hasOneMoreApartment = validCurrentApartment || validPreviousApartment;
		} while(hasOneMoreApartment);

		return filteredList;
	}
}