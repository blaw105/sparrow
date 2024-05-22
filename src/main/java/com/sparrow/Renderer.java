package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Class responsible for rendering the files
 */
public class Renderer {

    private Path inputPath = null;
    private Path outputPath = null;

    /**
     * Construts a new renderer
     *
     * @param fileIn Input file
     * @param fileOut Output file
     */
    public Renderer(String fileIn, String fileOut) {

        inputPath = Paths.get("input/" + fileIn + ".md");
        outputPath = Paths.get("output/" + fileOut + ".html");

    }

    /**
     * Renders file to output location
     *
     * @throws IOException
     */
    public void renderTo() throws IOException {

        Files.write(outputPath, render().getBytes());

    }

    /**
     * Renders file to String
     *
     * @return The rendered string
     *
     * @throws IOException
     */
    private String render() throws IOException {

        String content = new String(Files.readAllBytes(inputPath));

        return Template.insert(renderText(content));

    }

    /**
     * Renders markdown content to HTML
     *
     * @param text The markdown to render
     *
     * @return The rendered string
     *
     */
    private String renderText(String text) {

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Node doc = parser.parse(text);

        return renderer.render(doc);

    }

}
