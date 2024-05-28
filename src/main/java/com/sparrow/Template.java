package com.sparrow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents a base template for HTML output
 */
public class Template {

    /**
     * Inserts HTML content into the file
     *
     * @param str The HTML content
     *
     * @return The final content
     */
    public static String insert(String str) {

        String res = "";

        res += """
<!DOCTYPE html>
<html>
<head>
<style>
        """;

        String cssPath = (
            "static/" + (new SettingManager(Paths.get("mode.txt"))).getMode() + ".css"
        );

        try {
            res += new String(Files.readAllBytes(Paths.get(cssPath)), StandardCharsets.UTF_8);
        } catch (IOException e) {}

        res += """
</style>
</head>
<body>
        """;

        res += "<ul>" + "\n";

        for (JournalEntry x : EntryCollection.getEntries()) {
            String url = x.getTitle();
            res += "<li>";
            res += "<a href=" + "\"" + "./" + url + ".html" + "\"" + ">";
            res += url + " - " + x.getEntryDate();
            res += "</a>";
            res += "</li>" + "\n";
        }

        res += "</ul>" + "\n";

        res += str;

        res += """
</body>
</html>
        """;

        return res;

    }

}
