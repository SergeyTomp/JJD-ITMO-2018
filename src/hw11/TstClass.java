package hw11;

import java.util.ArrayList;
import java.util.Arrays;
import static hw11.AccessLevel.ADMIN;

public class TstClass {

    private final int intData;
    private String strData;
    private String tstAtr = "tstAttr";
    public AccessLevel en = ADMIN;
    public boolean bool = true;
    public String[] strArr;
    public int[] intArr1 = {1, 2, 3};
    @Exclude
    private int[] intArr2 = {4, 5, 6};
    @Exclude(exclude = Exclude.Define.NO)
    public double[] doubleArr = {1.1, 2.2, 3.3};
    public ArrayList<String> strArrLst = new ArrayList<>();
    public double dbl = 2.3d;
    public Integer Int = 5;

    public TstClass(int intData, String strData) {
        this.intData = intData;
        this.strData = strData;
        strArr = new String[]{"one", "two", "three"};
        strArrLst.addAll(Arrays.asList(strArr));
    }

    public int getIntData() {
        return intData;
    }

    public String getStrData() {
        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }

}

