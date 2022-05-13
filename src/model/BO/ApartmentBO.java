package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import filter.FilterList;
import model.DAO.ApartmentDAO;
import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import utils.AllowedGender;
import utils.VerifyFilter;

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

	public List<ApartmentVO> findAll() {
		List<ApartmentVO> apartmentsList = new ArrayList<ApartmentVO>();
		try {
			ResultSet findedApartmentDB = apartmentDAO.findAll();

			while (findedApartmentDB.next()) {
				AddressVO findedAddress = new AddressVO();

				findedAddress.setCity(findedApartmentDB.getString("city"));
				findedAddress.setDistrict(findedApartmentDB.getString("district"));
				findedAddress.setStreet(findedApartmentDB.getString("street"));
				findedAddress.setComplement(findedApartmentDB.getString("complement"));
				findedAddress.setApartmentNumber(findedApartmentDB.getString("apartment_number"));
				findedAddress.setZipCode(findedApartmentDB.getInt("zip_code"));

				AspectsVO findedAspects = new AspectsVO();

				findedAspects.setBedroomsQuantity(findedApartmentDB.getInt("bedrooms_quantity"));
				findedAspects.setAvailableToDivide(findedApartmentDB.getBoolean("available_to_divide"));
				findedAspects.setCapacity(findedApartmentDB.getInt("capacity"));
				findedAspects.setDescription(findedApartmentDB.getString("description"));

				int allowedGenderValue = findedApartmentDB.getInt("allowed_gender");
				findedAspects.setAllowedGender(AllowedGender.values()[allowedGenderValue]);

				ApartmentVO findedApartment = new ApartmentVO();
				findedApartment.setImage(findedApartmentDB.getString("image"));
				findedApartment.setRent(findedApartmentDB.getDouble("rent"));
				findedApartment.setAspects(findedAspects);
				findedApartment.setAddress(findedAddress);

				apartmentsList.add(findedApartment);

			}

		} catch (Exception exception) {
			return null;
		}
		return apartmentsList;
	}

	public ApartmentVO findById(ApartmentVO apartment) {
		try {
			verifyIsNull(apartment);

			ResultSet findedApartmentDB = apartmentDAO.findById(apartment);
			ApartmentVO findedApartment = new ApartmentVO();

			findedApartment.setImage(findedApartmentDB.getString("image"));
			findedApartment.setRent(findedApartmentDB.getDouble("rent"));

			return findedApartment;
		} catch (Exception exception) {
			return null;
		}
	}

	public FilterList<ApartmentVO> FilterGender(AddressVO adress,AspectsVO aspects ) {
		FilterList<ApartmentVO> apartmentsList = new FilterList<ApartmentVO>();
		try {
			ApartmentBO apartmentBO = new ApartmentBO();
			List<ApartmentVO> allApartment = apartmentBO.findAll();

			for (ApartmentVO apartment : allApartment) {
				boolean isAllowed = VerifyFilter.satisfyRequirements(apartment, adress,aspects);
				if (isAllowed) {
					apartmentsList.add(apartment);
				}
			}
		} catch (Exception exception) {
			return null;
		}
		return apartmentsList;
	}
}
