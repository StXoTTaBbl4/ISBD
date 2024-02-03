package com.nullproject.app.Servlets;

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
import java.nio.charset.StandardCharsets;
import java.util.List;
@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }
        JsonObject data = JsonParser.parseString(buffer.toString()).getAsJsonObject();
        System.out.println(data);


        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM funeral_services_acc_data where login =? and password=?", FuneralServicesAccData.class);
            query.setParameter(1, data.get("login").toString().replace("\"",""));
            query.setParameter(2, data.get("password").toString().replace("\"",""));

            List<FuneralServicesAccData> entries = query.getResultList();
            transaction.commit();
            for (FuneralServicesAccData f: entries
                 ) {
                System.out.println(f.toString());
            }
            if (entries.isEmpty()){
                response.sendError(404);
            }
            else{
                response.setContentType("text/html");
                response.getWriter().println(entries.get(0).person_id());
            }
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }catch (Exception e){
            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
            PrintStream printStream;
            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            printStream.println(e);
            throw e;
        }
    }
}
