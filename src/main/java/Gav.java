public class Gav {
    private final String group;
    private final String artifact;
    private final String version;

    private Gav(String group, String artifact, String version) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    public static Gav parse(String texte) {
        String[] parties = texte.split(":");
        return new Gav(parties[0], parties[1], parties[2]);
    }

    public String group() {
        return group;
    }

    public String artifact() {
        return artifact;
    }

    public String version() {
        return version;
    }
}