
package com.sonnytron.sortatech.pantryprep.Models.Recipes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Image {

    @SerializedName("hostedSmallUrl")
    @Expose
    private String hostedSmallUrl;
    @SerializedName("hostedMediumUrl")
    @Expose
    private String hostedMediumUrl;
    @SerializedName("hostedLargeUrl")
    @Expose
    private String hostedLargeUrl;
    @SerializedName("imageUrlsBySize")
    @Expose
    private ImageUrlsBySize imageUrlsBySize;

    /**
     *
     * @return
     *     The hostedSmallUrl
     */
    public String getHostedSmallUrl() {
        return hostedSmallUrl;
    }

    /**
     *
     * @param hostedSmallUrl
     *     The hostedSmallUrl
     */
    public void setHostedSmallUrl(String hostedSmallUrl) {
        this.hostedSmallUrl = hostedSmallUrl;
    }

    /**
     *
     * @return
     *     The hostedMediumUrl
     */
    public String getHostedMediumUrl() {
        return hostedMediumUrl;
    }

    /**
     *
     * @param hostedMediumUrl
     *     The hostedMediumUrl
     */
    public void setHostedMediumUrl(String hostedMediumUrl) {
        this.hostedMediumUrl = hostedMediumUrl;
    }

    /**
     *
     * @return
     *     The hostedLargeUrl
     */
    public String getHostedLargeUrl() {
        return hostedLargeUrl;
    }

    /**
     *
     * @param hostedLargeUrl
     *     The hostedLargeUrl
     */
    public void setHostedLargeUrl(String hostedLargeUrl) {
        this.hostedLargeUrl = hostedLargeUrl;
    }

    /**
     *
     * @return
     *     The imageUrlsBySize
     */
    public ImageUrlsBySize getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    /**
     *
     * @param imageUrlsBySize
     *     The imageUrlsBySize
     */
    public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
        this.imageUrlsBySize = imageUrlsBySize;
    }

}
