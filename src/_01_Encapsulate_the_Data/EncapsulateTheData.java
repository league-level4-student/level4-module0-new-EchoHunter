package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot be negative. All negative parameters should set
     * itemsReceived to 0.
     */

    int itemsReceived;
    public void setItemsReceived(int newNum) {
		if (newNum >= 0) {
			itemsReceived = newNum;
		}
    }
    public int getItemsReceived() {
    	return itemsReceived;
    }/*
    }
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    double degreesTurned;
    public void setDegreesTurned(double newNum) {
    	if((newNum >= 0.0)&&(newNum<= 360.0)) {
    		degreesTurned = newNum;
    	}
    	else if (newNum<0.0) {
    		degreesTurned = 0.0;
    	}
    	else if (newNum > 360.0) {
    		degreesTurned = 360.0;
    	}
    }
    public double getDegreesTurned() {
    	return degreesTurned;
    }
    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    String nomenclature;
    
    @SuppressWarnings("unused")
	public void setNomenclature(String newString) {
    	if((!newString.equals(""))||(newString != null)) {
    		nomenclature = newString;
    	}
    	else {
    		nomenclature = " ";
    	}
    }
    
    public String getNomenclature() {
    	return nomenclature;
    }
    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    Object memberObj;
    
    public void setMemberObj(Object newObj) {
    	memberObj = newObj;
    }
    public void memberObjNotString(String badString) {
    	memberObj = new Object();
    }
    public Object getMemberObj() {
    	return memberObj;
    }
    
	

}
