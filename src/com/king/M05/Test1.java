package com.king.M05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 690. 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/submissions/
 * @author: King
 * @create: 2021-05-01 10:23
 */
public class Test1 {

    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了91.61%的用户
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }
}




// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public Employee(int id, int importance) {
        this.id = id;
        this.importance = importance;
    }

    public Employee() {
    }
};
