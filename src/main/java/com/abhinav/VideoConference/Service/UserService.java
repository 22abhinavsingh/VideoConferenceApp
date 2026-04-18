package com.abhinav.VideoConference.Service;

import com.abhinav.VideoConference.User.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    public void registerUser(User user){
        user.setStatus("offline");
        USER_LIST.add(user);
    }

    public User login(User user){

        System.out.println("UserEmail"+user.getEmail());
        System.out.println("UserPassword"+user.getPassword());

        var userIndex = IntStream.range(0,USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny().orElseThrow(()->new RuntimeException("User Not Found!"));

        var cUser= USER_LIST.get(userIndex);

        if(!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Incorrect Username Or Password!");
        }

        cUser.setStatus("online");
        return cUser;

    }


    public void logout(User user){
        var userIndex = IntStream.range(0,USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny().orElseThrow(()->new RuntimeException("User Not Found!"));

        USER_LIST.get(userIndex).setStatus("offline");

    }

    public List<User> findAll(){
        return USER_LIST;
    }

}
