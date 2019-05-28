package com.example.fileitemreader.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Users")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5788263514591286854L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loginId;
    private String mobile;
}
