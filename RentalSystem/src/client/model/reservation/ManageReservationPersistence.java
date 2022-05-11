package client.model.reservation;

import shared.objects.reservation.Reservation;
import shared.objects.reservation.ReservationList;

import java.sql.SQLException;

public interface ManageReservationPersistence
{
    ReservationList load() throws SQLException;
    void save(ReservationList reservationList) throws SQLException;
    void save(Reservation reservation) throws SQLException;
    void change(Reservation reservation) throws SQLException;
    void remove(Reservation reservation) throws SQLException;
    void clear();
}