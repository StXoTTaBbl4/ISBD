package com.nullproject.app.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nullproject.app.Entries.FuneralServicesAccData;
import com.nullproject.app.hibernate.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        HibernateUtil hibernateUtil = new HibernateUtil();
//        hibernateUtil.connection();
//        Session session = hibernateUtil.session();
//        Transaction transaction = hibernateUtil.transaction();

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }

        JsonObject data = JsonParser.parseString(buffer.toString()).getAsJsonObject();
        System.out.println(data);

        response.getWriter().println("response");


//        try {
//            transaction.begin();
//            Query query = session.createQuery( "FROM FuneralServicesAccData where login = ", FuneralServicesAccData.class);
//            List<FuneralServicesAccData> entries = query.getResultList();
//            transaction.commit();
//            //System.out.println("Reading student records..." + "Length of elements: " + entries.size() + " Hit 1 elem: " + entries.get(0).getHitResult());
//        } catch (RuntimeException exception) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw exception;
//        }catch (Exception e){
//            PrintStream printStream;
//            try {
//                printStream = new PrintStream(System.out, true, "UTF-8");
//            } catch (UnsupportedEncodingException ex) {
//                throw new RuntimeException(ex);
//            }
//            printStream.println(e);
//            throw e;
//        }
    }

}
