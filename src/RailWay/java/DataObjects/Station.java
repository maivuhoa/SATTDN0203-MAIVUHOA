package DataObjects;

public enum Station {
    SAIGON("Sài Gòn"),
    NHATRANG("Nha Trang"),
    DANANG("Đà Nẵng"),
    PHANTHIET("Phan Thiết"),
    HUE("Huế"),
    QUANGNGAI("Quảng Ngãi");
    public final String departStation;

    Station(String departStation) {
        this.departStation = departStation;
    }

    public String getStation() {
        return this.departStation;
    }

}
