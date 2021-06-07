package com.epam.gpop.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Data
public class UserDto {

    private Long user_id;
    private String name;
    private String address;
    private Date created;
    private Date updated;

}
