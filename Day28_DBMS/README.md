# 📅 Day 28: Database Management Systems — Revision Notes

## 📝 Key Topics for Interview

---

### 1. DBMS vs RDBMS
| Feature | DBMS | RDBMS |
|---------|------|-------|
| Relations | No | Yes (tables) |
| Normalization | No | Yes |
| Keys | May not have | Primary, Foreign keys |
| Examples | File system, XML | MySQL, PostgreSQL, Oracle |

### 2. SQL Fundamentals
```sql
-- DDL (Data Definition Language)
CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(50), age INT);
ALTER TABLE students ADD email VARCHAR(100);
DROP TABLE students;

-- DML (Data Manipulation Language)
INSERT INTO students VALUES (1, 'Aayush', 22);
UPDATE students SET age = 23 WHERE id = 1;
DELETE FROM students WHERE id = 1;

-- DQL (Data Query Language)
SELECT * FROM students WHERE age > 20 ORDER BY name LIMIT 10;

-- Joins
SELECT s.name, c.course_name 
FROM students s 
INNER JOIN enrollments e ON s.id = e.student_id
LEFT JOIN courses c ON e.course_id = c.id;
```

### 3. ACID Properties
| Property | Description |
|----------|-------------|
| **Atomicity** | All or nothing — transaction completes fully or not at all |
| **Consistency** | DB moves from one valid state to another |
| **Isolation** | Concurrent transactions don't interfere |
| **Durability** | Committed changes survive crashes |

### 4. Normalization
| Normal Form | Rule |
|-------------|------|
| 1NF | Atomic values, no repeating groups |
| 2NF | 1NF + No partial dependency |
| 3NF | 2NF + No transitive dependency |
| BCNF | Every determinant is a candidate key |

### 5. Keys
- **Super Key**: Any set of attributes that uniquely identifies a row
- **Candidate Key**: Minimal super key
- **Primary Key**: Chosen candidate key
- **Foreign Key**: References primary key of another table
- **Composite Key**: Key with multiple attributes

### 6. Indexing
- **Primary Index**: On primary key (dense/sparse)
- **Secondary Index**: On non-key attributes
- **B+ Tree**: Most common — balanced, all data in leaves
- **Hash Index**: For equality queries

### 7. Transactions & Concurrency
- **Schedules**: Serial, Serializable, Conflict-serializable
- **Problems**: Dirty read, Non-repeatable read, Phantom read
- **Isolation Levels**: Read Uncommitted, Read Committed, Repeatable Read, Serializable
- **Locking**: Shared (S), Exclusive (X), Two-Phase Locking (2PL)

### 8. SQL Joins Visual
```
INNER JOIN  → Only matching rows
LEFT JOIN   → All from left + matching from right
RIGHT JOIN  → All from right + matching from left
FULL JOIN   → All rows from both tables
CROSS JOIN  → Cartesian product
```

### 9. Aggregate Functions
```sql
SELECT department, COUNT(*), AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
GROUP BY department
HAVING COUNT(*) > 5;
```

### 10. Important Concepts
- **View**: Virtual table from a query
- **Stored Procedure**: Precompiled SQL
- **Trigger**: Auto-executed on DML events
- **Cursor**: Row-by-row processing

---

## 🔗 Resources
- [Knowledge Gate DBMS](https://www.youtube.com/c/KnowledgeGatePlus)
- [Gate Smashers DBMS](https://www.youtube.com/c/GateSmashers)
