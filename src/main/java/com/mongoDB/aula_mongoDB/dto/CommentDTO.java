package com.mongoDB.aula_mongoDB.dto;



import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private String txt;
    private Date date;
    private AuthorDTO authorDTO;



    public CommentDTO(){

    }
    public CommentDTO(String txt, Date date, AuthorDTO authorDTO) {
        this.txt = txt;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
