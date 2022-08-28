package de.europace.documentcli.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Document {

  private String id;
  private String name;
  private Long size;
  private Type type;
  private List<String> categories;
  private Boolean deleted;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime modifiedAt;

  public enum Type {
    PDF, IMAGE
  }

  public static String headerString() {
    return StringUtils.leftPad("id", 8) + " " +
        StringUtils.rightPad("name", 24) + " " +
        StringUtils.leftPad("size", 12) + " " +
        StringUtils.rightPad("type", 8) + " " +
        StringUtils.rightPad("categories", 24) + " " +
        StringUtils.rightPad("deleted", 8) + " " +
        StringUtils.rightPad("createdAt", 24) + " " +
        StringUtils.rightPad("modifiedAt", 24);
  }

  public String toString() {
    return StringUtils.leftPad(id, 8) + " " +
        StringUtils.rightPad(name, 24) + " " +
        StringUtils.leftPad(Long.toString(size), 12) + " " +
        StringUtils.rightPad(type.name(), 8) + " " +
        StringUtils.rightPad(String.join(",", categories), 24) + " " +
        StringUtils.rightPad(deleted ? "+" : "-", 8) + " " +
        StringUtils.rightPad(createdAt.toString(), 24) + " " +
        StringUtils.rightPad(modifiedAt.toString(), 24);
  }

}
