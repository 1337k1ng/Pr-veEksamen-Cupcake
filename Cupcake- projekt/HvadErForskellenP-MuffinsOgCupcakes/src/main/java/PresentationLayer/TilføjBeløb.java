package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TilføjBeløb extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

     int beløb = Integer.parseInt(request.getParameter("beløb"));
     String email = request.getParameter("email");

     UserMapper m = new UserMapper();
     m.InsertMoneyToUser(email, beløb);

        request.setAttribute("brugerListe", UserMapper.HentBrugere());

        return "Admin/Brugere";
    }
}
