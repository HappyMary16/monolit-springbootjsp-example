package org.example.controller;

import org.example.model.Cat;
import org.example.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public String viewCats(Model model) {
        model.addAttribute("cats", catService.getAllCats());
        return "view-cats";
    }

    @GetMapping("/add-view")
    public String addCatView(Model model) {
        model.addAttribute("cat", new Cat());
        return "add-cat";
    }

    @PostMapping
    public RedirectView addCat(@ModelAttribute("cat") Cat cat, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/cats/add-view", true);
        Cat savedCat = catService.addCat(cat);
        redirectAttributes.addFlashAttribute("savedCat", savedCat);
        redirectAttributes.addFlashAttribute("addCatSuccess", true);
        return redirectView;
    }

    @GetMapping("/search-view")
    public String searchCatView(Model model) {
        model.addAttribute("cat", new Cat());
        return "search-cat";
    }

    @GetMapping("/search")
    public RedirectView addCatView(@ModelAttribute("cat") Cat cat, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/cats/search-view", true);
        Cat foundCat = catService.getCat(cat.getName());
        redirectAttributes.addFlashAttribute("foundCat", foundCat);
        redirectAttributes.addFlashAttribute("catFound", true);
        return redirectView;
    }
}
