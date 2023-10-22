package com.esprit.microservices.produittest.response;

import java.time.LocalDateTime;

public class BlogResponse {
    private Long idBlog;
    private String titre ;
    private String image ;
    private String sponsor ;
    private String description ;

    private LocalDateTime createTimestamp;

    private LocalDateTime updateTimestamp;
    public BlogResponse(long id, String titre, String image, String sponsor, String description, LocalDateTime createTimestamp, LocalDateTime updateTimestamp) {
        this.idBlog = id;
        this.titre = titre;
        this.image = image;
        this.sponsor = sponsor;
        this.description = description;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Long idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
