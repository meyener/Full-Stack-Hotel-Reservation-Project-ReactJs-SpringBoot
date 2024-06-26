package com.yener.fistikhotel.model.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private RoomResponse room;

    public static BookingResponse returnBookingResponseByOnly4params(Long bookingId,LocalDate checkInDate,LocalDate checkOutDate,String bookingConfirmationCode){
        return BookingResponse.builder()
                .bookingId(bookingId)
                .checkInDate(checkInDate)
                .checkOutDate(checkOutDate)
                .bookingConfirmationCode(bookingConfirmationCode)
                .build();
    }

}
