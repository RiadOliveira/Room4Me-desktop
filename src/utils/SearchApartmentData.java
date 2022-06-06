package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.VO.AddressVO;
import model.VO.AspectsVO;

public class SearchApartmentData implements Serializable {
    private AddressVO searchedAddress;
	private AspectsVO searchedAspects;
    private int searchedRent;
	private boolean bothGenders;

    public SearchApartmentData(
        AddressVO searchedAddress, AspectsVO searchedAspects,
        int searchedRent, boolean bothGenders
    ) {
        this.searchedAddress = searchedAddress;
        this.searchedAspects = searchedAspects;
        this.searchedRent = searchedRent;
        this.bothGenders = bothGenders;
    }

    public void saveSearchApartmentDataAsBinaryFile() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("tmp/searchApartmentData.bin")
            );

            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static SearchApartmentData readSearchApartmentDataBinaryFile()
    throws IOException, ClassNotFoundException {
        SearchApartmentData fileData = null;
		File searchApartmentFile = new File("tmp/searchApartmentData.bin");
	    
		if(searchApartmentFile.exists()) {
			ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(searchApartmentFile)
            );

            fileData = (SearchApartmentData) objectInputStream.readObject();
	        objectInputStream.close();
		}
		
		return fileData;
	}

    public AddressVO getSearchedAddress() {
        return searchedAddress;
    }

    public AspectsVO getSearchedAspects() {
        return searchedAspects;
    }

    public int getSearchedRent() {
        return searchedRent;
    }

    public boolean getBothGenders() {
        return bothGenders;
    }
}
