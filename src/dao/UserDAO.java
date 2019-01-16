package dao;

import user_classes.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UserDAO
{
    private Map<String, User> users = new HashMap<>();

    public UserDAO() {}

    public UserDAO(String contextPath)
    {
        loadUsers(contextPath);
    }

    private void loadUsers(String contextPath)
    {
        BufferedReader in;

        try {
            File file = new File(contextPath + "/users.txt");
            in = new BufferedReader(new FileReader(file));
            String line;
            StringTokenizer stringTokenizer;

            while ((line = in.readLine()) != null)
            {
                line = line.trim();

                if (line.equals("") || line.indexOf('#') == 0)
                    continue;

                stringTokenizer = new StringTokenizer(line, ";");

                while (stringTokenizer.hasMoreTokens())
                {
                    /* check this data order later */
                    String username = stringTokenizer.nextToken().trim();
                    String password = stringTokenizer.nextToken().trim();
                    String firstName = stringTokenizer.nextToken().trim();
                    String lastName = stringTokenizer.nextToken().trim();
                    String role = stringTokenizer.nextToken().trim();
                    String phone = stringTokenizer.nextToken().trim();
                    String email = stringTokenizer.nextToken().trim();
                    String date = stringTokenizer.nextToken().trim();

                    users.put(username, new User(username, password, firstName, lastName, role, phone, email, date));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
