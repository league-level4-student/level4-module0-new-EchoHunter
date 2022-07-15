package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes = DataType.values();
        JOptionPane.showOptionDialog(null, "Which datatype would you like to learn about", "Data Types", DEFAULT_OPTION, PLAIN_MESSAGE, null, dataTypes, null);
        
    }
    enum DataType{
    	BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64), BOOLEAN(1), CHAR(16);
    	private final int bits;
    	private DataType(int bits) {
    		this.bits = bits;
    	}
    	public int getBits(){
    		return bits;
    	}
    }
}
