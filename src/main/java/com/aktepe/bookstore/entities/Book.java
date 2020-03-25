package com.aktepe.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "auto generated")
    private int id;

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = false)
    private String publisher;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(required = true)
    private Author author;

    @ApiModelProperty(required = true)
    private int publicationYear;

    @ApiModelProperty(required = true)
    private String genre;
}