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

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.komandux.swag.Model.AccesToObjects;
import com.komandux.swag.Model.Permisions;
import com.komandux.swag.Model.Position;
import io.swagger.annotations.ApiOperation;

@RestController
public class PositionController {
    List<Position> positions = new ArrayList<Position>();
    {
        positions.add(new Position(1, "Position1", "Description about Position1", Permisions.Nzn,
                AccesToObjects.AccessToSensitiveInformation));
        positions.add(
                new Position(2, "Position2", "Description about Position2", Permisions.Nzn, AccesToObjects.ReadAccess));
        positions.add(new Position(3, "Position3", "Description about Position3", Permisions.Nzn,
                AccesToObjects.WriteAccess));
    }

    @ApiOperation(value = "Get list of Positions in the System ", response = Iterable.class, tags = "getPositions")
    @RequestMapping(value = "/getPositions")
    public List<Position> getPositions() {
        return positions;
    }

    @ApiOperation(value = "Get specific Position in the System ", response = Position.class, tags = "getPositionById")
    @RequestMapping(value = "/getPositionById/{positionId}")
    public Position getPositionById(@PathVariable(value = "positionId") int positionId) {
        return positions.stream().filter(x -> x.getPositionId() == (positionId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Position in the System ", response = Position.class, tags = "getPositionByTitle")
    @RequestMapping(value = "/getPositionByTitle/{title}")
    public Position getPositionByTitle(@PathVariable(value = "title") String title) {
        return positions.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList()).get(0);
    }
}
