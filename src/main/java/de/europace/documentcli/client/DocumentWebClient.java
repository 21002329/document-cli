package de.europace.documentcli.client;

import de.europace.documentcli.client.model.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;
import reactor.core.publisher.Mono;

import javax.print.Doc;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class DocumentWebClient {

    private final WebClient client;

    public DocumentWebClient(ClientConfig clientConfig) {
        log.info("Using document API base URI {}", clientConfig.getDocumentApiBaseUrl());
        client = WebClient.builder()
            .baseUrl(clientConfig.getDocumentApiBaseUrl())
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", clientConfig.getDocumentApiBaseUrl()))
            .build();
    }

    /**
     * Returns the response body retrieved from /documents endpoint.
     *
     * @return response body
     */
    public String getDocuments() {
        return client.get()
            .uri("/documents")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
