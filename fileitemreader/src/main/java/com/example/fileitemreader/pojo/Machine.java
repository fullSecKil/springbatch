package com.example.fileitemreader.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Machine")
@Data
public class Machine implements Serializable {
    private static final long serialVersionUID = 1380355093356650365L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sampName;
    private int unitId;
}
