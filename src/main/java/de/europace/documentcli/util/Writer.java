package de.europace.documentcli.util;

import de.europace.documentcli.domain.Document;

import java.util.List;
import java.util.stream.Collectors;

public class Writer {

  public static String writeDocuments(List<Document> documents) {
    List<String> documentStrings = documents.stream()
        .map(Document::toString)
        .collect(Collectors.toList());

    return Document.headerString() + "\n" +
        String.join("\n", documentStrings);
  }
}
