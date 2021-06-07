package be.ehb.blogg.Controller;

import be.ehb.blogg.model.BlogDao;
import be.ehb.blogg.model.Blogg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class indexController {

    @Autowired
    private BlogDao repo;

    @ModelAttribute("all")
    public Iterable<Blogg>findAll(){
        return repo.findAll();
    }

    @ModelAttribute("new_blog")
    public Blogg createNew(){
        return new Blogg();
    }


    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

    @RequestMapping(value = {"/index","/"}, method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute("new_Blog")@Valid Blogg newBlog, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "index";
        }
        repo.save(newBlog);
        return "redirect:/index";
    }
}
