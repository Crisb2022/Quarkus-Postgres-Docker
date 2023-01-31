package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String isbn;
    private String title;
    private double price;
}
