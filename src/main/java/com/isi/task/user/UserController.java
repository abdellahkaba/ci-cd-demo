package com.isi.task.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "User")
public class UserController {
    private final UserService service;
    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ResponseUser>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<ResponseUser> getUserById(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.getUserById(userId));
    }

    @DeleteMapping("delete/{user-id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("user-id") Integer userId
    ){
        service.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/get-logged-in-profile-info")
    public ResponseEntity<ResponseUser> getLoggedUserProfile(){
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String email = authentication.getName();
        ResponseUser responseUser = service.getInfo(email);
        return ResponseEntity.ok(responseUser);
    }
}
