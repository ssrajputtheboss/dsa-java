package main.designs.common;

public record User(String name, String profileURL, String uid) {
    @Override
    public int hashCode() {
        return uid.hashCode();
    }
}
