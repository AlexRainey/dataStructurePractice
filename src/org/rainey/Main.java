package org.rainey;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        String[] stringArgs = args[0].split(",");
        int[] nums = new int[stringArgs.length];
        for(int i = 0; i<stringArgs.length; i++){
            nums[i] = Integer.parseInt(stringArgs[i]);
        }

        //minimalTree(nums);
        //listOfDepths(nums);
        //checkBalance(nums);
        //checkBstTree(nums);
        pathsWithSum(nums);

	System.out.println("stopper");

    }

    public static void minimalTree(int[] nums){
        TreeNode root = insertToBinaryTree(nums,0,nums.length-1);
        System.out.println("stopper");
    }

    public static void listOfDepths(int[] nums){
        TreeNode root = insertToBinaryTree(nums,0,nums.length-1);

        Map<Integer, List<Integer>> result = listNodeValues(root,new HashMap<>(),1);


        System.out.println("stopper");
    }

    public static void checkBalance(int[] nums){
        TreeNode root = insertToBinaryTree(nums,0,nums.length-1);

        int balance = getBranchDepth(root);


        System.out.println("stopper");
    }

    public static void checkBstTree(int[] nums){
        TreeNode root = insertToBinaryTree(nums,0,nums.length-1);

        boolean result = isBstNode(root);

        System.out.println("stopper");
    }

    public static void pathsWithSum(int[] nums){
        TreeNode root = insertToBinaryTree(nums,0,nums.length-1);

        int result = countSumPaths(root,1,0);

        System.out.println("stopper");
    }

    public static int countSumPaths(TreeNode root, int target, int upstreamTotal){
        if(root==null){return 0;}
        upstreamTotal=upstreamTotal+root.getValue();
        int rootResult = upstreamTotal==target?1:0;
        int leftResult = countSumPaths(root.getLeft(),target,upstreamTotal);
        int rightResult = countSumPaths(root.getRight(),target,upstreamTotal);
        int leftResultAsRoot = countSumPaths(root.getLeft(),target,0);
        int rightResultAsRoot = countSumPaths(root.getRight(),target,0);
        return rootResult+leftResult+rightResult+leftResultAsRoot+rightResultAsRoot;

    }

    public static boolean isBstNode(TreeNode root){
        if(root==null){return true;}

        boolean leftBranch = isBstNode(root.getLeft());
        boolean rightBranch = isBstNode(root.getRight());
        if(!leftBranch||!rightBranch){return false;}

        if (root.getLeft()!=null) {
            int leftVal = root.getLeft().getValue();
            if (leftVal>root.getValue()){return false;}
        }
        if (root.getRight()!=null) {
            int rightVal = root.getRight().getValue();
            if (rightVal<root.getValue()){return false;}
        }

        return true;
    }

    public static Map<Integer, List<Integer>> listNodeValues(TreeNode root, Map<Integer, List<Integer>> map, int level){
        if (root==null) {return map;}
        if(map.containsKey(level)){
            map.get(level).add(root.getValue());
        } else {
            List<Integer> levelList = new ArrayList<>(root.getValue());
            levelList.add(root.getValue());
            map.put(level,levelList);
        }

        listNodeValues(root.getLeft(),map,level+1);
        listNodeValues(root.getRight(),map,level+1);

        return map;
    }

    public static int getBranchDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if (root.getLeft()==null && root.getRight()==null){
            return 1;
        }
        int leftDepth = 1+getBranchDepth(root.getLeft());
        int rightDepth = 1+getBranchDepth(root.getRight());

        return abs(leftDepth-rightDepth);
    }

    public static TreeNode insertToBinaryTree(int[] nums, int start, int end){
        if(end<=start){
            return new TreeNode(nums[start],null,null);
        }
        int rootIndex = (end+start)/2;
        TreeNode rootNode = new TreeNode(nums[rootIndex],null,null);
        rootNode.setLeft(insertToBinaryTree(nums,start,rootIndex-1));
        rootNode.setRight(insertToBinaryTree(nums,rootIndex+1,end));
        return rootNode;
    }

    public static void linkedList(String[] args){
        String[] initial = args[0].split(",");

        LinkedList list = new LinkedList();

        for(String i:initial){
            ListNode node = new ListNode(Integer.parseInt(i),null,null);
            list.append(node);
        }
    }
}
