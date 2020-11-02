package org.gradle.examples.web;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;


public class ServletTest {

    @Mock
    public HttpServletRequest request;
    @Mock
    public HttpServletResponse response;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testHelloUrl() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        new Servlet().doGet(request, response);
        assertEquals("hello, world\n", stringWriter.toString());
    }

}
