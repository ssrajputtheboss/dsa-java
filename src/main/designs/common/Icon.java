package main.designs.common;

public record Icon(String name, String url) {
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
