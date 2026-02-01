1. Write a sql query for report that provides the following information for each person in persons table, regardless if there
is an address for each of those people.

 select p.firstName, p.lastName, a.city, a.State from Persons p LEFT JOIN Address a ON p.person.id = a.personId;

2. Second highest Salary
   select max(Salary) SecondHighestSalary from Employee where salary  < (Select max(salary) from Employee);

 WITH CTE as (select distinct salary from Employee order by salary desc limit 2)
 select Salary as SecondHighestSalary from CTE order by Salary ASC limit 1;

 3. Nth Highest Salary
    Select distinct salary from Employee order by desc limit 1 offset N-1;

    SELECT salary
    FROM employee e1
    WHERE N-1 = (
        SELECT COUNT(DISTINCT salary)
        FROM employee e2
        WHERE e2.salary > e1.salary
    );

 4. SQL problem on LeetCode asks you to assign ranks to student scores
 If using MySQL (older versions, no window functions)

 select score, DENSE_RANK() over (order by Score DESC) AS RANK from Scores order by desc;
 select s1.score, (select count(distinct s2.Score) from Score s1 where s2.score > s1.score) + 1 ) as RANK from Score s1 order by s1.Score desc;

 5. select num from numbers group by num HAVING COUNT(*) =3;

 6. select a.num as consecutiveNums as from Logs a JOIN Logs b on a.id = b.id + 1 and a.num = b.num JOIN Logs c ON a.id = c.id + 2 and a.num = c.num;

 7. Employee earning more then there managers
    select e1.name as Employee e1 join Employee e2 on e1.id = e2.managerId and e1.salary > e2.salary;

 8. Write a sql




