package PresentationLayer;

import FunctionLayer.CheckoutController;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MuffinBasket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckoutBasket extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        String userEmail = (String) session.getAttribute("email");
        CheckoutController checkoutController = new CheckoutController();
        boolean checkout = checkoutController.checkOut(userEmail);


        if (checkout) {
            return "Bruger/Kvittering";
        } else {
            return "Bruger/CartInsufficientFunds";
        }
    }
}
