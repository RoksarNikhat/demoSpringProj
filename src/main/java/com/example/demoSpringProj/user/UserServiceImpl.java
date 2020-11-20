package com.example.demoSpringProj.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws Exception {
//        validateUser(user);

        return userRepository.save(user);
    }

//    private void validateUser(User user) throws Exception {
//    /    if(ObjectUtils.isEmpty(user.getFirstName())){
//            throw new Exception("First Name cannot be empty");
//
//        }
//        if(ObjectUtils.isEmpty(user.getLastName())){
//            throw new Exception("Last Name cannot be empty");
//
//        }
//        if(ObjectUtils.isEmpty(user.getEmail())){
//            throw new Exception("Email cannot be empty");
//
//        }
//        if(!user.getFirstName().matches("^[a-zA-Z]+$")){
//            throw new Exception("First name can only contain alphabets");
//        }
//        if(!user.getLastName().matches("^[a-zA-Z]+$")){
//            throw new Exception("Last name can only contain alphabets");
//        }


   // }
}
