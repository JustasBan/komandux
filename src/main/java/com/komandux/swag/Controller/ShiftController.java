package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
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

    @ApiOperation(value = "Get list of Shifts in the System ", response = Iterable.class, tags = "getShifts")
    @RequestMapping(value = "/getShifts")
    public List<Shift> getShifts() {
        return shifts;
    }

    @ApiOperation(value = "Get specific Shift in the System ", response = Shift.class, tags = "getShiftById")
    @RequestMapping(value = "/getShiftById/{shiftId}")
    public Shift getShiftById(@PathVariable(value = "shiftId") int shiftId) {
        return shifts.stream().filter(x -> x.getShiftId() == (shiftId)).collect(Collectors.toList()).get(0);
    }
}