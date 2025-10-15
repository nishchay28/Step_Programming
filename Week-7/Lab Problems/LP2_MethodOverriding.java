class Post {
    String author, content;
    String time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println("Post by " + author + ": " + content + " at " + time);
    }
}

class Instagram extends Post {
    int likes;

    public Instagram(String author, String content, String time, int likes) {
        super(author, content, time);
        this.likes = likes;
    }

    @Override
    public void display() {
        System.out.println("Instagram: " + content + " ❤️ " + likes + " by " + author);
    }
}

class Twitter extends Post {
    int retweets;

    public Twitter(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("Twitter: " + content + " 🔁 " + retweets + " by " + author);
    }
}

class LinkedIn extends Post {
    int connections;

    public LinkedIn(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("LinkedIn: " + content + " 👥 " + connections + " connections");
    }
}

public class LP2_MethodOverriding {
    public static void main(String[] args) {
        Post[] posts = {
            new Instagram("Alice", "Sunset pic", "5pm", 120),
            new Twitter("Bob", "Java tips", "6pm", 45),
            new LinkedIn("Carol", "Job update", "7pm", 300)
        };

        for (Post p : posts) {
            p.display();
        }
    }
}
