package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MuffinBasket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBasketToDB extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        System.out.println("This class needs to push stuff to DB, and clear the array!");
        //Kig på register klassen til at finde ud af hvordan man gør det her.

        MuffinBasket.clearMuffinBasket(); //Muffins er købt, og skal slettes fra kurv til sidst..
        return "Cart";
        // Måske skal vi redirect til "Tak for din bestilling".
    }
}
