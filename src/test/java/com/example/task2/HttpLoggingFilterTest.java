package com.example.task2;


import com.example.task2.filter.HttpLoggingFilter;
import com.example.task2.model.HttpLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class HttpLoggingFilterTest {

    private HttpLoggingFilter filter;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain chain;

    @Captor
    private ArgumentCaptor<HttpLog> logCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        filter = new HttpLoggingFilter();
    }

    @Test
    public void testDoFilterLogsHttpGetRequest() throws IOException, ServletException {
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestURI()).thenReturn("/test");
        when(response.getStatus()).thenReturn(200);
        when(request.getHeaderNames()).thenReturn(Collections.emptyEnumeration());
        when(response.getHeaderNames()).thenReturn(Collections.emptySet());

        filter.doFilter(request, response, chain);

        verify(chain).doFilter(request, response);

        verify(request).getMethod();
        verify(request).getRequestURI();
        verify(response).getStatus();
        verify(request).getHeaderNames();
        verify(response).getHeaderNames();

        verify(request, never()).getHeader("Content-Length");

    }

    @Test
    public void testDoFilterLogsHttpPostRequest() throws IOException, ServletException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getRequestURI()).thenReturn("/api/post");
        when(response.getStatus()).thenReturn(201);

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");

        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Location", "/api/post/123");

        when(request.getHeaderNames()).thenReturn(Collections.enumeration(requestHeaders.keySet()));
        when(request.getHeader("Content-Type")).thenReturn("application/json");
        when(response.getHeaderNames()).thenReturn(responseHeaders.keySet());
        when(response.getHeader("Location")).thenReturn("/api/post/123");

        filter.doFilter(request, response, chain);

        verify(chain).doFilter(request, response);

        verify(request).getMethod();
        verify(request).getRequestURI();
        verify(response).getStatus();
        verify(request).getHeaderNames();
        verify(response).getHeaderNames();
        verify(request).getHeader("Content-Type");
        verify(response).getHeader("Location");

    }

    @Test
    public void testDoFilterLogsHttpPutRequest() throws IOException, ServletException {
        when(request.getMethod()).thenReturn("PUT");
        when(request.getRequestURI()).thenReturn("/api/resource/123");
        when(response.getStatus()).thenReturn(204);

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/xml");

        when(request.getHeaderNames()).thenReturn(Collections.enumeration(requestHeaders.keySet()));
        when(request.getHeader("Content-Type")).thenReturn("application/xml");
        when(response.getHeaderNames()).thenReturn(Collections.emptySet());

        filter.doFilter(request, response, chain);

        verify(chain).doFilter(request, response);

        verify(request).getMethod();
        verify(request).getRequestURI();
        verify(response).getStatus();
        verify(request).getHeaderNames();
        verify(response).getHeaderNames();
        verify(request).getHeader("Content-Type");
    }

    @Test
    public void testDoFilterLogsHttpDeleteRequest() throws IOException, ServletException {
        when(request.getMethod()).thenReturn("DELETE");
        when(request.getRequestURI()).thenReturn("/api/resource/456");
        when(response.getStatus()).thenReturn(204);
        when(request.getHeaderNames()).thenReturn(Collections.emptyEnumeration());
        when(response.getHeaderNames()).thenReturn(Collections.emptySet());

        filter.doFilter(request, response, chain);

        verify(chain).doFilter(request, response);

        verify(request).getMethod();
        verify(request).getRequestURI();
        verify(response).getStatus();
        verify(request).getHeaderNames();
        verify(response).getHeaderNames();

    }

}
