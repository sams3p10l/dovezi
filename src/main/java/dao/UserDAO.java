package dao;


import loadnsave.UserLoader;
import user_classes.User;

import java.util.*;

public class UserDAO
{
    private UserLoader userLoader = new UserLoader();

    public UserDAO() {}

//    private void loadUsers(String contextPath)
//    {
//        BufferedReader in;
//
//        try {
//            File file = new File(contextPath + "/users.txt");
//            in = new BufferedReader(new FileReader(file));
//            String line;
//            StringTokenizer stringTokenizer;
//
//            while ((line = in.readLine()) != null)
//            {
//                line = line.trim();
//
//                if (line.equals("") || line.indexOf('#') == 0)
//                    continue;
//
//                stringTokenizer = new StringTokenizer(line, ";");
//
//                while (stringTokenizer.hasMoreTokens())
//                {
//                    /* check this data order later */
//                    String username = stringTokenizer.nextToken().trim();
//                    String password = stringTokenizer.nextToken().trim();
//                    String firstName = stringTokenizer.nextToken().trim();
//                    String lastName = stringTokenizer.nextToken().trim();
//                    String role = stringTokenizer.nextToken().trim();
//                    String phone = stringTokenizer.nextToken().trim();
//                    String email = stringTokenizer.nextToken().trim();
//                    String date = stringTokenizer.nextToken().trim();
//
//                    users.put(username, new User(username, password, firstName, lastName, role, phone, email, date));
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean findUser(String username)
    {
        return userLoader.getUsers().containsKey(username);
    }

    public void addUser(User pUser)
    {
        if(pUser != null)
            userLoader.getUsers().put(pUser.getUsername(), pUser);

        //TODO: role check
    }

    public User getUser(String username)
    {
        if (userLoader.getUsers().containsKey(username))
            return userLoader.getUsers().get(username);

        return null;
    }

    public Map getUsers()
    {
        return userLoader.getUsers();
    }

    public Collection<User> getAllUserObj() {
        return userLoader.getUsers().values();
    }
}
