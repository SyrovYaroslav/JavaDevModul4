SELECT project.id AS name, SUM(DATEDIFF(month, start_date, finish_date) * salary) AS prise
FROM project_worker
JOIN project ON project_worker.project_id = project.id
JOIN worker ON project_worker.worker_id = worker.id
GROUP BY project_id
ORDER BY prise DESC;
