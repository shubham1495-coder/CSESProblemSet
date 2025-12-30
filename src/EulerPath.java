import java.util.*;

public class EulerPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        if(eulerPathExist(n,graph)==1){
            printPath(graph);
        }else{
            System.out.println("No");
        }
    }

    static int eulerPathExist(int n, int[][] graph){
        int odd = 0;
        for(int i = 0; i < n; i++){
            int curr = 0;
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 1){
                    curr++;
                }
            }
            if(curr%2==1){
                odd++;
            }
        }
        return odd>2?0:1;
    }

    static void printPath(int[][] graph){
        int start = 0;
        int n = graph.length;
        for(int i = 0; i < n; i++){
            int curr = 0;
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 1){
                    curr++;
                }
            }
            if(curr%2==1){
                start = i;
                break;
            }
        }
        List<Integer> path = new ArrayList<>();
        findEulerPath(start,path,graph);
        for(int ele :path){
            System.out.print(ele+" ");
        }
    }

    static void findEulerPath(int start,List<Integer> path,int[][] graph){
        int n = graph.length;
        for(int i = 0; i < n; i++){
            if(graph[start][i] == 1){
                graph[start][i]= 0;
                graph[i][start]= 0;
                findEulerPath(i,path,graph);
            }
        }
        path.add(start);
    }
}
