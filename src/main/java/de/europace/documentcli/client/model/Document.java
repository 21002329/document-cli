package de.europace.documentcli.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Document {
  String id;
  String name;
  int size;
  String type;
  List<String> categories;
  boolean deleted;
  String createdAt;
  String modifiedAt;
}
