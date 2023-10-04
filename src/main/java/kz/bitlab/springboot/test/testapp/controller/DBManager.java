package kz.bitlab.springboot.test.testapp.controller;

import kz.bitlab.springboot.test.testapp.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics = new ArrayList<>();
    private static Long id = 6L;

    static {
        musics.add(new Music(1L,"Music 1","Singer 1",188));
        musics.add(new Music(2L,"Music 2","Singer 2",168));
        musics.add(new Music(3L,"Music 3","Singer 3",178));
        musics.add(new Music(4L,"Music 4","Singer 4",198));
        musics.add(new Music(5L,"Music 5","Singer 5",288));
    }

    public static ArrayList<Music> getMusics(){
        return musics;
    }

    public static void addMusic(Music music){
        music.setId(id);
        id++;
         musics.add(music);

    }

    public static Music getMusic(Long id){
        return musics.stream().filter(music -> music.getId() == id).findFirst().orElse(null);
    }

    public static void updateMusic(Music updatingMusic){
       for (int i=0;i<musics.size();i++){
           if(musics.get(i).getId() == updatingMusic.getId()){
               musics.set(i,updatingMusic);
               break;
           }
       }
    }
}
