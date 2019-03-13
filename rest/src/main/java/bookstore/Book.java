package bookstore;

import java.io.Serializable;

public class Book implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String author;
    private String name;
    private String genre;

    public Book(){}

    public Book(int id, String author, String name, String genre){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        else{
            Book book = (Book) object;
            if(author.equals(book.getAuthor()) && name.equals(book.getName()) && genre.equals(book.getGenre())) return true;
        }
        return false;
    }
}
