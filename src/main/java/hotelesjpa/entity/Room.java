package hotelesjpa.entity;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQuery(name = "Room.findByNameCustom", query = "select r from Room r where r.name = ?1")
@Table(name = "BO_ROOM")
public class Room {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "HAS_GUARANTEED_ALLOTMENT", columnDefinition = "boolean")
    private Boolean hasGuaranteedAllotment;

    @Column(name = "ALLOWS_EXTRA_CHARGES", columnDefinition = "boolean")
    private Boolean allowsExtraCharges;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID", nullable = false, foreignKey = @ForeignKey(name = "BO_FK_ROOM_LAYOUT__ROOM"))
    private Set<RoomLayout> layouts;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BO_ROOM_RATE_RANGE", joinColumns = @JoinColumn(name = "ROOM_ID", nullable = false,
            foreignKey = @ForeignKey(name = "BO_FK_ROOM_RATE_RANGE__ROOM")))
    private Set<RoomRateRange> rateBounds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTEL_ID", nullable = false, foreignKey = @ForeignKey(name = "BO_FK_ROOM__HOTEL",
            foreignKeyDefinition = "FOREIGN KEY (HOTEL_ID) REFERENCES BO_HOTEL(ID)"))
    private Hotel hotel;

    public Room(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasGuaranteedAllotment() {
        return hasGuaranteedAllotment;
    }

    public void setHasGuaranteedAllotment(Boolean hasGuaranteedAllotment) {
        this.hasGuaranteedAllotment = hasGuaranteedAllotment;
    }

    public Boolean getAllowsExtraCharges() {
        return allowsExtraCharges;
    }

    public void setAllowsExtraCharges(Boolean allowsExtraCharges) {
        this.allowsExtraCharges = allowsExtraCharges;
    }

    public Set<RoomLayout> getLayouts() {
        return layouts;
    }

    public void setLayouts(Set<RoomLayout> layouts) {
        this.layouts = layouts;
    }

    public Set<RoomRateRange> getRateBounds() {
        return rateBounds;
    }

    public void setRateBounds(Set<RoomRateRange> rateBounds) {
        this.rateBounds = rateBounds;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
