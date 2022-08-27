package de.europace.documentcli.service;

import com.fasterxml.jackson.core.type.TypeReference;
import de.europace.documentcli.client.DocumentWebClient;
import de.europace.documentcli.domain.Document;
import de.europace.documentcli.util.SerDes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {

  private final DocumentWebClient documentWebClient;

  /**
   * Returns list of documents.
   *
   * @return list of documents
   */
  public List<Document> getDocuments() {

    String documentsJson = documentWebClient.getDocuments();

    return SerDes.deserialize(documentsJson, new TypeReference<List<Document>>() {});
  }

}
