package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Renderer {

    private Path inputPath = null;
    private Path outputPath = null;

    public Renderer(String fileIn, String fileOut) {

        inputPath = Paths.get("input/" + fileIn + ".md");
        outputPath = Paths.get("output/" + fileOut + ".html");

    }

    public void renderTo() throws IOException {

        Files.write(outputPath, render().getBytes());

    }

    private String render() throws IOException {

        String content = new String(Files.readAllBytes(inputPath));

        return renderText(content);

    }

    private String renderText(String text) {

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Node doc = parser.parse(text);

        return renderer.render(doc);

    }

}
