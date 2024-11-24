package com.isi.task.user;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private Integer id;
    private String name;
    private String email;
}
