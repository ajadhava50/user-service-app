package com.epam.gpop.entity;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Entity(name = "usr_user")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private Long user_id;
    private String name;
    private String address;
    private Date created;
    private Date updated;
}
