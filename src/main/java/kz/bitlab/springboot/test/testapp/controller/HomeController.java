package kz.bitlab.springboot.test.testapp.controller;

import kz.bitlab.springboot.test.testapp.db.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Music> musics = DBManager.getMusics();
        model.addAttribute("muzikalar", musics);
        return "index";
    }

    @PostMapping(value = "/add-music")
    public String addMusic(Music music) {
        DBManager.addMusic(music);
        return "redirect:/";

    }

    @PostMapping(value = "/add-music-v2")
    public String addMusicV2(
            @RequestParam(name = "music-name") String name,
            @RequestParam(name = "music-author") String author,
            @RequestParam(name = "music-duration") int duration
    ) {

        Music music = new Music();
        music.setName(name);
        music.setAuthor(author);
        music.setDuration(duration);

        DBManager.addMusic(music);

        return "redirect:/";
    }

    @GetMapping(value = "/music-details")
    public String getMusic(@RequestParam(name = "musicId") Long id, Model model) {
        Music music = DBManager.getMusic(id);
        model.addAttribute("music", music);
        return "details";
    }

    @PostMapping(value = "/save-music")
    public String saveMusic(Music music) {
        DBManager.updateMusic(music);
        return "redirect:/";
    }

    @GetMapping(value = "/add-music")
    public String addMusicPage(Model model){
        return "add_music";
    }

    @GetMapping(value = "/details/{musicId}")
    public String musicDetails(@PathVariable(name = "musicId") Long id,Model model){
        Music music = DBManager.getMusic(id);
        model.addAttribute("music", music);
        return "details";
    }

}
