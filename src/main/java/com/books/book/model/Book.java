package com.books.book.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Size(min = 3,max = 50,message = "Поле должно быть не мение 3 букв и не более 50")
    private String name;

    @Column(name = "author")
    @NotNull
    @Size(min = 3,max = 50,message = "Поле должно быть не мение 3 букв и не более 50 ")
    private String author;

    @Column(name = "info")
    @Size(min = 1,max = 600,message = "Поле должно быть не более 600 символов ")
    @Type(type = "text")
    private String info;


    @Column(name="photo_blob")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] photoBlob;

    @Column(name = "photo_content_length")
    private Integer photoContentLength;

    @Column(name = "photo_content_type", length = 50)
    //@NotEmpty(message = "Только изображения")
    //@Pattern(regexp = "^[a-z]{5}(.)(jpeg|png|jpg)$" ,message = "only image file")
    private String photoContentType;


    public long getId() {
        return id;
    }

    public Book() {
    }


    public byte[] getPhotoBlob() {
        return photoBlob;
    }

    public void setPhotoBlob(byte[] photoBlob) {
        this.photoBlob = photoBlob;
    }

    public Integer getPhotoContentLength() {
        return photoContentLength;
    }

    public void setPhotoContentLength(Integer photoContentLength) {
        this.photoContentLength = photoContentLength;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
