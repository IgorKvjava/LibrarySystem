package ua.kvelinskiy.controllers;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.CommandFactory;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.commands.RequestWrapper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IRequestWrapper wrapper = new RequestWrapper(request);
        Command command = CommandFactory.getInstance().getCommand(wrapper);
        String path= command.execute(wrapper);
        RequestDispatcher rd=request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
