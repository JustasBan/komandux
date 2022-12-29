package com.komandux.swag.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komandux.swag.Model.Tip;
import com.komandux.swag.Model.TipType;

import io.swagger.annotations.ApiOperation;

@RestController
public class TipController {
    Date date = new Date();
    List<Tip> tips = new ArrayList<Tip>();
    {
        tips.add(new Tip(1, "Giver1", TipType.FlatSum, date, 3));
        tips.add(new Tip(2, "Giver2", TipType.Percentage, date, 3));
        tips.add(new Tip(3, "Giver3", TipType.FlatSum, date, 4));
        tips.add(new Tip(4, "Giver4", TipType.Percentage, date, 4));
    }

    @ApiOperation(value = "Create Tip", response = Tip.class, tags = "Tip")
    @PostMapping(value = "/createTip/{giver, tipType, givenDate, receiverId}")
    public Tip createTip(String giver, TipType tipType, Date givenDate, int receiverId) {
        tips.add(new Tip(tips.get(tips.size() - 1).getTipId() + 1, giver, tipType, givenDate, receiverId));
        return tips.get(tips.size() - 1);
    }

    @ApiOperation(value = "Get list of Tips", response = Iterable.class, tags = "Tip")
    @GetMapping(value = "/getTips")
    public List<Tip> getTips() {
        return tips;
    }

    @ApiOperation(value = "Get Tip by Id", response = Tip.class, tags = "Tip")
    @GetMapping(value = "/getTipById/{tipId}")
    public Tip getTipById(@PathVariable(value = "tipId") int tipId) {
        return tips.stream().filter(x -> x.getTipId() == (tipId)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Delete Tip by Id", response = Tip.class, tags = "Tip")
    @DeleteMapping(value = "/deleteTipById/{tipId}")
    public ResponseEntity<?> deleteTip(int tipId) {
        for (int i = 0; i < tips.size(); i++) {
            if (tips.get(i).getTipId() == (tipId)) {
                tips.remove(i);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
