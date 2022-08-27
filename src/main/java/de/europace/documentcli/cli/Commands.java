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
import java.util.stream.Collectors;

@ShellComponent
@AllArgsConstructor
@Slf4j
public class Commands {

  private final DocumentService documentService;

  @ShellMethod(value = "Show list of available documents")
  public String show() {
    return Writer.writeDocuments(documentService.getDocuments());
  }
}
