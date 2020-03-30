package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBruger extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        if (UserMapper.deleteUserFromDB(request.getParameter("slet"))) {
            request.setAttribute("brugerListe", UserMapper.HentBrugere());
        } else {
            // FEJL HÅNDTERING
        }


        return "Admin/Brugere";
    }
}
