SELECT NAME, COUNT(CLIENT_ID) AS PROJECT_COUNT FROM client JOIN project ON client.ID=CLIENT_ID GROUP BY CLIENT_ID;