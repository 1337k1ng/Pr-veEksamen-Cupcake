package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );

       if (errorHandle(email, password1, password2, request)) {
            User user = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return "Bruger/Bruger";
        } else {
          //  throw new LoginSampleException( "the two passwords did not match" );



           return "Signup";
        }
    }


    private Boolean errorHandle(String email, String pass1, String pass2, HttpServletRequest request){

        String regex = "^(.+)@(.+)$";
         if (!email.matches(regex))   {
            request.setAttribute("error", "Email kan ikke bruges, skriv en rigtig en!");
                return false;
         }

        if (UserMapper.checkIfEmailExists(email)){
               request.setAttribute("error", "Email er allerede i brug");
               return false;
        }

        if (pass1.length() < 6) {
            request.setAttribute("error", "Password skal være over 6 tegn");
            return false;
        }
         if (!pass1.equals(pass2)){
              request.setAttribute("error", "Passwords matcher ikke ");
              return false;
         }

        return true;
    }

}
