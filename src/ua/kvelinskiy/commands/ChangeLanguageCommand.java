package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import javax.servlet.http.HttpSession;
//import org.apache.log4j.Logger;

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute (IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String path = (String) session.getAttribute("path");
        String locale = (String) wrapper.getAttributes("language");
        //wrapper.setAttributes("locale", locale);
        session.setAttribute("locale", locale);
        if (path == null) {
            return "/index.jsp";
        } else {
            return path;
        }

    }


}
