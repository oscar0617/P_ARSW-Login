package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document(collection = "a")
@Data //getter y setter.
public class Player{

    @Id
    String nickName;

    @Field
    String email;

    @Field
    int level;

    public Player(String nickName, String email, int level){
        this.nickName = nickName;
        this.email = email;
        this.level = level;
    }

    
}