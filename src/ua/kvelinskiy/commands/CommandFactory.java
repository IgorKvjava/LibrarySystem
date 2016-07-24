package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.User.CheckedBooksCommand;
import ua.kvelinskiy.commands.User.EditUserCommand;
import ua.kvelinskiy.commands.User.OrderBooksCommand;
import ua.kvelinskiy.commands.User.OrderGenreCommand;
import ua.kvelinskiy.commands.librarian.ClientSearchCommand;
import ua.kvelinskiy.commands.librarian.ListClientsCommand;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String, Command> commandMap = new HashMap<String, Command>();
    private static CommandFactory instance = null;

    public CommandFactory() throws NamingException {
    }

    public  static  synchronized CommandFactory getInstance(){
        if(instance == null){
            try {
                instance = new CommandFactory();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    static {
        commandMap.put("login", new LoginCommand());
        commandMap.put("SingIn", new SingInCommand());
        commandMap.put("SingPass", new CheckInCommand());
        commandMap.put("edit", new EditUserCommand());
        commandMap.put("exit", new LogoutCommand());
        commandMap.put("listClients", new ListClientsCommand());
        commandMap.put("clientSearch", new ClientSearchCommand());
        commandMap.put("order", new OrderGenreCommand());
        commandMap.put("orderGenre", new OrderBooksCommand());
        commandMap.put("CheckedBooks", new CheckedBooksCommand());
        commandMap.put("changeLanguage", new ChangeLanguageCommand());
    }

    public static Command getCommand(IRequestWrapper wrapper){
        String result = wrapper.getParameter("do");
        return commandMap.get(result);
    }

}
