package com.greenfox.trialexam.controllers;

import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.models.UrlModelDTO;
import com.greenfox.trialexam.services.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    private final UrlService urlService;

    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }


//    @GetMapping({"/", ""})
//    public String displayMainPage() {
//
//        return "index";
//    }

    @GetMapping("/")
    public String mainForm(Model model){
        if (model.getAttribute("link") == null) {
            model.addAttribute("link", new UrlModel());
        }
        return "index1";
    }


//    @PostMapping("/save-link")
//    public String saveLink(@ModelAttribute UrlModel urlModel, RedirectAttributes attributes){
//        Boolean aliasPresent = urlService.checkAlias(urlModel.getAlias());
//        if (aliasPresent) {
//            attributes.addFlashAttribute("aliastaken", true);
//        } else {
//            urlService.createAlias(urlModel);
//            attributes.addFlashAttribute("alias", urlModel.getAlias());
//            attributes.addFlashAttribute("secretcode", urlModel.getSecretCode());
//
//        }
//        return "redirect:/";
//    }

    @PostMapping("/save-link")
    public String createNewLink(@ModelAttribute UrlModel urlModel, RedirectAttributes attributes){
        try {
            urlService.save(urlModel);
            attributes.addFlashAttribute("message", "Your URL is aliased to " + urlModel.getAlias() + " and your secret code is " + urlModel.getSecretCode());
        } catch (Exception ex){
            attributes.addFlashAttribute("error", "Your alias is already in use");
            attributes.addFlashAttribute("link", urlModel);
        }
        return "redirect:/";
    }

//    @GetMapping("/a/{alias}")
//    public ModelAndView showAlias(@PathVariable("alias") String alias, HttpServletRequest request){
//        Boolean aliasPresent = urlService.checkAlias(alias);
//        if (!aliasPresent) {
//            return new ModelAndView("redirect:" + urlService.isAliasPresent(alias));
//        }
//        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.NOT_FOUND);
//        return new ModelAndView("404", HttpStatus.NOT_FOUND);
//    }

    @GetMapping("/a/{alias}")
    public String getAlias(@PathVariable String alias){
        return "redirect:" + urlService.getUrl(alias);
    }

    @GetMapping("/api/links")
    @ResponseBody
    public ResponseEntity<List<UrlModel>> getLinks(){
        return ResponseEntity.ok(urlService.getLinks());
    }

    @DeleteMapping("/api/links/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteLink(@PathVariable long id, @RequestBody UrlModelDTO urlModelDTO) {
        urlService.deleteLink(id, urlModelDTO);
        //return ResponseEntity.noContent().build(); //204
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
