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
        if (texte == null) {
            throw new IllegalArgumentException("La coordonnée ne peut pas être nulle");
        }

        String[] parties = texte.split(":", -1);

        if (parties.length != 3
                || parties[0].isEmpty()
                || parties[1].isEmpty()
                || parties[2].isEmpty()) {
            throw new IllegalArgumentException("Coordonnée invalide : " + texte);
        }

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