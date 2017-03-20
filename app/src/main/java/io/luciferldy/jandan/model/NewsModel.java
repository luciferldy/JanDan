package io.luciferldy.jandan.model;

import android.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Lucifer on 2017/3/18.
 */

public class NewsModel {

    public String title;
    public String summary;
    public String editor;
    public String tag;
    public String imgUrl;
    public String comment;

    public NewsModel(String title, String summary, String editor, String tag, String imgUrl, String comment) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    // I use the custom
    // solution in <a href = http://stackoverflow.com/questions/35313466/android-databinding-custom-binding-adapter-warning />
    @BindingAdapter({"imageUrl"})
    public static void loadImage(SimpleDraweeView view, String imageUrl) {
        view.setImageURI(imageUrl);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
