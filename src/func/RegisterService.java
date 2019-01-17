package func;

import dao.UserDAO;
import user_classes.User;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.Media;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("")
public class RegisterService
{
    @Context
    ServletContext ctx;

    public RegisterService(){}

    @PostConstruct
    public void init() //ne ovde?
    {
        if (ctx.getAttribute("userDAO") == null)
        {
            String contextPath = ctx.getRealPath("");
            ctx.setAttribute("userDAO", new UserDAO(contextPath));
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) //check
    public Response register(User user, @Context HttpServletRequest request)
    {
        UserDAO userDAO = (UserDAO) ctx.getAttribute("userDAO");
        Map<String, User> mUsers = userDAO.getUsers();

        if (mUsers.containsKey(user.getUsername()))
            return Response.status(400).entity("User already exists").build();

        User newUser =  new User(user.getUsername(), user.getPassword(), user.getName(), user.getSurname()
                                                    , user.getUloga(), user.getPhone(), user.getEmail());
        mUsers.put(user.getUsername(), newUser);

        return Response.status(200).build();
    }

}