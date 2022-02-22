package com.spring.Task.Task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="nationalID")//should present his/her ID or passport number (in case of a foreigner)
    private String nationalID;

    @Column(name="phone_number")
    private String phone;


    @Column(name="Date_old_Operator")// owning the number with the Donor Recipient in his/her name for at least 4 months.
    private String Date_operator;

    @Column(name="Operator")//organziation vodafone orange Etisialat
    private String operator;



}


