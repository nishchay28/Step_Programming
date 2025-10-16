interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    public void play() {
        System.out.println("Music is playing");
    }

    public void pause() {
        System.out.println("Music is paused");
    }
}

class VideoPlayer implements Playable {
    public void play() {
        System.out.println("Video is playing");
    }

    public void pause() {
        System.out.println("Video is paused");
    }
}

public class HW2_PlayableInterface {
    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        p1.play();
        p1.pause();

        Playable p2 = new VideoPlayer();
        p2.play();
        p2.pause();
    }
}
