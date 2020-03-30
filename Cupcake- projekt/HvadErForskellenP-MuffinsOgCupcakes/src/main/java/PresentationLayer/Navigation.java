package PresentationLayer;

import DBAccess.OrdreMapper;
import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

public class Navigation extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String to = request.getParameter("to");

        System.out.println(to);
        switch (to) {
            case "home":
                HttpSession ss = request.getSession();
                Object loggedIn = ss.getAttribute("user");
                if (loggedIn != null) {

                return "Bruger/Bruger";
            } else {

                    return "index";
            }


            case "shop":
                return "Bruger/Shop";
            case "login":
                return "Login";
            case "signup":
                return "Signup";
            case "kurv":
                return "Bruger/Cart";
            case "logout":
                HttpSession s = request.getSession();
                s.invalidate();
                return "Login";

                // ADMIN SIDER
            case "adminHome":
                return "Admin/Admin";

                case "brugere":

              request.setAttribute("brugerListe", UserMapper.HentBrugere());

                return "Admin/Brugere";

            case "ordre":
                ArrayList<Ordre> odre = OrdreMapper.HentOrdre();

                request.setAttribute("ordreListe", odre);
                return "Admin/Ordre";

            case "tilfojBelob":
                System.out.println("hello");
                String email = request.getParameter("bruger");
                request.setAttribute("email",email);
                return "Admin/TilføjBeløb";

        }

        return "??";
    }
}
