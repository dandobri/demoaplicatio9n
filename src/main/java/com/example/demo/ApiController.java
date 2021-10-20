package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {

     public List<String> themes;

    {
        themes = new ArrayList<>();
    }

    /*curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'theme'*/
    @PostMapping("themes")
    public void addTheme(@RequestBody String Theme){
        themes.add(Theme);
    }
        /*curl -X DELETE http://localhost:8080/themes/0 -H 'Content-Type: text/plain'*/
    @DeleteMapping("themes/{index}")
public void deleteTheme(@PathVariable("index") Integer index){
        themes.remove((int) index);
    }
    /*curl -X GET http://localhost:8080/themes -H 'Content-Type:text/plain'*/
    @GetMapping("themes")
    public List<String> getThemes() {
        return themes;
    }
    /* curl -X PUT http://localhost:8080/themes/1 -H 'Content-Type: text/plain' -d 'theme' */
    @PutMapping("themes/{index}")
    public void updateTheme(
            @PathVariable("index") Integer i,
            @RequestBody String Theme) {
        themes.remove((int) i);
        themes.add(i, Theme);
    }
    /* curl -X DELETE http://localhost:8080/themes/delete -H 'Content-Type: text/plain'*/
    @DeleteMapping("themes/delete")
    public void deleteTheme(){
        for(int i=themes.size();i>0;i--)
        themes.remove(i);
    }
    /* curl -X GET http://localhost:8080/themes/1 -H 'Content-Type: text/plain' */
    @GetMapping("themes/{index}")
    public String getTheme(@PathVariable("index") Integer index) {
        return themes.get(index);
    }
}

