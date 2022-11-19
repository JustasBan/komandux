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

    @ApiOperation(value = "Get list of Tips in the System ", response = Iterable.class, tags = "getTips")
    @RequestMapping(value = "/getTips")
    public List<Tip> getTips() {
        return tips;
    }

    @ApiOperation(value = "Get specific Tip in the System ", response = Tip.class, tags = "getTipById")
    @RequestMapping(value = "/getTipById/{tipId}")
    public Tip getTipById(@PathVariable(value = "tipId") int tipId) {
        return tips.stream().filter(x -> x.getTipId() == (tipId)).collect(Collectors.toList()).get(0);
    }
}
