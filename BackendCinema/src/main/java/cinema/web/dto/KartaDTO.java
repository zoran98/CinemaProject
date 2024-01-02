package cinema.web.dto;

import java.time.LocalDateTime;

public class KartaDTO {

    private Long id;

    private Long projekcijaId;

    private Long sedisteId;
    private Integer sedisteRedniBroj;

    private LocalDateTime datumIVremeProdaje;

    private Long userId;
    private String userUsername;

    public KartaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjekcijaId() {
        return projekcijaId;
    }

    public void setProjekcijaId(Long projekcijaId) {
        this.projekcijaId = projekcijaId;
    }

    public Long getSedisteId() {
        return sedisteId;
    }

    public void setSedisteId(Long sedisteId) {
        this.sedisteId = sedisteId;
    }

    public Integer getSedisteRedniBroj() {
        return sedisteRedniBroj;
    }

    public void setSedisteRedniBroj(Integer sedisteRedniBroj) {
        this.sedisteRedniBroj = sedisteRedniBroj;
    }

    public LocalDateTime getDatumIVremeProdaje() {
        return datumIVremeProdaje;
    }

    public void setDatumIVremeProdaje(LocalDateTime datumIVremeProdaje) {
        this.datumIVremeProdaje = datumIVremeProdaje;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
