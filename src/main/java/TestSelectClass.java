import databaseDto.*;

import java.sql.SQLException;
import java.util.List;

public class TestSelectClass {
    public static void main(String[] args) {
        List<ProjectPrices> projectPrices = new DatabaseQueryService().findProjectPrices();
        List<YoungestOrEldestWorkers> youngestOrEldestWorkers = new DatabaseQueryService().findYoungestOrEldestWorkers();
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxWorkerSalary> maxWorkerSalary = new DatabaseQueryService().findMaxWorkerSalary();
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();

        System.out.println("maxWorkerSalary = " + maxWorkerSalary);
        System.out.println("maxProjectCountClients = " + maxProjectCountClients);
        System.out.println("longestProjects = " + longestProjects);
        System.out.println("youngestOrEldestWorkers = " + youngestOrEldestWorkers);
        System.out.println("projectPrices = " + projectPrices);


    }
}
