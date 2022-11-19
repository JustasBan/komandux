package com.komandux.swag.Controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.komandux.swag.Model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(name="Reservation")

public class ReservationController {

    public List<Reservation> reservations = new ArrayList<>();

    {
        reservations.add(new Reservation(0,new Date(),new Date(),new Date(),"notes", PremiseType.HotelRoom,"location"));
        reservations.add(new Reservation(1,new Date(),new Date(),new Date(),"notes", PremiseType.RestaurantTable,"location"));
        reservations.add(new Reservation(2,new Date(),new Date(),new Date(),"notes", PremiseType.Other,"location"));
    }

    @ApiOperation(value = "Create new reservation", tags="Reservation")
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservation) {

        List<Integer> listIds = reservations.stream().map(Reservation::getReservationId).toList();
        int newId= listIds.stream().max(Integer::compareTo).get() + 1;

        reservations.add(new Reservation(newId,new Date(),new Date(),new Date(),reservation.getReservationNotes(),reservation.getPremiseType(),reservation.getLocation()));

        return reservations.get(reservations.size()-1);
    }

    @ApiOperation(value = "delete reservation by ID", tags="Reservation")
    @RequestMapping(value = "/ReservationDeleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReservationById(@PathVariable("id") int id) {

        int index=-1;

        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(i).getReservationId()==id) {
                index=i;
            }
        }

        if(index>-1) {
            reservations.remove(index);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "update  reservation by ID", tags="Reservation")
    @RequestMapping(value = "/ReservationUpdateById/{id}", method = RequestMethod.PUT)
    public Reservation updateReservationById(@PathVariable("id") int id, @RequestBody Reservation reservation) {

        int index=0;

        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(i).getReservationId()==id) {
                index=i;
                reservations.set(i, new Reservation(id,reservation.getCreatedDate(),reservation.getReservationDate(),reservation.getDuration(),reservation.getReservationNotes(),reservation.getPremiseType(),reservation.getLocation()));
            }
        }

        return reservations.get(index);
    }

    @ApiOperation(value = "View all reservations", tags="Reservation")
    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<Reservation> viewReservations() {
        return reservations;
    }

    @ApiOperation(value = "View one reservation", tags="Reservation")
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> viewReservation(@PathVariable("id") int id) {
        for(int i=0; i<reservations.size(); i++) {
            if(reservations.get(i).getReservationId() == (id)) {
                reservations.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
