package library.model.repository;

import library.model.User;

public interface UserRepository {
    void registerUser(User user);
    User findUserById(String id);
}
