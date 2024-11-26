package com.isi.task.user;

import com.isi.task.handler.BusinessErrorCodes;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    public List<ResponseUser> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromUser)
                .toList();
    }
    public ResponseUser getUserById(Integer userId) {
        return repository.findById(userId)
                .map(mapper::fromUser)
                .orElseThrow(() -> new EntityNotFoundException(BusinessErrorCodes.ENTITY_NOT_FOUND.getDescription()));
    }
    public void deleteUser(Integer userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(BusinessErrorCodes.ENTITY_NOT_FOUND.getDescription()));
        repository.delete(user);
    }

    public ResponseUser getInfo(String email) {
        return repository.findByEmail(email)
                .map(mapper::fromUser)
                .orElseThrow(() -> new EntityNotFoundException(BusinessErrorCodes.ENTITY_NOT_FOUND.getDescription()));
    }
}
