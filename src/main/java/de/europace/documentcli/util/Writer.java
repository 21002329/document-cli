package de.europace.documentcli.util;

import de.europace.documentcli.domain.Document;
import de.europace.documentcli.domain.DocumentAggregate;

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

  public static String writeDocumentsWithAggregate(
      List<Document> documents, DocumentAggregate aggregate) {
    String out = "# documents: %d, # deleted documents: %d, total size: %d, avg. size: %.2f";

    return writeDocuments(documents) + "\n\n" + String.format(out,
        aggregate.getTotalNumber(),
        aggregate.getTotalNumberDeleted(),
        aggregate.getTotalSize(),
        aggregate.getAvgSize());
  }
}
