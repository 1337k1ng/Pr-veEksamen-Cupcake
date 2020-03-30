package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Muffin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMuffinToBasket extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String bund = request.getParameter("bund");
        String top = request.getParameter("top");
        Muffin x = new Muffin(top, bund);
        double pris = x.getPris();

        System.out.println(top);
        System.out.println(bund);
        System.out.println(pris);

        return "Bruger/Shop";
    }
}
