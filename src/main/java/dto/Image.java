package dto;

import java.util.Objects;

public class Image {
    private Long imageId;
    private String URL;
    private Master master;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(imageId, image.imageId) &&
                Objects.equals(URL, image.URL) &&
                Objects.equals(master, image.master);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imageId, URL, master);
    }
}
