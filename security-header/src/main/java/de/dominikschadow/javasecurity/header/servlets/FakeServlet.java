/*
 * Copyright (C) 2021 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Java Security project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.javasecurity.header.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

/**
 * Fake login servlet which returns a success message.
 *
 * @author Dominik Schadow
 */
@WebServlet(name = "FakeServlet", urlPatterns = {"/x-frame-options/FakeServlet", "/csp2/FakeServlet"})
public class FakeServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6474742244481023685L;
    private static final System.Logger LOG = System.getLogger(FakeServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        LOG.log(System.Logger.Level.INFO, "Processing fake request...");

        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/styles.css\" />");
            out.println("<title>Security Response Header</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fake login successful</h1>");
            out.println("<div><a href=\"../index.jsp\">Home</a></div>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            LOG.log(System.Logger.Level.ERROR, ex.getMessage(), ex);
        }
    }
}
