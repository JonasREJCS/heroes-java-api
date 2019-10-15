package com.heroes.heroesapi;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hero")
    public Hero hero(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hero(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/heroes")
    public ArrayList<Hero> heroes(@RequestParam(value="name", defaultValue="World") String name) {
        ArrayList<Hero> listaHeroes = new ArrayList<Hero>();


        listaHeroes.add(new Hero(11, "Bebe Rexha"));
        listaHeroes.add(new Hero(12, "Alok"));
        listaHeroes.add(new Hero(13, "Glória Groove"));
        listaHeroes.add(new Hero(14, "Drake"));
        listaHeroes.add(new Hero(15, "The Black Eyed Peas"));
        listaHeroes.add(new Hero(16, "Lady Gaga"));
        listaHeroes.add(new Hero(17, "Rihanna"));
        listaHeroes.add(new Hero(18, "P!nk"));
        listaHeroes.add(new Hero(19, "Anitta"));
        listaHeroes.add(new Hero(20, "Katy Perry"));
        listaHeroes.add(new Hero(21, "Pablo Vittar"));
        listaHeroes.add(new Hero(22, "Bruno Mars"));
        listaHeroes.add(new Hero(23, "30 Seconds to Mars"));
        
        return listaHeroes;
    }
}