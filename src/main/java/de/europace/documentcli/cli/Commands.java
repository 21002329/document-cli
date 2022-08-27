package de.europace.documentcli.cli;

import de.europace.documentcli.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
@Slf4j
public class Commands {

  private final DocumentService documentService;

  @ShellMethod(value = "Show list of available documents")
  public String show() {
    return documentService.getDocuments().toString();
  }
}
