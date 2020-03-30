package FunctionLayer;

import DBAccess.UserMapper;

public class CheckoutController {

    public boolean checkOut(String userEmail) throws LoginSampleException {

        //tjek brugerens balance ved "checkout" knap

        UserMapper usermapper = new UserMapper();
        User user = usermapper.getUserByEmail(userEmail);
        int brugerID = user.getId();
        double newUserBalance = user.getSaldo() - MuffinBasket.totalAmount();

        if (newUserBalance >= 0) {
            usermapper.updateUserBalanceByEmail(userEmail, newUserBalance);
            int ordreID = usermapper.pushOrdreToDB(brugerID);

            for (int i = 0; i < MuffinBasket.muffinsIKurv.size(); i++) {
                Muffin curr = MuffinBasket.muffinsIKurv.get(i);
                /* pushMuffinToDB returns the auto incremented ID it got */
                int id = usermapper.pushMuffinToDB(curr.getPris(), curr.getTopType(),
                        curr.getBundType());

                curr.setID(id);
            }

            for (int i = 0; i < MuffinBasket.muffinsIKurv.size(); i++) {
                Muffin curr = MuffinBasket.muffinsIKurv.get(i);
                usermapper.pushIndholdToDB(ordreID, curr.getID());
            }

            usermapper.pushDateToDB(ordreID);
            MuffinBasket.clearMuffinBasket();
            return true;
        }
        return false;
    }
}
