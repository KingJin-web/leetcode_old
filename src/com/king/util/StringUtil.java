package com.king.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.king.ListNode;
import com.king.TreeNode;
import com.mysql.cj.xdevapi.JsonArray;

import com.mysql.cj.xdevapi.JsonValue;
import net.sf.json.JSONArray;

import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 13:35
 */
public class StringUtil {
    private static Logger logger = Logger.getLogger(StringUtil.class.getName());

    /**
     * Convert String to int, return the specified value if it fails
     *
     * @param s
     * @param n
     * @return
     */
    private static int getInt(String s, int n) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
//            MyPrint.printError(e.getMessage());
            logger.info(e.getMessage());
            return n;
        }
        return num;
    }

    /**
     * Convert String to int, return zero if it fails
     *
     * @param s
     * @return
     */
    public static int getInt(String s) {
        return getInt(s, 0);
    }

    //String str = "[1,2,3,4,5,6,7,8,9]" --> int[]
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    //properties = [[1,5],[10,4],[4,3]] --> int[][]
    public static int[][] stringToIntegerArray2(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        Gson gson = new Gson();
        gson.toJson(stringToInt2dArray(input));
        //MyPrint.print(a);
        return new int[1][2];
    }
    public static String[] stringToStringArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new String[0];
        }
        return input.split(",");
    }
    //String str = "[1,2,3,4,5,6,7,8,9]" --> ListNode
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static int[][] stringToInt2dArray(String input) {
        JSONArray jsonArray = JSONArray.fromObject(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JSONArray cols = jsonArray.getJSONArray(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }


    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static boolean stringToBool(String input) {
        return input.toLowerCase() == "true";
    }


    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "©¦   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "©¸©¤©¤ " : "©°©¤©¤ ") + node.val);

        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "©¦   "), true);
        }
    }

    public static void prettyPrintTree(TreeNode node) {
        prettyPrintTree(node, "", true);
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Empty LinkedList");
        }
    }


    public static String doubleToString(String input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static void main(String[] args) {
        MyPrint.print(getInt("22"));
        MyPrint.print(getInt("--22"));
        MyPrint.print(getInt(""));

        MyPrint.print(stringToIntegerArray("[1,2,3,4,5,6,7,8,9]"));
        stringToListNode("[1,2,3,4,5,6,7,8,9]").println();
        MyPrint.print(stringToListNode("[1,2,3,4,5,6,7,8,9]"));
        MyPrint.print(integerArrayToString((stringToIntegerArray("[1,2,3,4,5,6,7,8,9]")), 8));
        MyPrint.print( stringToInt2dArray("[[5,5],[6,3],[3,6]]"));
        stringToIntegerArray2("[[5,5],[6,3],[3,6]]");
    }


}
