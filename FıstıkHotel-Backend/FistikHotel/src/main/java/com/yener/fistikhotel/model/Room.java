package com.yener.fistikhotel.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked=false;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @Lob
    private Blob photo;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        if (bookings == null) {
            bookings=new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked=true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
