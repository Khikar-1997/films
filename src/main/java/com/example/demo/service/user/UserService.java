package com.example.demo.service.user;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.persistance.model.user.User;
import com.example.demo.persistance.repository.user.UserRepository;
import com.example.demo.rest.model.user.UserRequestModel;
import com.example.demo.rest.model.user.UserResponseModel;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //region public Methods

    public UserResponseModel create(UserRequestModel userRequestModel) {
        LOGGER.info("Request to create user - {}", userRequestModel);
        User user = buildUserModelFrom(userRequestModel);
        User createUser = userRepository.save(user);
        UserResponseModel userResponseModel = buildUserResponseModelFrom(createUser);
        LOGGER.info("User successfully created - {}", userResponseModel);
        return userResponseModel;
    }

    public List<UserResponseModel> selectAllUsers() {
        LOGGER.info("Request to select all users");
        List<User> users = userRepository.findAll();
        List<UserResponseModel> collect = users.stream()
                .map(this::buildUserResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All users successfuly selected - {}", collect);
        return collect;
    }

    public UserResponseModel findUserById(Long id) {
        LOGGER.info("Request to find user by id - {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found for id - {}%d", id)));
        UserResponseModel userResponseModel = buildUserResponseModelFrom(user);
        LOGGER.info("User successfully be find by id - {}", userResponseModel);
        return userResponseModel;
    }

    public UserResponseModel update(Long id, UserRequestModel userRequestModel) {
        LOGGER.info("Request to update user by id - {} - {}", id, userRequestModel);
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found for id - {}%d", id)));
        userById.setName(userRequestModel.getName());
        userById.setSurname(userRequestModel.getSurname());
        userById.setPhoneNumber(userRequestModel.getPhoneNumber());
        userById.setAge(userRequestModel.getAge());
        userById.setUsername(userRequestModel.getUsername());
        userById.setPassword(userRequestModel.bCryptPassword());
        User updateUser = userRepository.save(userById);
        UserResponseModel userResponseModel = buildUserResponseModelFrom(updateUser);
        LOGGER.info("User successfully updated by id - {}", userResponseModel);
        return userResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete user by id - {}", id);
        userRepository.deleteById(id);
        LOGGER.info("User successfully deleted");
    }

    public boolean login(String username, UserRequestModel userRequestModel) {
        LOGGER.info("Request to check is user valid or not");
        User user = userRepository.findByUsername(username);
        User user1 = new User();
        user1.setPassword(userRequestModel.getPassword());
        return BCrypt.checkpw(user1.getPassword(),user.getPassword());
    }

    //endregion

    //region private Methods

    private User buildUserModelFrom(UserRequestModel userRequestModel) {
        User user = new User();
        user.setName(userRequestModel.getName());
        user.setSurname(userRequestModel.getSurname());
        user.setPhoneNumber(userRequestModel.getPhoneNumber());
        user.setAge(userRequestModel.getAge());
        user.setUsername(userRequestModel.getUsername());
        user.setPassword(userRequestModel.bCryptPassword());
        return user;
    }

    private UserResponseModel buildUserResponseModelFrom(User user) {
        UserResponseModel userResponseModel = new UserResponseModel();
        userResponseModel.setId(user.getId());
        userResponseModel.setName(user.getName());
        userResponseModel.setSurname(user.getSurname());
        userResponseModel.setPhoneNumber(user.getPhoneNumber());
        userResponseModel.setAge(user.getAge());
        userResponseModel.setUsername(user.getUsername());
        userResponseModel.setPassword(user.getPassword());
        return userResponseModel;
    }

    //endregion
}
