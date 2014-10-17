import java.util.*;

/**
 * Permutations 
 * 
 * Given a collection of numbers, return all possible permutations.
 * @author huangxin
 *
 */

public class Solution44 {
	/*
	 * 解法1： 采用递归的方式。
	 * 每次从当前层的num数组中取出一个元素放在第一个，剩下的数字传递给下一层做一次全排。
	 * 直到num数组为空。
	 */
    public static ArrayList<ArrayList<Integer>> permute_Helper(ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // base condition
        if (num.size() == 0) {
        	return null;
        }
        if (num.size() == 1) {
        	result.add(num);
        	return result;
        }
        
        ArrayList<ArrayList<Integer>> nextLevel;
        ArrayList<Integer> toNext = new ArrayList<Integer>(num);
        
        for (int i = 0; i < num.size(); i++) {
        	int temp = toNext.remove(i); //remove current value
        	nextLevel = permute_Helper(toNext);
        	for (ArrayList<Integer> list : nextLevel) {
        		list.add(0, temp);
        		result.add(list);
        	}
        	toNext = new ArrayList<Integer>(num);
        }   
        return result;
    }
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<Integer> newNum = new ArrayList<Integer>();
    	for (int x : num) {
    		newNum.add(x);
    	}
    	return permute_Helper(newNum);
    }
    
    /*
     * 解法2：DFS深度优先搜索的应用。在实现DFS的过程中沿path完成了全排序
     * 1）难点是理解乡下搜索的过程中是如何构造树的以及返回时的现场恢复。
     * 2）理解这里想list添加已访问的元素其实就是实现对当前结点访问的函数
     * 3）理解相当于用int[] num充当了储存graph的adjacecy matrix
      */
    
    public static ArrayList<ArrayList<Integer>> permute_DFS1(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); //储存整个函数的结果
    	ArrayList<Integer> list = new ArrayList<Integer>(); //储存DFS的结果
    	boolean[] isVisited = new boolean[num.length]; //DFS需要储存已访问结点以避免死循环
    	
    	permute_DFS1_Helper(num, list, result, isVisited);
    	
    	return result;
    }
    
    private static void permute_DFS1_Helper(int[] num, ArrayList<Integer> list, 
    		ArrayList<ArrayList<Integer>> result, boolean[] isVisited) {
    	//已经完成了一次全排，将结果写入result
    	if(list.size() == num.length) {
    		result.add(list);
    	}
    	
    	//DFS的应用
    	for (int i = 0; i < num.length; i++) {
    		if (!isVisited[i]){
    			isVisited[i] = true;
    			list.add(num[i]);
    			//递归访问下一层
    			permute_DFS1_Helper(num, list, result, isVisited);
    			//回复现场
    			list.remove(list.size() - 1);
    			isVisited[i] = false;
    		}
    	}
    }
    
    /*
     * 解法3 ：其实质更介乎递归与DFS方法之间。主动挖去了已访问的结点而不是采用DFS标准的isVisited[]数组实现
     */
    public static ArrayList<ArrayList<Integer>> permute_DFS2 (int[] num) {
    	ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> done = new ArrayList<Integer>();
    	ArrayList<Integer> rest = new ArrayList<Integer>();
    	for (int x : num) {
    		rest.add(x);
    	}
    	permute_DFS2_Helper(result, done, rest);
    	return result;
    }
    
    private static void permute_DFS2_Helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> done,
    	ArrayList<Integer> rest) {
    	//Base condition
    	if (rest.size() == 0) {
    		result.add(done);
    		return;
    	}
    	
    	//DFS
    	for (int i = 0; i < rest.size(); i++) {
    		done.add(rest.get(i));
    		ArrayList<Integer> toNext = new ArrayList<Integer>(rest);
    		toNext.remove(i);
    		permute_DFS2_Helper(result, done, toNext);
    		//恢复现场
    		done.remove(done.size() - 1);
    	}
    }
    
    
    public static void main(String[] args) {
    	int[] test = {0, 1};
    	ArrayList<ArrayList<Integer>> res = permute(test);
    	System.out.println(res);
    }
}
