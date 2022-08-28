package de.europace.documentcli.util;


import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import de.europace.documentcli.domain.Document;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class SerDesTest {

  @Test
  public void shouldDeserialize() throws Exception {
    List<Document> documents = SerDes.deserialize(
        getResource("/valid_response.json"), new TypeReference<>() {
        });
    assertThat(documents).size().isEqualTo(10);
  }

 @Test
  public void shouldNotDeserialize() throws Exception {
    List<Document> documents = SerDes.deserialize(
        getResource("/corrupt_response.json"), new TypeReference<>() {});
    assertThat(documents).size().isEqualTo(0);
  }

  private String getResource(String path) throws Exception {
    return IOUtils.toString(
        Objects.requireNonNull(
            this.getClass().getResourceAsStream(path)), StandardCharsets.UTF_8);
  }
}
