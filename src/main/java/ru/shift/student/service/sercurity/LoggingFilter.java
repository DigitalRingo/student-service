package ru.shift.student.service.sercurity;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
        long startTime = System.currentTimeMillis();
        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            String method = wrappedRequest.getMethod();
            String uri = wrappedRequest.getRequestURI();
            String queryString = wrappedRequest.getQueryString();
            String fullUrl = queryString == null ? uri : uri + "?" + queryString;
            String requestBody = getRequestBody(wrappedRequest);
            if (requestBody.isBlank()) {
                log.info("Incoming request: {} {}", method, fullUrl);
            } else {
                log.info("Incoming request: {} {} request body: {}", method, fullUrl, requestBody);
            }

            long duration = System.currentTimeMillis() - startTime;
            String responseBody = getResponseBody(wrappedResponse);
                wrappedResponse.copyBodyToResponse();
            if (responseBody.isBlank()) {
                log.info(
                        "Completed request: {} {} ({} ms, status={})",
                        method,
                        uri,
                        duration,
                        response.getStatus()
                );
            } else {
                log.info(
                        "Completed request: {} {} ({} ms, status={}) response body: {}",
                        method,
                        uri,
                        duration,
                        response.getStatus(),
                        responseBody
                );
            }
        }
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        byte[] buf = request.getContentAsByteArray();
        return (buf.length > 0) ? new String(buf, StandardCharsets.UTF_8) : "";
    }

    private String getResponseBody(ContentCachingResponseWrapper response) {
        byte[] buf = response.getContentAsByteArray();
        return (buf.length > 0) ? new String(buf, StandardCharsets.UTF_8) : "";
    }
}