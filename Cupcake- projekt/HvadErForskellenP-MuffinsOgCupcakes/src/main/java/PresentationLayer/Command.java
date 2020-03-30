package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put(("to"), new Navigation());
        commands.put(("muffin"), new AddMuffinToBasket());
        commands.put(("basket"), new AddBasketToDB());
        commands.put(("muffindel"), new DeleteFromBasket());
        commands.put(("deleteBruger"), new DeleteBruger());
        commands.put(("checkoutBasket"), new CheckoutBasket());
        commands.put(("tilfojBelob"), new TilføjBeløb());
    }

    static Command from( HttpServletRequest request ) {
        System.out.println(request.getParameter("target"));
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
