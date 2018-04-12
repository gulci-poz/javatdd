package sda.mvn.cinema;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import sda.mvn.cinema.model.CinemaBookingResponse;
import sda.mvn.cinema.model.CinemaBookingStatus;
import sda.mvn.cinema.model.CinemaBookingStatusCode;

public class CinemaTest {

    @Test
    public void userCanReserveMovieAndReceiveNotificationWithTicket() {
        // given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

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

    //@Test
    //public void selectedChannelIsCorrect() {
    //
    //}
}
