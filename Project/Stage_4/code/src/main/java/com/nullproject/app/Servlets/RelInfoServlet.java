package com.nullproject.app.Servlets;

import com.google.gson.JsonObject;
import com.nullproject.app.Entries.*;
import com.nullproject.app.hibernate.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "relInfoServlet", value = "/rel-info-servlet")
public class RelInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();
        JsonObject object = new JsonObject();
        int id = Integer.parseInt(req.getParameter("bodyID").replace("\"",""));
        try{
            //надо было бы конечно через references сделать
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM death_data where body_id =?", DeathData.class);
            query.setParameter(1, id);
            DeathData death_data = (DeathData) query.getSingleResult();
            transaction.commit();
            object.addProperty("dateOfDeath", death_data.getDateOfDeath().toString());
            object.addProperty("descriptionDocument", death_data.getDescriptionDocumentId());

            transaction.begin();
            query = session.createNativeQuery("SELECT * FROM params where body_id =?", Params.class);
            query.setParameter(1, id);
            Params params = (Params) query.getSingleResult();
            transaction.commit();
            object.addProperty("sex", params.getSex());
            object.addProperty("height", params.getHeight());
            object.addProperty("weight", params.getWeight());

            transaction.begin();
            query = session.createNativeQuery("SELECT * FROM personal_data where id =?", PersonalData.class);
            query.setParameter(1, id);
            PersonalData personalData = (PersonalData) query.getSingleResult();
            transaction.commit();
            object.addProperty("name", personalData.getName());
            object.addProperty("secondName", personalData.getSecondName());
            object.addProperty("phoneNumber", personalData.getPhoneNumber());
            object.addProperty("passportId", personalData.getPassportId());


            transaction.begin();
            query = session.createNativeQuery("SELECT * FROM procedures where body_id =?", Procedure.class);
            query.setParameter(1, id);
            Procedure procedure = (Procedure) query.getSingleResult();
            transaction.commit();
            object.addProperty("note", procedure.getNote());
            object.addProperty("pathologist1Id", procedure.getPathologist1Id());
            object.addProperty("pathologist2Id", procedure.getPathologist2Id());
            object.addProperty("internId", procedure.getInternId());
            resp.getWriter().println(object);

        }catch (RuntimeException e){
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            resp.sendError(500);
        }catch (Exception e){
            resp.sendError(500);
            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
            PrintStream printStream;
            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            printStream.println(e);
            throw e;
        }
    }
}
