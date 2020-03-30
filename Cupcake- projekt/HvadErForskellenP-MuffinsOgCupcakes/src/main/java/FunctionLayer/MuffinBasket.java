package FunctionLayer;

import java.util.ArrayList;

public class MuffinBasket {
    static public ArrayList<Muffin> muffinsIKurv = new ArrayList<>();
    static int size = 0;

    public static  void addMuffin(Muffin x) {
        x.setMuffinPos(size);
        muffinsIKurv.add(x);
        size++;
    }
    // til debugging, brug jstl for each..
    public static String mufAsStr() {
        StringBuilder muffinsAsStr = new StringBuilder();
        for (int i = 0; i < muffinsIKurv.size(); i++) {
            muffinsAsStr.append("Her er den " + (i + 1) +  " muffins pris: ");
            muffinsAsStr.append(muffinsIKurv.get(i).getPris());
            muffinsAsStr.append(". Den var med " + muffinsIKurv.get(i).getBundType() + " og ");
            muffinsAsStr.append(muffinsIKurv.get(i).getTopType() + " top");
            muffinsAsStr.append(" <br>");
        }
        return muffinsAsStr.toString();
    }

    public static void removeMuffin(int index) {
        // Vi burde lave noget bedre end det her skrald.
            muffinsIKurv.remove(index);
            size--;
            updateMuffinPos();
    }

    public static void updateMuffinPos() {
        for (int i = 0; i < muffinsIKurv.size(); i++) {
            muffinsIKurv.get(i).setMuffinPos(i);
        }
    }

    public static void clearMuffinBasket() {
        muffinsIKurv.clear();
    }

    public static int totalAmount() {
        int totalAmount = 0;

        for (Muffin m : muffinsIKurv) {
            totalAmount += m.getPris();
        }
    return totalAmount;
    }



}
