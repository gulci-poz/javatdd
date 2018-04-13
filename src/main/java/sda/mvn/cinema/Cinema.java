package sda.mvn.cinema;

import sda.mvn.cinema.model.*;

public class Cinema {

    private final CinemaBookingService cinemaBookingService;
    private final CinemaNotifier cinemaNotifier;

    public Cinema(CinemaBookingService cinemaBookingService, CinemaNotifier cinemaNotifier) {
        this.cinemaBookingService = cinemaBookingService;
        this.cinemaNotifier = cinemaNotifier;
    }

    public CinemaBookingResponse bookMovie(CinemaMovie cinemaMovie, int seatingNumber, CinemaUser cinemaUser, CinemaChannel cinemaChannel) {

        CinemaBookingStatus status = cinemaBookingService.bookSeating(cinemaMovie, seatingNumber);

        if (!status.isStatus()) {
            CinemaBookingResponse failureResponse = new CinemaBookingResponse();
            failureResponse.setStatus(false);

            switch (status.getStatusCode()) {
                case INVALID_SEATING_TYPE:
                    failureResponse.setMessage("Invalid seating type");
                    break;
                case WRONG_SEATING_ID:
                    failureResponse.setMessage("Wrong seating number");
                    break;
                case SEATING_ALREADY_BOOKED:
                    failureResponse.setMessage("Seating already booked");
                    break;
            }

            return failureResponse;
        }

        CinemaNotifierResponse response = cinemaNotifier.notify(cinemaUser, cinemaChannel, "ticket_number");
        if (!response.isStatus()) {
            CinemaBookingResponse cinemaBookingResponse = new CinemaBookingResponse();
            cinemaBookingResponse.setStatus(false);

            switch (response.getStatusCode()) {
                case SERVER_ERROR:
                    cinemaBookingResponse.setMessage("ticket cannot be sent");
                    break;
                case CHANNEL_NOT_SPECIFIED:
                    cinemaBookingResponse.setMessage("no address data");
                    break;
            }

            return cinemaBookingResponse;
        }

        return new CinemaBookingResponse(true, "Seating succesfully booked");
    }
}
