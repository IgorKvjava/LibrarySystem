package ua.kvelinskiy.commands;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

//import org.apache.log4j.Logger;
public class ChangeLanguageCommand implements Command {

    @Override
    public String execute (IRequestWrapper wrapper) {
        String languageProperties = "" ;
        String lang = wrapper.getParameter("language");
        Locale locale = new Locale(lang);
        if (lang.equals("ru_RU")){
            languageProperties = "language_ru.properties";
        }else {
            languageProperties = "language_en.properties";
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle(languageProperties, locale);
        return null;
    }


}
