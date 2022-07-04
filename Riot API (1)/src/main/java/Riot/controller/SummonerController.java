package Riot.controller;

import Riot.domain.NameForm;
import Riot.domain.SummonerDto;
import Riot.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class SummonerController {
    private final SummonerService summonerService;

    @GetMapping("/search")
    public String home(Model model, HttpServletRequest httpServletRequest){
        String name=httpServletRequest.getParameter("name");
        SummonerDto summonerDto= summonerService.searchSummoner(name);
        model.addAttribute("summonerDto",summonerDto);
        return "result";
    }
}
