package com.example.dovezi2.func;

import com.example.dovezi2.dao.UserDAO;
import com.example.dovezi2.user_classes.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("user")
public class UserService
{
    @Context
    ServletContext ctx;

    @Context
    HttpServletRequest request;

    private UserDAO userDAO = new UserDAO();

    public UserService(){}

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN) //check
    public Response register(User user)
    {
        userDAO.loadUsers();

        if (userDAO.findUser(user.getUsername()))
            return Response.status(200).header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .entity("User already exists").build();

        User newUser =  new User(user.getUsername(), user.getPassword(), user.getName(), user.getSurname()
                                                            , user.getPhone(), user.getEmail());
        userDAO.addUser(newUser);
        userDAO.saveUsers();
        userDAO.loadUsers();

        return Response.status(200).header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
            .entity("SVE OK").build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user)
    {
        HttpSession session = request.getSession();

        if (user.getUsername() == null || user.getPassword() == null)
            return Response.status(400).entity("Invalid request").build();
        else if (userDAO.findUser(user.getUsername()))
        {
            User loggedUser = userDAO.getUser(user.getUsername()); //if user is registered

            if (loggedUser.getPassword().equals(user.getPassword()))
            {
                session.setAttribute("user_logged_in", loggedUser); //flag him as logged in
                return Response.status(200).build();
            }
            else
                return null;
        }
        else if (session.getAttribute("user_logged_in") != null)
            return Response.status(200).build(); //user vec ulogovan, neki drugi response?
        else
            return null;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loggedUser")
    public User getLoggedUser()
    {
        HttpSession session = request.getSession();
        return (User) session.getAttribute("logged_in");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUsers")
    public Collection<User> getAllUsers()
    {
        return userDAO.getAllUserCollection();
        //return userDAO.getUsers();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/kurac")
    public String getKurac()
    {
        //return userDAO.getAllUserObj();
        return "KURCINA";
    }

}