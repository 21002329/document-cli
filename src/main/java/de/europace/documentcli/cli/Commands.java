package de.europace.documentcli.cli;

import de.europace.documentcli.domain.Document;
import de.europace.documentcli.service.DocumentService;
import de.europace.documentcli.util.Writer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@AllArgsConstructor
@Slf4j
public class Commands {

  private final DocumentService documentService;

  @ShellMethod(value = "Show list of documents, filtered by category and/or sorted")
  public String show(
      @ShellOption(defaultValue = "", value = { "--category","-c" }) String category,
      @ShellOption(defaultValue = "", value = { "--sortBy","-s" }) String sortBy
  ) {
    List<Document> documents;
    if (!category.isEmpty()) {
      documents = documentService.getDocumentsByCategory(category, sortBy);
    } else {
      documents = documentService.getAllDocuments(sortBy);
    }

    return Writer.writeDocuments(documents);
  }
}
