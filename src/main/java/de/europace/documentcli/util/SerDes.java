package de.europace.documentcli.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.europace.documentcli.client.model.Document;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class SerDes {

  /**
   * Returns de-serialized list of T from JSON string.
   *
   * This method fails silently in case of processing exception
   * and returns empty list.
   *
   * @param json data to be parsed as JSON formatted String
   * @param typeReference Jackson type reference for ObjectMapper
   * @param <T> parametrized type to be used for de-serialization
   * @return de-serialized list
   */
  public static <T> List<T> deserialize(String json, TypeReference<List<T>> typeReference) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, typeReference);
    } catch (JsonProcessingException e) {
      log.warn("Could not deserialize json data", e);
      return Collections.emptyList();
    }
  }
}
