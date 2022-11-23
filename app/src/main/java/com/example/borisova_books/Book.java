package com.example.borisova_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{
    private int IdBook;
    private String TitleBook;
    private String Annitation;
    private String Summary;
    private int IdLink;
    private String Link;
    private int IdGenreBook;
    private int IdGenre;
    private String TitleGenre;
    private int IdAuthor;
    private String Author;
    private String Image;

    protected Book(Parcel in)
    {
        IdBook = in.readInt();
        IdLink = in.readInt();
        IdGenreBook = in.readInt();
        IdGenre = in.readInt();
        IdAuthor = in.readInt();
        TitleBook = in.readString();
        Annitation = in.readString();
        Summary = in.readString();
        Link = in.readString();
        TitleGenre = in.readString();
        Author = in.readString();
        Image = in.readString();
    }
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>()
    {
        @Override
        public Book createFromParcel(Parcel in) {return new Book(in);}
        @Override
        public Book[] newArray(int i) {return new Book[i];}
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdBook);
        parcel.writeInt(IdLink);
        parcel.writeInt(IdGenreBook);
        parcel.writeInt(IdGenre);
        parcel.writeInt(IdAuthor);
        parcel.writeString(TitleBook);
        parcel.writeString(Annitation);
        parcel.writeString(Summary);
        parcel.writeString(Link);
        parcel.writeString(TitleGenre);
        parcel.writeString(Author);
        parcel.writeString(Image);
    }

    public void setIdBook(int idBook) {
        IdBook = idBook;
    }

    public void setTitleBook(String titleBook) {
        TitleBook = titleBook;
    }

    public void setAnnitation(String annitation) {
        Annitation = annitation;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setIdLink(int idLink) {
        IdLink = idLink;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setIdGenreBook(int idGenreBook) {
        IdGenreBook = idGenreBook;
    }

    public void setIdGenre(int idGenre) {
        IdGenre = idGenre;
    }

    public void setTitleGenre(String titleGenre) {
        TitleGenre = titleGenre;
    }

    public void setIdAuthor(int idAuthor) {
        IdAuthor = idAuthor;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getIdBook() {
        return IdBook;
    }

    public String getTitleBook() {
        return TitleBook;
    }

    public String getAnnitation() {
        return Annitation;
    }

    public String getSummary() {
        return Summary;
    }

    public int getIdLink() {
        return IdLink;
    }

    public String getLink() {
        return Link;
    }

    public int getIdGenreBook() {
        return IdGenreBook;
    }

    public int getIdGenre() {
        return IdGenre;
    }

    public String getTitleGenre() {
        return TitleGenre;
    }

    public int getIdAuthor() {
        return IdAuthor;
    }

    public String getAuthor() {
        return Author;
    }

    public String getImage() {
        return Image;
    }
}
