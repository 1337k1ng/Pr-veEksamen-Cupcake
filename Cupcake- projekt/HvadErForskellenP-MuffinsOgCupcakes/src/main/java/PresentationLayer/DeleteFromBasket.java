package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MuffinBasket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFromBasket extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int index = Integer.parseInt(request.getParameter("muf"));
        MuffinBasket.removeMuffin(index);
        return "Bruger/Cart";
    }
}
