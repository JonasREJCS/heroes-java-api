package com.heroes.heroesapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class HeroController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hero")
    public Hero hero(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Hero(counter.incrementAndGet(), String.format(template, name));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/heroes")
    public ArrayList<Hero> heroes(@RequestParam(value = "name", defaultValue = "World") String name)
            throws IOException {    
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

    private void encodeFileToBase64Binary() throws IOException {
        String filePath = "/home/bigjoe/Downloads/";
        String originalFileName = "INGRESSOTOVELORI17_11.pdf";
        String newFileName = "test.pdf";

        byte[] input_file = Files.readAllBytes(Paths.get(filePath+originalFileName));

        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
        String encodedString =  new String(encodedBytes);
        System.out.println(encodedString);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());

        FileOutputStream fos = new FileOutputStream(filePath+newFileName);
        fos.write(decodedBytes);
        fos.flush();
        fos.close();

    }

    

}