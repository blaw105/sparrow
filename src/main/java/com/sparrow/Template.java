package com.sparrow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Template {

    public static String insert(String str) {

        String res = "";

        res += """
<!DOCTYPE html>
<html>
<head>
<style>
        """;

        try {
            res += new String(
                Files.readAllBytes(Paths.get("static/dark.css")), StandardCharsets.UTF_8
            );
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
            res += url;
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
