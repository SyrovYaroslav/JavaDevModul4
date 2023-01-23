import databaseDto.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxWorkerSalary> findMaxWorkerSalary() {
        List<MaxWorkerSalary> maxWorkerSalaryList = new ArrayList<>();
        try(Statement st = Database.getInstanse().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(faileReader("sql/find_max_salary_worker.sql"));

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                MaxWorkerSalary maxWorkerSalary = new MaxWorkerSalary(name, salary);
                maxWorkerSalaryList.add(maxWorkerSalary);
            }

            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maxWorkerSalaryList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        try(Statement st = Database.getInstanse().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(faileReader("sql/find_max_projects_client.sql"));

            while (rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");

                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(name, projectCount);
                maxProjectCountClientList.add(maxProjectCountClient);
            }

            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maxProjectCountClientList;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjectList = new ArrayList<>();
        try(Statement st = Database.getInstanse().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(faileReader("sql/find_longest_project.sql"));

            while (rs.next()) {
                String name = rs.getString("name");
                int monthCount = rs.getInt("month_count");

                LongestProject longestProject = new LongestProject(name, monthCount);
                longestProjectList.add(longestProject);
            }

            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return longestProjectList;
    }

    public List<YoungestOrEldestWorkers> findYoungestOrEldestWorkers() {
        List<YoungestOrEldestWorkers> youngestOrEldestWorkersList = new ArrayList<>();
        try(Statement st = Database.getInstanse().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(faileReader("sql/find_youngest_eldest_workers.sql"));

            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));

                YoungestOrEldestWorkers youngestOrEldestWorkers = new YoungestOrEldestWorkers(type, name, birthday);
                youngestOrEldestWorkersList.add(youngestOrEldestWorkers);
            }

            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return youngestOrEldestWorkersList;
    }

    public List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        try(Statement st = Database.getInstanse().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(faileReader("sql/print_project_prices.sql"));

            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("prise");

                ProjectPrices projectPrices = new ProjectPrices(name, price);
                projectPricesList.add(projectPrices);
            }

            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return projectPricesList;
    }

    private String faileReader(String faileName) {
        try {
            return String.join(
                    "\n",
                    Files.readAllLines(Paths.get(faileName))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
