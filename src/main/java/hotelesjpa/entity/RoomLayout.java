package hotelesjpa.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BO_ROOM_LAYOUT")
public class RoomLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BO_ROOM_BED_LAYOUT", joinColumns = @JoinColumn(name = "ROOM_LAYOUT_ID", nullable = false,
            foreignKey = @ForeignKey(name = "BO_FK_BED_LAYOUT__ROOM_LAYOUT")))
    private Set<BedLayout> bedLayouts;

    @Column(name = "OPTIONAL_CRIB", columnDefinition = "boolean")
    private Boolean optionalCrib;

    public RoomLayout(){}

    public Set<BedLayout> getBedLayouts() {
        return bedLayouts;
    }

    public void setBedLayouts(Set<BedLayout> bedLayouts) {
        this.bedLayouts = bedLayouts;
    }

    public Boolean getOptionalCrib() {
        return optionalCrib;
    }

    public void setOptionalCrib(Boolean optionalCrib) {
        this.optionalCrib = optionalCrib;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final RoomLayout other = (RoomLayout) o;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.bedLayouts, other.bedLayouts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
