package com.isi.task.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class UserMapper {
    public ResponseUser fromUser(User user) {
        return ResponseUser.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
