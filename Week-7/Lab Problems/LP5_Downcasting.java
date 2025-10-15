class Content {
    String title;

    public Content(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing: " + title);
    }
}

class Movie extends Content {
    public Movie(String title) {
        super(title);
    }

    public void showRating() {
        System.out.println(title + " rated PG-13");
    }
}

class Series extends Content {
    public Series(String title) {
        super(title);
    }

    public void nextEpisode() {
        System.out.println("Next episode of " + title + " queued");
    }
}

class Documentary extends Content {
    public Documentary(String title) {
        super(title);
    }

    public void showTags() {
        System.out.println(title + " tagged as Educational");
    }
}

public class LP5_Downcasting {
    public static void main(String[] args) {
        Content c1 = new Movie("Inception");
        Content c2 = new Series("Stranger Things");
        Content c3 = new Documentary("Planet Earth");

        ((Movie) c1).showRating();
        ((Series) c2).nextEpisode();
        ((Documentary) c3).showTags();
    }
}
