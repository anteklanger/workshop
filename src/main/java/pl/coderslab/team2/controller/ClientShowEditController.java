package pl.coderslab.team2.controller;

import pl.coderslab.team2.dao.ClientDao;
import pl.coderslab.team2.entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ClientShowEditController")
public class ClientShowEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int clientToEditId = Integer.parseInt(request.getParameter("id"));

        Client actualDataClient = ClientDao.findById(clientToEditId);
        request.setAttribute("actual", actualDataClient);
        getServletContext().getRequestDispatcher("/clientEditController.jsp").forward(request, response);

//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
//        String date = request.getParameter("birthdate");
//
//
//        response.getWriter().append(firstName + " " + lastName + " " + date + " ");
//
//        Client client = new Client();
//        client.setFirstName(firstName);
//        client.setLastName(lastName);
//        client.setBirthDate(date);
//        client.setId(clientToEditId);
//        int result = ClientDao.updateUserDataInDb(client);
//        response.getWriter().append("result: " + result);
//
//        if (result != 0) response.sendRedirect("/ClientShowAllController");
    }
}
