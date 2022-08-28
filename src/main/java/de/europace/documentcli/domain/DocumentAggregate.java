package de.europace.documentcli.domain;

import lombok.Data;

@Data
public class DocumentAggregate {

  private Long totalNumber;
  private Long totalNumberDeleted;
  private Long totalSize;
  private Double avgSize;

}
