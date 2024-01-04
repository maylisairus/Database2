package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabasePopulateService {
    private static final String CLIENT_FILENAME="src/main/resources/data/clients.txt";
    private static final String WORKER_FILENAME = "src/main/resources/data/workers.txt";
    private static final String PROJECT_FILENAME = "src/main/resources/data/project.txt";
    private static final String PROJECT_WORKER_FILENAME = "src/main/resources/data/project_worker.txt";

    public static void main(String[] args) {
        ArrayList<Client> clients = readClients(CLIENT_FILENAME);
        ArrayList<Worker> workers = readWorkers(WORKER_FILENAME);
        ArrayList<Project> projects = readProjects(PROJECT_FILENAME);
        ArrayList< Pair<Project, Worker>> projectWorkers = readProjectWorkers(PROJECT_WORKER_FILENAME, projects, workers) ;
        for(Client client : clients){
            createClient(client);
        }

        for(Worker worker: workers){
            createWorker(worker);
        }

        for(Project project: projects){
            createProject(project);
        }
        for(Pair<Project,Worker> pair : projectWorkers){
            createProjectWorker(pair.getKey(), pair.getValue());
        }
        System.out.println("Database is filled");
    }

    public static ArrayList<Client> readClients(String filename) {
        ArrayList<Client> clients = new ArrayList<>();
        
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNext()){
                int id = scanner.nextInt();
                String name = scanner.next();
                clients.add(new Client(id, name));
            }
            scanner.close();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return clients;
    }

    public static ArrayList<Worker> readWorkers(String filename) {
        ArrayList<Worker> workers = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNext()){
                int id = scanner.nextInt();
                String name = scanner.next();
                Date birthday = Date.valueOf(scanner.next());
                Experience level = Experience.valueOf(scanner.next());
                int salary = scanner.nextInt();
                workers.add(new Worker(id, name, birthday, level, salary));
            }
            scanner.close();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return workers;
    }

    public static ArrayList<Project> readProjects(String filename) {
        ArrayList<Project> projects = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNext()){
                int id = scanner.nextInt();
                int clientId = scanner.nextInt();
                Date startDate = Date.valueOf(scanner.next());
                Date finishDate = Date.valueOf(scanner.next());
                projects.add(new Project(id, clientId, startDate, finishDate));
            }
            scanner.close();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return projects;
    }
    
    public static ArrayList< Pair<Project, Worker>> readProjectWorkers(String filename, ArrayList<Project> projects, ArrayList<Worker> workers){
        ArrayList< Pair<Project, Worker>> projectWorkers= new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNext()){
                int projectId = scanner.nextInt();
                int workerId = scanner.nextInt();
                Project project = getProjectById(projects, projectId);
                Worker worker = getWorkerById(workers, workerId);
                if(worker!=null && project!=null)
                    projectWorkers.add(new Pair<Project, Worker>(project, worker));
            }
            scanner.close();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return projectWorkers;
    }
    public static Worker getWorkerById(ArrayList<Worker> workers, int id){
        for(Worker worker: workers){
            if(worker.getId() == id){
                return worker;
            }
        }
        return null;
    }

    public static Project getProjectById(ArrayList<Project> projects, int id){
        for(Project project: projects){
            if(project.getId() == id){
                return project;
            }
        }
        return null;
    }

    public static void createWorker(Worker worker){
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            String query = "INSERT INTO worker VALUES(?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1,worker.getId());
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setDate(3, worker.getBirthday());
            preparedStatement.setString(4,worker.getLevel().toString());
            preparedStatement.setInt(5,worker.getSalary());

            preparedStatement.execute();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void createClient(Client client){
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            String query = "INSERT INTO client VALUES(?, ?);";
            PreparedStatement queryStatement = conn.prepareStatement(query);

            queryStatement.setInt(1, client.getId());
            queryStatement.setString(2, client.getName());

            queryStatement.execute();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void createProject(Project project){
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            String query = "INSERT INTO project VALUES (?,?,?,?);";

            PreparedStatement preparedStatement=conn.prepareStatement(query);
            preparedStatement.setInt(1,project.getId());
            preparedStatement.setInt(2,project.getClientId());
            preparedStatement.setDate(3,project.getStartDate());
            preparedStatement.setDate(4,project.getFinishDate());
            preparedStatement.execute();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void createProjectWorker(Project project, Worker worker){
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            String query="INSERT INTO project_worker VALUES(?,?);";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,project.getId());
            preparedStatement.setInt(2,worker.getId());
            preparedStatement.execute();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
