package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Shift;
import io.swagger.annotations.ApiOperation;

@RestController
public class ShiftController {
    Date date = new Date();
    List<Shift> shifts = new ArrayList<Shift>();
    {
        shifts.add(new Shift(1, 1, date, date));
        shifts.add(new Shift(2, 2, date, date));
        shifts.add(new Shift(3, 3, date, date));
        shifts.add(new Shift(4, 4, date, date));
    }

    @ApiOperation(value = "Create Shift", response = Shift.class, tags = "Shift")
    @PostMapping(value = "/createShift/{employeeId, startTime, endTime}")
    public Shift createShift(int employeeId, Date startTime, Date endTime) {
        shifts.add(new Shift(shifts.get(shifts.size() - 1).getShiftId() + 1, employeeId, startTime, endTime));
        return shifts.get(shifts.size() - 1);
    }

    @ApiOperation(value = "Get list of Shifts", response = Iterable.class, tags = "Shift")
    @RequestMapping(value = "/getShifts")
    public List<Shift> getShifts() {
        return shifts;
    }

    @ApiOperation(value = "Get Shift by Id", response = Shift.class, tags = "Shift")
    @RequestMapping(value = "/getShiftById/{shiftId}")
    public Shift getShiftById(@PathVariable(value = "shiftId") int shiftId) {
        return shifts.stream().filter(x -> x.getShiftId() == (shiftId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Change Shift information", response = Shift.class, tags = "Shift")
    @PutMapping(value = "/changeShift{shiftId, employeeId, password, hourlyPayRate, position}}")
    public ResponseEntity<?> changeShift(int shiftId, int employeeId, Date startTime, Date endTime) {
        for (int i = 0; i < shifts.size(); i++) {
            Shift shift = shifts.get(i);
            if (shift.getShiftId() == shiftId) {
                shifts.set(i, new Shift(shift.getShiftId(), employeeId, startTime, endTime));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}