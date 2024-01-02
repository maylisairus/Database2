SELECT project.ID, SUM (SALARY*DATEDIFF(MONTH, START_DATE, FINISH_DATE)) AS PRICE FROM project_worker JOIN worker ON WORKER_ID=worker.ID JOIN project ON PROJECT_ID=project.ID GROUP BY PROJECT_ID ORDER BY PRICE DESC;