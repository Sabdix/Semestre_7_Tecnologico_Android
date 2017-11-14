/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Adapters;

/**
 *
 * @author sabdi
 */
public class Video {
    private String videoTitle;
    private String videoThumbnail;
    private String videoId;
    public String getVideoTitle() {
        return videoTitle;
    }
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
    public String getVideoThumbnail() {
        return videoThumbnail;
    }
    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }
    public String getVideoId() {
        return videoId;
    }
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
    public Video(String videoTitle, String videoThumbnail, String videoId) {
        super();
        this.videoTitle = videoTitle;
        this.videoThumbnail = videoThumbnail;
        this.videoId = videoId;
    }
    
    public Video() {
        super();
    }
    @Override
    public String toString() {
        return "Video [videoTitle=" + videoTitle + ", videoThumbnail="
                + videoThumbnail + ", videoId=" + videoId + "]";
    }

}
