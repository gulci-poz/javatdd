package sda.mvn.service;

public class WriterService {

    public String write(String name) {
        return name != null ? "Hello, " + name + "!" : "Hello, my friend!";
    }
}
