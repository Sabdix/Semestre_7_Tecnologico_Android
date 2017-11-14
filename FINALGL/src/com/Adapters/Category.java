
package com.Adapters;

import android.graphics.drawable.Drawable;

/**
 *
 * @author sabdi
 */
public class Category {
    private String title;
    private String categoryId;
    private Drawable imagen;
    
    public Category() {
        super();
    }
    
    public Category(String categoryId, String title, Drawable imagen) {
        super();
        this.title = title;
        this.imagen = imagen;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
    

    
    
}
