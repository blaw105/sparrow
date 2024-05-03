package com.sparrow;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Renderer r = new Renderer("main.md");

        try {
            r.renderTo("main.html");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
