package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import filter.FilterList;
import model.DAO.ApartmentDAO;
import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import model.VO.UserVO;
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

	private ApartmentVO getApartmentFromResultSet(
		ResultSet findedApartmentDB
	) throws Exception {
		AddressVO findedAddress = new AddressVO();

		findedAddress.setId(UUID.fromString(findedApartmentDB.getString("address")));
		findedAddress.setCity(findedApartmentDB.getString("city"));
		findedAddress.setDistrict(findedApartmentDB.getString("district"));
		findedAddress.setStreet(findedApartmentDB.getString("street"));
		findedAddress.setComplement(findedApartmentDB.getString("complement"));
		findedAddress.setApartmentNumber(findedApartmentDB.getString("apartment_number"));
		findedAddress.setZipCode(findedApartmentDB.getInt("zip_code"));

		AspectsVO findedAspects = new AspectsVO();

		findedAspects.setId(UUID.fromString(findedApartmentDB.getString("aspects")));
		findedAspects.setBedroomsQuantity(findedApartmentDB.getInt("bedrooms_quantity"));
		findedAspects.setAvailableToDivide(findedApartmentDB.getBoolean("available_to_divide"));
		findedAspects.setCapacity(findedApartmentDB.getInt("capacity"));
		findedAspects.setDescription(findedApartmentDB.getString("description"));

		int allowedGenderValue = findedApartmentDB.getInt("allowed_gender");
		findedAspects.setAllowedGender(AllowedGender.values()[allowedGenderValue]);

		ApartmentVO findedApartment = new ApartmentVO();
		findedApartment.setId(UUID.fromString(findedApartmentDB.getString("id")));
		findedApartment.setImage(findedApartmentDB.getString("image"));
		findedApartment.setRent(findedApartmentDB.getDouble("rent"));
		findedApartment.setAspects(findedAspects);
		findedApartment.setAddress(findedAddress);

		return findedApartment;
	}

	public List<ApartmentVO> findAll() {
		List<ApartmentVO> apartmentsList = new ArrayList<ApartmentVO>();
		try {
			ResultSet findedApartmentDB = apartmentDAO.findAll();

			while (findedApartmentDB.next()) {
				ApartmentVO findedApartment = getApartmentFromResultSet(findedApartmentDB);
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
			ApartmentVO findedApartment = getApartmentFromResultSet(findedApartmentDB);

			UserVO user = new UserVO();
			UserBO userBO = new UserBO();

			user.setId(UUID.fromString(findedApartmentDB.getString("owner")));
			findedApartment.setOwner(userBO.findById(user));

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

			return apartmentsList;
		} catch (Exception exception) {
			return null;
		}
	}
}
