SELECT 
    c.name,
    ct.name,
    c.Population
FROM
    country c
        INNER JOIN
    city ct ON c.Code = ct.CountryCode
        INNER JOIN
    countrylanguage cl ON ct.CountryCode = cl.CountryCode
WHERE
    c.Region = 'Southern and Central Asia'
        AND c.GovernmentForm = 'Republic'
        AND cl.Language = 'Russian'
        AND cl.IsOfficial = TRUE