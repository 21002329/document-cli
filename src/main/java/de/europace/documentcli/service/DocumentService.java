package de.europace.documentcli.service;

import com.fasterxml.jackson.core.type.TypeReference;
import de.europace.documentcli.client.DocumentWebClient;
import de.europace.documentcli.domain.Document;
import de.europace.documentcli.util.SerDes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {

  private final DocumentWebClient documentWebClient;

  /**
   * Returns list of all documents, sorted.
   * This function sorts by document ID by default, and optionally
   * can sort by 'name' or 'size' or 'type' or 'deleted' properties
   *
   * @param sortBy document property to sort by
   * @return list of documents
   */
  public List<Document> getAllDocuments(String sortBy) {
    return sorted(getDocuments(), sortBy);
  }

  /**
   * Returns list of all documents filtered by given category.
   * This function sorts by document ID by default, and optionally
   * can sort by 'name' or 'size' or 'type' or 'deleted' properties
   *
   * @return list of documents
   */
  public List<Document> getDocumentsByCategory(String category, String sortBy) {
    Predicate<Document> documentHasCategory =
        d -> d.getCategories().stream().anyMatch(c -> c.equals(category));

    return sorted(getDocuments().stream()
        .filter(documentHasCategory)
        .collect(Collectors.toList()), sortBy);
  }

  private List<Document> getDocuments() {

    String documentsJson = documentWebClient.getDocuments();

    return SerDes.deserialize(documentsJson, new TypeReference<List<Document>>() {});
  }

  private List<Document> sorted(List<Document> documents, String sortBy) {
    String sortBy_ = sortBy.toLowerCase();
    Comparator<Document> comparator;
    switch (sortBy_) {
      case "name":
        comparator = Comparator.comparing(Document::getName);
        break;
      case "size":
        comparator = Comparator.comparing(Document::getSize);
        break;
      case "type":
        comparator = Comparator.comparing(Document::getType);
        break;
      case "deleted":
        comparator = Comparator.comparing(Document::getDeleted);
        break;
      default:
        comparator = Comparator.comparing(d -> Integer.parseInt(d.getId()));
        break;
    }
    return documents.stream()
        .sorted(comparator)
        .collect(Collectors.toList());

  }

}
