package sidespell.tech.viewholderquiz;

import android.graphics.Bitmap;

/**
 * Created by BSIT on 1/14/2016.
 */
public class MovieImage{
    private Bitmap image;
    private String title;

    public MovieImage(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }



}
