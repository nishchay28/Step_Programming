class ArtPiece {
    String title;

    public ArtPiece(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Displaying: " + title);
    }
}

class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    public void showBrushTechnique() {
        System.out.println(title + ": Brush technique shown");
    }
}

class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    public void showMaterial() {
        System.out.println(title + ": Material composition shown");
    }
}

class DigitalArt extends ArtPiece {
    public DigitalArt(String title) {
        super(title);
    }

    public void showResolution() {
        System.out.println(title + ": Resolution displayed");
    }
}

class Photography extends ArtPiece {
    public Photography(String title) {
        super(title);
    }

    public void showCameraSettings() {
        System.out.println(title + ": Camera settings shown");
    }
}

public class HW5_DigitalArtGallery {
    public static void main(String[] args) {
        ArtPiece a = new Painting("Starry Night");
        a.display();
        ((Painting) a).showBrushTechnique();
    }
}
