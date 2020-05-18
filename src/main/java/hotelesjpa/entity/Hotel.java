package hotelesjpa.entity;


import hotelesjpa.entity.type.FeeType;
import hotelesjpa.entity.type.MealPlan;
import hotelesjpa.entity.type.RoomPricingType;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "BO_HOTEL")
@Access(AccessType.FIELD)
@NamedQuery(name = "Hotel.findAllByCityIdCustom", query = "select h from Hotel h where h.cityId = ?1")
public class Hotel {

    // HRM id
    @Id
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "ACTIVE", columnDefinition = "boolean")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTEL_ID", foreignKey = @ForeignKey(name = "BO_FK_HOTEL__COMMISSIONED_PAYMENT_METHOD"))
    private Set<CommissionedPaymentMethod> paymentMethods;

    @Column(name = "FEE_TYPE", nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    @Column(name = "TAXES_INCLUSIVE", columnDefinition = "boolean")
    private Boolean taxesInclusive;

    @Column(name = "CURRENCY_TYPE", length = 3)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BO_CURRENCY", joinColumns = @JoinColumn(name = "HOTEL_ID"))
    private Set<String> currencies;

    @Column(name = "CONTRACT_ID", nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BO_CONTRACT", joinColumns = @JoinColumn(name = "HOTEL_ID"))
    private Set<String> contracts;

    @Column(name = "ROOM_PRICING_TYPE", nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private RoomPricingType roomPricingType;

    @Column(name = "MEALPLAN", length = 31)
    @CollectionTable(name = "BO_HOTEL_MEALPLAN", joinColumns = @JoinColumn(name = "HOTEL_ID"))
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<MealPlan> mealPlans;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private Set<Room> rooms;

    @Column(name = "CITY_ID", nullable = false)
    private String cityId;

    public Hotel() {
    }

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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<CommissionedPaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<CommissionedPaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public Boolean getTaxesInclusive() {
        return taxesInclusive;
    }

    public void setTaxesInclusive(Boolean taxesInclusive) {
        this.taxesInclusive = taxesInclusive;
    }

    public Set<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<String> currencies) {
        this.currencies = currencies;
    }

    public Set<String> getContracts() {
        return contracts;
    }

    public void setContracts(Set<String> contracts) {
        this.contracts = contracts;
    }

    public RoomPricingType getRoomPricingType() {
        return roomPricingType;
    }

    public void setRoomPricingType(RoomPricingType roomPricingType) {
        this.roomPricingType = roomPricingType;
    }

    public Set<MealPlan> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(Set<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

}
