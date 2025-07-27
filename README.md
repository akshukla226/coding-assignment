# Assumptions and key points

- Data is in CSV format with employee details.
- Each employee has: ID, firstname,lastname, salary, and manager ID
- Only one employee (the CEO) has no managerId.
- Compare manager’s salary to average salary of their subordinates.
- If an employee has more than 4 managers above, it's marked as a "too long" reporting line.
