import java.util.Set;

public record Artifact(Gav gav, Set<Gav> dependencies) {
}