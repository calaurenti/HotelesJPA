package hotelesjpa.service;

import hotelesjpa.entity.*;
import hotelesjpa.entity.type.FeeType;
import hotelesjpa.entity.type.MealPlan;
import hotelesjpa.entity.type.PaymentMethod;
import hotelesjpa.entity.type.RoomPricingType;
import hotelesjpa.repository.HotelName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = {"hotelesjpa"})
public class HotelServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @Before
    public void init(){
        loadData();
    }

    @Test
    public void whenFindById_thenReturnHotel() {
        // given

        // when
        Optional<Hotel> found = hotelService.findById(10001L);

        // then
        assertEquals(10001L, found.get().getId().longValue());

    }

    @Test
    public void whenFindById_thenIsPresentReturnFalse() {
        // given

        // when
        Optional<Hotel> found = hotelService.findById(10000L);

        // then
        assertEquals(false, found.isPresent());

    }

    @Test
    public void whenFindByCityId_thenReturnHotels(){
        // when
        Set<Hotel> found = hotelService.findAllByCityId("982");
        // then
        assertThat(found.size(), equalTo(2));
    }

    @Test
    public void whenFindByCityIdCustom_thenReturnHotels(){
        Set<Hotel> found = hotelService.findAllByCityIdCustom("982");

        assertThat(found.size(), equalTo(2));
    }

    @Test
    public void whenFindByName_thenReturnHotel(){
        Optional<Hotel> found = hotelService.findByName("San Remo");

        assertThat(found.get().getId(), equalTo(10001L));
    }

    @Test
    public void whenFindAllHotelNamesByCityId_thenReturnHotelNames(){
        List<HotelName> found = hotelService.findAllHotelNamesByCityId("982");

        assertThat(found.size(), equalTo(2));
    }

    @Test
    public void whenFindAllHotelByExample_thenReturnHotels(){

        Hotel hotel = new Hotel();
        hotel.setCityId("982");
        List<Hotel> found = hotelService.findAll(hotel);

        assertThat(found.size(), equalTo(2));
    }

    public void loadData(){

        //--------------------------------------- Bed Layouts ----------------------------------------------------------------
        BedLayout bedLayout1 = new BedLayout();
        bedLayout1.setCode("DBL");
        bedLayout1.setCount((short)4);

        BedLayout bedLayout2 = new BedLayout();
        bedLayout1.setCode("SNG");
        bedLayout1.setCount((short)6);

        //--------------------------------------- Room Layouts ----------------------------------------------------------------
        RoomLayout rlayout1 = new RoomLayout();
        rlayout1.setBedLayouts(new HashSet(){{
            add(bedLayout1);
        }});

        RoomLayout rlayout2 = new RoomLayout();
        rlayout2.setBedLayouts(new HashSet(){{
            add(bedLayout1);
            add(bedLayout2);
        }});

        //--------------------------------------- Room Rate Ranges ----------------------------------------------------------------
        RoomRateRange range1 = new RoomRateRange();
        range1.setCurrency("ARS");
        range1.setMaxRate(new BigDecimal("2600.00"));
        range1.setMinRate(new BigDecimal("2100.00"));

        //--------------------------------------- Rooma ----------------------------------------------------------------
        Room room1 = new Room();
        room1.setId(1001L);
        room1.setLayouts(new HashSet(){{
            add (rlayout1);
        }});
        room1.setHasGuaranteedAllotment(Boolean.FALSE);
        room1.setAllowsExtraCharges(Boolean.FALSE);
        room1.setName("Sample Room");
        room1.setRateBounds(new HashSet(){{
            add(range1);
        }});

        //entityManager.persist(room1);

        Room room2 = new Room();
        room2.setId(1001L);
        room2.setLayouts(new HashSet(){{
            add (rlayout1);
        }});
        room2.setHasGuaranteedAllotment(Boolean.FALSE);
        room2.setAllowsExtraCharges(Boolean.FALSE);
        room2.setName("Sample Room 2");
        room2.setRateBounds(new HashSet(){{
            add(range1);
        }});

        Room room3 = new Room();
        room3.setId(1002L);
        room3.setLayouts(new HashSet(){{
            add (rlayout2);
        }});
        room3.setHasGuaranteedAllotment(Boolean.FALSE);
        room3.setAllowsExtraCharges(Boolean.FALSE);
        room3.setName("Sample Room 3");
        room3.setRateBounds(new HashSet(){{
            add(range1);
        }});

        //--------------------------------------- Hotels  ----------------------------------------------------------------
        Hotel hotelSanRemo = new Hotel();
        hotelSanRemo.setId(10001L);
        hotelSanRemo.setName("San Remo");
        hotelSanRemo.setActive(Boolean.TRUE);
        hotelSanRemo.setCityId("982");
        hotelSanRemo.setContracts(new HashSet<>());
        hotelSanRemo.setCurrencies(new HashSet(){{
            add("ARS");
            add("U$D");
        }});
        hotelSanRemo.setFeeType(FeeType.COMMISSIONABLE);
        hotelSanRemo.setMealPlans(new HashSet(){{
            add(MealPlan.ALL_INCLUSIVE);
            add(MealPlan.AMERICAN_BREAKFAST);
        }});
        Set<CommissionedPaymentMethod> paymentMethods = new HashSet<>();
        hotelSanRemo.setPaymentMethods(paymentMethods);
        hotelSanRemo.setRoomPricingType(RoomPricingType.PER_ROOM_PER_NIGHT);
        hotelSanRemo.setRooms(new HashSet(){{
            add(room1);
        }});
        room1.setHotel(hotelSanRemo);
        entityManager.persist(hotelSanRemo);
        entityManager.persist(room1);

        Hotel hotelHolidayInn = new Hotel();
        hotelHolidayInn.setId(10022L);
        hotelHolidayInn.setName("Holiday Inn");
        hotelHolidayInn.setActive(Boolean.TRUE);
        hotelHolidayInn.setCityId("982");
        hotelHolidayInn.setContracts(new HashSet<>());
        hotelHolidayInn.setCurrencies(new HashSet(){{
            add("ARS");
            add("U$D");
        }});
        hotelHolidayInn.setFeeType(FeeType.COMMISSIONABLE);
        hotelHolidayInn.setMealPlans(new HashSet(){{
            add(MealPlan.ALL_INCLUSIVE);
            add(MealPlan.AMERICAN_BREAKFAST);
        }});
        hotelHolidayInn.setPaymentMethods(paymentMethods);
        hotelHolidayInn.setRoomPricingType(RoomPricingType.PER_ROOM_PER_NIGHT);
        hotelHolidayInn.setRooms(new HashSet(){{
            add(room1);
        }});
        entityManager.persist(hotelHolidayInn);

        Hotel hotelLasVegas = new Hotel();
        hotelLasVegas.setId(10048L);
        hotelLasVegas.setName("Las Vegas");
        hotelLasVegas.setActive(Boolean.TRUE);
        hotelLasVegas.setCityId("2346");
        hotelLasVegas.setContracts(new HashSet<>());
        hotelLasVegas.setCurrencies(new HashSet(){{
            add("ARS");
            add("U$D");
        }});
        hotelLasVegas.setFeeType(FeeType.COMMISSIONABLE);
        hotelLasVegas.setMealPlans(new HashSet(){{
            add(MealPlan.ALL_INCLUSIVE);
            add(MealPlan.AMERICAN_BREAKFAST);
        }});
        hotelLasVegas.setPaymentMethods(paymentMethods);
        hotelLasVegas.setRoomPricingType(RoomPricingType.PER_ROOM_PER_NIGHT);
        hotelLasVegas.setRooms(new HashSet(){{
            add(room2);
            add(room3);
        }});
        entityManager.persist(hotelLasVegas);

        //---------------------------------------------------------------------------------------------------------------
        entityManager.flush();
    }
}
