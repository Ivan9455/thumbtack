package net.thumbtack.school.hiring.server;

import com.google.gson.Gson;
import net.thumbtack.school.hiring.session.SessionDaoImpl;
import net.thumbtack.school.hiring.vacancy.dao.impl.VacancyDaoImpl;
import net.thumbtack.school.hiring.session.Session;
import net.thumbtack.school.hiring.user.dao.impl.UserDaoImpl;
import net.thumbtack.school.hiring.user.Employee;
import net.thumbtack.school.hiring.user.Employer;
import net.thumbtack.school.hiring.error.ErrorCode;
import net.thumbtack.school.hiring.error.ErrorException;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Server {
    private UserDaoImpl userdao = new UserDaoImpl();
    private VacancyDaoImpl vacancydao = new VacancyDaoImpl();
    private SessionDaoImpl sessiondao = new SessionDaoImpl();
    private String filenameload;
    private String filenamesave;
    private Gson json = new Gson();

    public UserDaoImpl getUserdao() {
        return userdao;
    }

    public String getFilenameload() {
        return filenameload;
    }

    public void setFilenameload(String filenameload) {
        this.filenameload = filenameload;
    }

    public String getFilenamesave() {
        return filenamesave;
    }

    public void setFilenamesave(String filenamesave) {
        this.filenamesave = filenamesave;
    }

    public void startServer(String savedDataFileName) throws ErrorException {
        loadFile(savedDataFileName);
    }

    public void startServer() throws ErrorException {
        loadFile(filenameload);
    }

    public Server(String commandLoad, String filenameload, String filenamesave, String commandSave) throws ErrorException {//для задания парсинга командной строки
        if (!commandLoad.equals("-l")) {
            throw new ErrorException(ErrorCode.SERVER_WRONG_COMMAND_LOAD);
        }
        if (!commandSave.equals("-s")) {
            throw new ErrorException(ErrorCode.SERVER_WRONG_COMMAND_SAVE);
        }
        setFilenameload(filenameload);
        setFilenamesave(filenamesave);
    }

    public Server() {
    }

    public void stopServer(String savedDataFileName) {
        saveFile(savedDataFileName);
    }

    public void stopServer() {//для задания парсинга командной строки
        saveFile(filenamesave);
    }

    public void loadFile(String fileName) throws ErrorException {
        if (fileName != null && !fileName.equals("")) {
            try (FileInputStream ois = new FileInputStream(new File(fileName));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(ois))) {
                Set setO = json.fromJson(reader.readLine(), Set.class);
                for (Object o : setO) {
                    for (Object ob : json.fromJson(o.toString(), Set.class)) {
                        if (json.fromJson(ob.toString(), Employer.class).getAddress() == null) {
                            userdao.insert(json.fromJson(ob.toString(), Employee.class));
                        } else {
                            userdao.insert(json.fromJson(ob.toString(), Employer.class));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile(String fileName) {
        if (fileName != null && !fileName.equals("")) {
            try (FileOutputStream fin = new FileOutputStream(fileName);
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fin))) {
                Set<Object> objects = new LinkedHashSet<>();
                objects.add(userdao.getManyEmployee());
                objects.add(userdao.getManyEmployer());
                bw.write(json.toJson(objects));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String registrationEmployer(String requestJsonString) throws ErrorException {
        Employer employer = json.fromJson(requestJsonString, Employer.class);
        if (!userdao.getManyEmployer().contains(employer)) {
            userdao.insert(employer);
            return json.toJson(employer.getId());
        }
        return null;
    }

    public String registrationEmployee(String requestJsonString) throws ErrorException {
        Employee employee = json.fromJson(requestJsonString, Employee.class);
        if (userdao.getManyEmployee().contains(employee)) {
            userdao.insert(employee);
            return json.toJson(employee.getId());
        }
        return null;
    }

    public String login(String requestJsonString) {
        Session session = json.fromJson(requestJsonString, Session.class);
        for (Session session1 : sessiondao.getSessions()) {
            if (session1.getLogin().equals(session.getLogin()) &&
                    session1.getPassword().equals(session.getPassword())) {
                return json.toJson(session1.getToken());
            }
        }
        return json.toJson("Неверный логин или пароль!");
    }



    public void clearServer() {
        userdao.getManyEmployee().clear();
        userdao.getManyEmployer().clear();
        vacancydao.getManyVacancy().clear();
    }
}
