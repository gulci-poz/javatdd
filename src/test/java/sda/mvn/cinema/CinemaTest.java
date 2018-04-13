package sda.mvn.cinema;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import sda.mvn.cinema.model.*;

public class CinemaTest {

    @Test
    public void userCanReserveMovieAndReceiveNotificationWithTicket() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        // when
        CinemaBookingResponse cinemaBookingResponse =
                cinema.bookMovie(null, 15, null, null);

        // then
        Assert.assertEquals("Seating succesfully booked", cinemaBookingResponse.getMessage());
        Assert.assertTrue(cinemaBookingResponse.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.times(1))
                .notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void userCannotReserveMovieBecauseSelectedCityIsInvalid() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.WRONG_SEATING_ID));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        // when
        CinemaBookingResponse cinemaBookingResponse =
                cinema.bookMovie(null, 15, null, null);

        // then
        Assert.assertEquals("Wrong seating number", cinemaBookingResponse.getMessage());
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.times(0))
                .notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void userCannotReserveMovieBecauseSeatingIsAlreadyReserved() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.SEATING_ALREADY_BOOKED));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        // when
        CinemaBookingResponse cinemaBookingResponse =
                cinema.bookMovie(null, 15, null, null);

        // then
        Assert.assertEquals("Seating already booked", cinemaBookingResponse.getMessage());
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.times(0))
                .notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldReturnServerErrorMessage() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.SERVER_ERROR));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        // when
        CinemaBookingResponse cinemaBookingResponse =
                cinema.bookMovie(null, 15, null, null);

        // then
        Assert.assertEquals("ticket cannot be sent", cinemaBookingResponse.getMessage());
        Assert.assertFalse(cinemaBookingResponse.isStatus());

        Mockito.verify(cinemaNotifier, Mockito.times(1))
                .notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldReturnChannelNotSpecifiedMessage() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.CHANNEL_NOT_SPECIFIED));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        // when
        CinemaBookingResponse cinemaBookingResponse =
                cinema.bookMovie(null, 15, null, null);

        // then
        Assert.assertEquals("no address data", cinemaBookingResponse.getMessage());
        Assert.assertFalse(cinemaBookingResponse.isStatus());

        Mockito.verify(cinemaNotifier, Mockito.times(1))
                .notify(Mockito.any(), Mockito.any(), Mockito.any());
    }
}
