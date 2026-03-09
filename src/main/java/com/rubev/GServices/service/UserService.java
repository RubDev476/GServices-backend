package com.rubev.GServices.service;

import com.rubev.GServices.dto.UserRegisterDTO;
import com.rubev.GServices.model.User;
import com.rubev.GServices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(UserRegisterDTO userRegister) {
        User user = new User();

        user.setEmail(userRegister.getEmail());
        user.setPassword(userRegister.getPassword());
        user.setName(userRegister.getName());
        user.setType(userRegister.getType());
        user.setUrlImg(userRegister.getUrlImg());
        user.setPhone(userRegister.getPhone());
        user.setRoles(userRegister.getRoles());

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean  updateUser(Long id, UserRegisterDTO userUpdated) {
        return userRepository.findById(id)
                .map(currentUser -> {
                    currentUser.setEmail(userUpdated.getEmail());
                    currentUser.setPassword(userUpdated.getPassword());
                    currentUser.setName(userUpdated.getName());
                    currentUser.setType(userUpdated.getType());
                    currentUser.setUrlImg(userUpdated.getUrlImg());
                    currentUser.setPhone(userUpdated.getPhone());
                    currentUser.setRoles(userUpdated.getRoles());

                    userRepository.save(currentUser);

                    return true;
                }).orElse(false);
    }
}
