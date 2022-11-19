package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ApiOperation(value = "Create Position", response = Position.class, tags = "Position")
    @PostMapping(value = "/createPosition/{title, description, permisions, accesToObjects}")
    public Position createPosition(String title, String description, Permisions permisions,
            AccesToObjects accesToObjects) {
        positions.add(new Position(positions.get(positions.size() - 1).getPositionId() + 1, title, description,
                permisions, accesToObjects));
        return positions.get(positions.size() - 1);
    }

    @ApiOperation(value = "Get list of Positions", response = Iterable.class, tags = "Position")
    @GetMapping(value = "/getPositions")
    public List<Position> getPositions() {
        return positions;
    }

    @ApiOperation(value = "Get Position by Id", response = Position.class, tags = "Position")
    @GetMapping(value = "/getPositionById/{positionId}")
    public Position getPositionById(@PathVariable(value = "positionId") int positionId) {
        return positions.stream().filter(x -> x.getPositionId() == (positionId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get Position by title", response = Position.class, tags = "Position")
    @GetMapping(value = "/getPositionByTitle/{title}")
    public Position getPositionByTitle(@PathVariable(value = "title") String title) {
        return positions.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Change Position information", response = Position.class, tags = "Position")
    @PutMapping(value = "/changePosition{positionId, title, description, permisions, accesToObjects}}")
    public ResponseEntity<?> changePositionInformation(int positionId, String title, String description,
            Permisions permisions, AccesToObjects accesToObjects) {
        for (int i = 0; i < positions.size(); i++) {
            Position position = positions.get(i);
            if (position.getPositionId() == positionId) {
                positions.set(i, new Position(position.getPositionId(), title, description,
                        permisions, accesToObjects));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Delete Position by Id", response = Position.class, tags = "Position")
    @DeleteMapping(value = "/deletePositionById/{positionId}")
    public ResponseEntity<?> deletePosition(int positionId) {
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i).getPositionId() == (positionId)) {
                positions.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
